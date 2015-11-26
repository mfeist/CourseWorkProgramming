/**
 * Author: mfeist
 * Date: 11/2/15
 * CSCI 459
 * Project 2
 */

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>
#include <sys/types.h> 
#include <sys/socket.h>
#include <netinet/in.h>
#include <netdb.h> 
#include <pthread.h>
#include "structs.h"

void error(const char *msg)
{
    perror(msg);
    exit(1);
}

/*Global variables that will be accessed in the thread function  */
int clientlist[2]; /*the socket numbers through with the 2 clients (e.g. data link layer) are connected to this wire*/
pthread_t threadlist[2];


/*the thread function that will receive frames from socket (i.e. data_link layer) and send the received frames to another socket*/  
void * onesocket ( int threadsockfd)
{
	/*add codes to declare local variables*/
	int nThread;
	frame incoming_frame;

	 while (1)
	 {
		/*add codes to receive a frame from threadsocketfd*/
		nThread = read(threadsockfd, &incoming_frame, sizeof(frame));
		if(nThread < 0)
			error("ERROR receiving frame");
		
		printf("Received a frame from machine: %s\n", incoming_frame.my_packet.nickname);
		
		
		/*if the message in the frame in EXIT close the socket and terminate this thread using
				close(threadsockfd);
				return NULL;
		 other wise send the frame to the other socket (which is stored in clientlist) 
		*/

		if(strcmp(incoming_frame.my_packet.message, "EXIT\n") == 0)
		{
			close(threadsockfd);
			return NULL;
		}
		else
		{
			int i;
			for(i = 0; i < 2; i++)
			{
				if(clientlist[i] != threadsockfd)
				{
					printf("Sending it to machine on the other side...\n\n");
					nThread = write(clientlist[i], &incoming_frame, sizeof(frame));
					if(nThread < 0)
						error("ERROR writing to socket");
				}
			}
		}
			
	 }
}

int main(int argc, char *argv[])
{
	/*add codes to declare local variables*/
	int sockfd, newsockfd, portno, i;
	socklen_t clilen;
	struct sockaddr_in serv_addr, cli_addr;

	/*check the number of arguments*/
     if (argc < 2) {
         fprintf(stderr,"ERROR, no port provided\n");
         exit(1);
     }

	/*add codes to create a socket (sockfd), bind its address to it and listen to it*/
	sockfd = socket(AF_INET, SOCK_STREAM, 0);
	
	if(sockfd < 0)
		error("ERROR openeing socket");
	
	bzero((char *) &serv_addr, sizeof(serv_addr));
	portno = atoi(argv[1]);
	serv_addr.sin_family = AF_INET;
	serv_addr.sin_addr.s_addr = INADDR_ANY;
	serv_addr.sin_port = htons(portno);
	
	if(bind(sockfd, (struct sockaddr *) &serv_addr, sizeof(serv_addr)) < 0)
		error("ERROR on binding\n");
	
	for (i=0;i<2;i=i+1) /*only accept two requests*/
	{
		/*accept a request from the data link layer*/
		listen(sockfd, 5);
		clilen = sizeof(cli_addr);
		 newsockfd = accept(sockfd, (struct sockaddr *) &cli_addr, &clilen);
		
		if(newsockfd < 0)
			error("ERROR accepting newsockfd\n");
		/* store the new socket into clientlist*/
		printf("Create new socket: %d\n", newsockfd);
		 clientlist[i]=newsockfd;
		 
		 /*create a thread to take care of the new connection*/
		 pthread_t pth;	/* this is the thread identifier*/
		 pthread_create(&pth,NULL,onesocket,clientlist[i]);
		 threadlist[i]=pth; /*save the thread identifier into an array*/ 
	}
	close(sockfd); /*so that wire will not accept further connection request*/
	pthread_join(threadlist[0],NULL);
	pthread_join(threadlist[1],NULL); /* the main function will not terminated untill both threads finished*/
	return 0;

}
