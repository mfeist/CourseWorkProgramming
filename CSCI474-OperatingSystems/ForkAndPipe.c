/**
 *  Author: mfeist
 *  Date: 10/19/2015
 *  CSCI 474
 *  Project 1
 *  Need to include .dat files
*/

#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <string.h>
#include <sys/types.h>
#include <sys/socket.h>
#include <netinet/in.h>
#include <netdb.h>
#include <math.h>
#include <time.h>

#define MAX_STRING 20
#define FILE1_SIZE 1000
#define FILE2_SIZE 10000
#define FILE3_SIZE 100000
#define FILE4_SIZE 1000000

//errors
void error(const char *msg)
{
    perror(msg);
    exit(0);
}

int main(int argc, char *argv[])
{
	FILE *fp;
	char *fn[MAX_STRING];
	char str[10];
	int val, arraySize, buffer, process, i, j;
	int sum = 0;
	char *s, buff[1024];
	clock_t begin, end;
	double time_spent;
	
	//make sure 3 parameters are passed
	if (argc < 3) {
       fprintf(stderr,"usage %s filename processor\n", argv[0]);
       exit(0);
    }
	
	//using file name as an arguement
	strcpy(fn,argv[1]);
	
	//number of processes as an argument
	process = atoi(argv[2]);
	
	//make sure processes is 1, 2, or 4
	if(!(process == 1 | process == 2 | process == 4))
	{
		fprintf(stderr, "Processes must be 1, 2, or 4\n");
		exit(0);
	}
	
	//open file for reading
	fp = fopen(fn, "r");
	
	//if-else if statements to fill the size of the array depending on the file passed
	if(strcmp(fn, "file1.dat") == 0)
	{
		arraySize = FILE1_SIZE;
	}
	
	else if(strcmp(fn, "file2.dat") == 0)
	{
		arraySize = FILE2_SIZE;
	}
	
	else if(strcmp(fn, "file3.dat") == 0)
	{
		arraySize = FILE3_SIZE;
	}
	
	else if(strcmp(fn, "file4.dat") == 0)
	{
		arraySize = FILE4_SIZE;
	}
	
	//divide up how many tasks the threads will have
	int tasksPerProcess = arraySize/process;
	
	//multi dimensional array to be filled with the data
	int data[process][tasksPerProcess];
	
	//fill multi array from .dat file
	//size for number of processes
	for(i = 0; i < process; i++)
	{
		//size for number of tasks per processes
		for(j = 0; j < tasksPerProcess; j++)
		{
			//grab line from .dat file
			fgets(str, 10, fp);
			//convert string to int
			sscanf(str, "%d", &val);
			//populate array
			data[i][j] = val;
		}
	}
	
	//close file
	fclose(fp);
	
	//time instance
	begin = clock();
	
	//creating fork and pipes
	int fds[process][2];
	for(i = 0; i < process; i++)
	{
		pipe(fds[i]);
	}
	
	//write to fork
	for(i = 0; i < process; i++)
	{
		if(fork() == 0)
		{
			int tmp = 0;
			for(j = 0; j < tasksPerProcess; j++)
			{
				tmp += data[i][j];
			}
			write(fds[i][1], &tmp, sizeof(int));
			exit(0);
		}
	}
	
	//read from fork
	for(i = 0; i < process; i++)
	{
		read(fds[i][0], &buffer, sizeof(int));
		sum += buffer;
	}
	
	//time instance
	end = clock();
	
	//To obtain the time
	time_spent = (double) (end - begin)/CLOCKS_PER_SEC;
	
	//show which file is opened
	printf("file opened: %s\n", fn);
	
	//show number of processors used
	printf("Number of processes: %d\n", process);
	
	//size of the file opened
	printf("Size of data: %ld\n", sizeof(data)/sizeof(int));
	
	//sum of the file
	printf("The sum is: %d\n", sum);
	
	//time of execution of the child processes
	printf("Time in seconds: %f\n", time_spent);
	
	return 0;
}