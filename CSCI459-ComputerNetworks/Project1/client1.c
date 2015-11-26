/**
 *  Author: mfeist
 *  Date: 10/05/15
 *  CSCI 459
 *  Project 1
*/

#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <string.h>
#include <sys/types.h>
#include <sys/socket.h>
#include <netinet/in.h>
#include <netdb.h>

void error(const char *msg)
{
    perror(msg);
    exit(0);
}

int main(int argc, char *argv[])
{
    int sockfd, portno, n;
    struct sockaddr_in serv_addr;
    struct hostent *server;

    char buffer[256];
    if (argc < 3) {
       fprintf(stderr,"usage %s hostname port\n", argv[0]);
       exit(0);
    }
    portno = atoi(argv[2]);
    sockfd = socket(AF_INET, SOCK_STREAM, 0);
    if (sockfd < 0) 
        error("ERROR opening socket");

    server = gethostbyname(argv[1]);
	
	if (server == NULL) {
		fprintf(stderr,"ERROR, no such host\n");
        exit(0);
    }

    bzero((char *) &serv_addr, sizeof(serv_addr));
    serv_addr.sin_family = AF_INET;
    bcopy((char *)server->h_addr, 
         (char *)&serv_addr.sin_addr.s_addr,
         server->h_length);
    serv_addr.sin_port = htons(portno);

    if (connect(sockfd,(struct sockaddr *) &serv_addr,sizeof(serv_addr)) < 0) 
        error("ERROR connecting");

    while(1)
    {
    	printf("Please enter the message: ");
    	bzero(buffer,256);
    	fgets(buffer,255,stdin);
		//take message from the standard input
		
		n = write(sockfd,buffer,strlen(buffer));
		//send message to the server
		
		if (n < 0)
    		error("ERROR writing to socket");
		
		if (strcmp(buffer, "EXIT\n") == 0)
		{
			printf("Network Terminated\n");
			close(sockfd);
			return 0;
		}
		//close connection if "EXIT"
    	
    	bzero(buffer,256);
		
    	n = read(sockfd,buffer,255);
		
    	if (n < 0)
    		error("ERROR reading from socket");
    	printf("%s\n",buffer);
		//recieve acknowledgement from the server and display it
    }
    close(sockfd);
    return 0;
}
