/**
 *  Author: mfeist
 *  Date: 11/30/15
 *	CSCI459
 *	Project 3
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
	char buffer[256];
	char *message;
	struct sockaddr_in serv_addr;
	struct hostent *server;
	
	if(argc < 4)
	{
		fprintf(stderr, "Usage %s host_name file_path port_number\n", argv[0]);
		exit(0);
	}
	
	portno = atoi(argv[3]);
	sockfd = socket(AF_INET, SOCK_STREAM, 0);
	if(sockfd < 0)
		error("ERROR opening socket");
	
	server = gethostbyname(argv[1]);
	if(server == NULL)
	{
		fprintf(stderr, "ERROR, no such host\n");
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
	
	asprintf(&message,"GET %s HTTP/1.1\r\nHost:%s\r\n\r\n",argv[2],argv[1]);
	printf("%s", message);
	
	n = write(sockfd,message,strlen(message));
	if (n < 0) 
         error("ERROR writing to socket");
	 
	 do
	 {
		 bzero(buffer, 256);
		 n = read(sockfd, buffer, 255);
		 if(n < 0)
			 error("ERROR reading from socket");
		printf("%s", buffer);
	 } while(n > 0);
	
	close(sockfd);
	return 0;
}
