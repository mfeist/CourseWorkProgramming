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

/*global variables to be used in the threads*/
int network_layersockfd;//the socket through which the network layer is connected.
int wiresockfd; //the socket through which the wire is connected.


/*the thread function that receives frames from the wiresocket and sends packets to the network_layer */
void * rcvfromwiresend2network_layer ( char *argv[] )
{
	/*add codes to declare locals*/
	int nThread;
	frame incoming_frame;

	 while (1)
	 {
		 /*add codes receive a frame from wire*/
		 nThread = read(wiresockfd, &incoming_frame, sizeof(incoming_frame));
		 if(nThread < 0)
			error("ERROR reading\n");
			
		printf("Received a frame from wire.\n");
		printf("\tSequence number: %d\n", incoming_frame.seq_num);
		printf("\tFrame type: %d\n", incoming_frame.type);
			 
		/*add codes to send the included packet to the network layer*/
		printf("\tSending the included packet to network_layer...\n\n");
		nThread = write(network_layersockfd, &incoming_frame.my_packet, sizeof(packet));
		
		if(nThread < 0)
			error("ERROR sending\n");
		
	 }
	 return NULL;
}


int main(int argc, char *argv[])
{
	/*add codes to declare local variables*/
	int sockfd, portno, wireportno;
	socklen_t clilen;
	struct sockaddr_in serv_addr, cli_addr;
	struct hostent *server;
	int n;
	
	int framenumber;
	packet incoming_packet;
	frame outgoing_frame;
	
	/*check number of arguments*/
     if (argc < 4) {
		 fprintf(stderr,"Usage: %s  wire__IP  wire_port data_port\n",argv[0] );
         exit(1);
     }

	/* add codes to connect to the wire. Assign value to global variable wiresockfd */
	wireportno = atoi(argv[2]);
	wiresockfd = socket(AF_INET, SOCK_STREAM, 0);
	if(wiresockfd < 0)
		error("ERROR opening socket\n");
		
	server = gethostbyname(argv[1]);
	if(server == NULL)
	{
		fprintf(stderr,"ERROR no host\n");
		exit(0);
	}
	
	bzero((char *) &serv_addr, sizeof(serv_addr));
	serv_addr.sin_family = AF_INET;
	bcopy((char *)server->h_addr, (char *)&serv_addr.sin_addr.s_addr, server->h_length);
	serv_addr.sin_port = htons(wireportno);
	if(connect(wiresockfd,(struct sockaddr *) &serv_addr,sizeof(serv_addr)) < 0) 
        error("ERROR connecting");
	
	/*generate a new thread to receive frames from the wire and pass packets to the network layer */
	pthread_t wirepth;	// this is our thread identifier
	pthread_create(&wirepth,NULL,rcvfromwiresend2network_layer, NULL);

	/*add codes to create and listen to a socket that the network_layer will connect to. Assign value to global variable network_layersockfd*/
    sockfd = socket(AF_INET, SOCK_STREAM, 0);
	if(sockfd < 0)
		error("ERROR opening socket\n");
	
	bzero((char *) &serv_addr, sizeof(serv_addr));
	portno = atoi(argv[3]);
	serv_addr.sin_family = AF_INET;
    serv_addr.sin_addr.s_addr = INADDR_ANY;
    serv_addr.sin_port = htons(portno);
	if(bind(sockfd, (struct sockaddr *) &serv_addr, sizeof(serv_addr)) < 0)
		error("ERROR on bonding");
	
	listen(sockfd, 5);
	clilen = sizeof(cli_addr);
	network_layersockfd = accept(sockfd, (struct sockaddr *) &cli_addr, &clilen);
	if(network_layersockfd < 0)
		error("ERROR on accept");
	
	printf("Create new socket: %d\n", network_layersockfd);
	close(sockfd);
	
	framenumber = 0;
	
	/*the main function will receive packets from the network layer and pass frames to wire*/
	 while (1)
	 {
		/*add codes to receive a packet from the network layer*/
		n = read(network_layersockfd, &incoming_packet, sizeof(packet));
		if(n < 0)
			error("ERROR receiving\n");
		
		printf("Received a packet from network_layer\n");
		
		/* add codes to wrap the packet into a frame*/	
		bzero((char *) &outgoing_frame, sizeof(frame));
		outgoing_frame.seq_num = framenumber;
		outgoing_frame.type = 0;
		framenumber += 1;
		
		strcpy(outgoing_frame.my_packet.nickname, incoming_packet.nickname);
		strcpy(outgoing_frame.my_packet.message, incoming_packet.message);
		
		/*add codes to send the frame to the wire*/
		printf("Sending a frame to wire...\n\n");
		n = write(wiresockfd, &outgoing_frame, sizeof(frame));
		if(n < 0)
			error("ERROR sending\n");
				
		/*if the message is "EXIT" */
		 if (strcmp (incoming_packet.message, "EXIT\n")==0) 
		 {
			 pthread_cancel(wirepth); //kill the child thread
			 close(wiresockfd);
			 close (network_layersockfd); //close sockets
			 return 0; //terminate the main function
		 }

	 }

}
