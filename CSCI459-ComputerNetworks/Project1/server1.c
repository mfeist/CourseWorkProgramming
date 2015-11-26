/**
 *  Author: mfeist
 *  Date: 10/05/15
 *  CSCI 459
 *  Project 1
*/

#include <stdio.h>
#include <stdlib.h>				//for IOs
#include <string.h>
#include <unistd.h>
#include <sys/types.h>			//for system calls
#include <sys/socket.h>			//for sockets
#include <netinet/in.h>			//for internet 
#include <pthread.h>		//for thread

void error(const char *msg)	
{
    perror(msg);
    exit(1);
}

void *threadFunction(int mysockfd)
{
	char bufferThread[256];
	int nThread;
	
	while(1)
	{
		bzero(bufferThread,256);
		nThread = read(mysockfd,bufferThread,255);
		//read message from mysockfd
		
		if (nThread < 0) error("ERROR reading from socket");
		printf("Here is the message: %s\n",bufferThread);
		
		if(strcmp(bufferThread, "EXIT\n") == 0)
		{
			printf("Network Terminated\n");
			close(mysockfd);
			return NULL;
		}
		//close mysockfd if message is "EXIT\n"
			
		nThread = write(mysockfd,"I got your message",18);
		//acknowledge to client
		
		if (nThread < 0) error("ERROR writing to socket");
	}
	
	close(mysockfd);
	return NULL;
}

int main(int argc, char *argv[])
{
     int sockfd, newsockfd, portno;
     socklen_t clilen;
     char buffer[256];
     struct sockaddr_in serv_addr, cli_addr;
     int n;

     if (argc < 2) {
         fprintf(stderr,"ERROR, no port provided\n");
         exit(1);
     }

     sockfd = socket(AF_INET, SOCK_STREAM, 0);

     if (sockfd < 0) 
        error("ERROR opening socket");

     bzero((char *) &serv_addr, sizeof(serv_addr));
     portno = atoi(argv[1]);
     serv_addr.sin_family = AF_INET;
     serv_addr.sin_addr.s_addr = INADDR_ANY;
     serv_addr.sin_port = htons(portno);


     if (bind(sockfd, (struct sockaddr *) &serv_addr,
              sizeof(serv_addr)) < 0) 
              error("ERROR on binding");
	 
	 while(1)
	 {

		listen(sockfd,5);

		clilen = sizeof(cli_addr);
		newsockfd = accept(sockfd, 
					(struct sockaddr *) &cli_addr, 
					&clilen);
		if (newsockfd < 0) 
		error("ERROR on accept");
	
		pthread_t pth;	//this is the thread identifier
		pthread_create(&pth,NULL,threadFunction,newsockfd);
		//generage a new thread
		
	 }
	 close(sockfd);
     return 0; 
}