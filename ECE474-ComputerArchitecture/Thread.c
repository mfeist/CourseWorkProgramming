/**
 *  Author: Mathew Feist & Alex Volk
 *  Date: 10/8/15
 *  ECE 474
 *  Programming Assignment 1
 */

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/socket.h>
#include <netinet/in.h>
#include <pthread.h>
#include <netdb.h>
#include <time.h>
#include <math.h>

#define NUM_THREAD 50
#define SIZE_OF_ARRAY 5000

//global variables
int minisum[NUM_THREAD];
int numbers[SIZE_OF_ARRAY];

//the variables that we want to pass into threadFunction
struct threadData 
{
	int start, stop, threadNumber;
	int *array;
};

//threadFunction that will calculate the sums independently
void *threadFunction(struct threadData * td)
{
	struct threadData *data = (struct threadData *) td;
	int start = data -> start;
	int stop = data -> stop;
	int threadNumber = data -> threadNumber;
	int *array = data -> array;
	int i;
	
	for(i = start; i < stop; i++)
	{
		minisum[threadNumber] += numbers[i];
	}
	
	return NULL;
}
int main ()
{
	int finalsum = 0;
	double average;
	clock_t begin, end;
	double time_spent;
	int i, j;
	
	//fill the array with 5000 numbers
	for(i = 0; i < SIZE_OF_ARRAY; i++)
	{
		numbers[i] = i + 1;
	}
	
	//to initially have 0 in the array that will be summing the individual threads
	for(i = 0; i < NUM_THREAD; i++)
	{
		minisum[i] = 0;
	}
	
	//time instance
	begin = clock();
	
	pthread_t pth[NUM_THREAD];
	struct threadData data[NUM_THREAD];
	
	//divides up how many tasks the threads will have
	int tasksPerThread = (SIZE_OF_ARRAY + NUM_THREAD - 1)/NUM_THREAD;
	
	//obtain the data for the structure
	//also tells the threads where to start and stop the addition
	for(j = 0; j < NUM_THREAD; j++)
	{
		data[j].start = j*tasksPerThread;
		data[j].stop = (j + 1)*tasksPerThread;
		data[j].threadNumber = j;
		data[j].array = numbers;
	}
	
	//to make sure that we do not go past our array
	data[NUM_THREAD - 1].stop = SIZE_OF_ARRAY;
	
	//create the threads
	for(j = 0; j < NUM_THREAD; j++)
	{
		pthread_create(&pth[j], NULL, threadFunction, &data[j]);
	}
	
	//make the main wait all the threads to finish
	for(j = 0; j < NUM_THREAD; j++)
	{
		pthread_join(pth[j], NULL);
	}
	
	//add up the sums from the threads
	for(j = 0; j < NUM_THREAD; j++)
	{
		finalsum += minisum[j];
	}
	
	//to obtain the average
	average = (double) finalsum/SIZE_OF_ARRAY;
	
	//time instance
	end = clock();
	
	//to obtain the time
	time_spent = (double)(end - begin)/CLOCKS_PER_SEC;
	
	//display the results
	printf("The sum of the array is: %i\n", finalsum);
	printf("The average of the array is: %f\n", average);
	printf("Number of threads: %i\n", NUM_THREAD);
	printf("The throughput of the process for calculation in seconds: %f\n", time_spent);
}