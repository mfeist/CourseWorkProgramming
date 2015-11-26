/**
 * Author: mfeist
 * Created on: 11/1/15
 * CSCI 474
 * Project 2
 * Use semaphores to implement event ordering
 * and mutual exclusion.
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
#include <pthread.h>
#include <semaphore.h>
#include <stdbool.h>

const int sizeOfBuffer = 5; // Only five rooms available
const int roomPrice = 200; // Price for the room

// semaphores
sem_t bufferSem; // Buffer size, guest.2.a
sem_t mutexCheckIn; // Mutual exclusion for guest2.b
sem_t eventOrderGreetCheckIn; // Event ordering for guest.2.c and check-in.a
sem_t eventOrderAssignRoom; // Event ordering for check-in.b and guest.d
sem_t mutexCheckOut; // Mutual exclusion for checkout, guest.4.a
sem_t eventOrderGreetCheckOut; // Event ordering for guest.4.b and check-out.a
sem_t eventOrderCaclBal; // Event ordering for check-out.b and guest.4.c
sem_t eventOrderMakePayment; // Event ordering for guest.4.d and check-out.c
int roomNumIn; // Global for the room number for check-in
int roomNumOut; // Global for the room number for check-out
int tempGuestNumIn; // Global for guest number for check-in
int tempGuestNumOut; // Global for guest number for check-out
int totalPrice; // Global for total price
int eventPrice; // Price for the event
bool roomOccupied[5]; // bool array to know if a room is occupied
int numOfGuests; // Global for number of guests
int numOfPool; // Global for number of guests who used the pool
int numOfRestaurant; // Global for number of guests who used the restaurant
int numOfFitCent;  // Global for number of guests who used the fitness center
int numOfBusCent;  // Global for number of guests who used the business center

//Guest function
//maybe arg not args
void *Guest(void *args)
{
	int *pointerNumber = (int *) args; // Local pointer from arguement to obtain its address
	int number = *pointerNumber; // Local variable for the value from the address
	int roomNumGuest; // Local variable for room number
	int guestEvent; // Local variable for the event
	int guestEventPrice; // Local variable for the price of the event
	int guestTotal; // Local variable for the total price
	int guestSleep; // Local variable for sleep time
	
	sem_wait(&bufferSem); // Buffer size, number of rooms available
	printf("Guest %d waits for check-in.\n", number);
	
	sem_wait(&mutexCheckIn); // Mutual exclusion
	tempGuestNumIn = number;
	printf("Guest %d goes to the check-in reservationist.\n", number);
	sem_post(&eventOrderGreetCheckIn); // Event ordering
	
	sem_wait(&eventOrderAssignRoom); // Event ordering
	roomNumGuest = roomNumIn;
	printf("Guest %d receives Room %d and completes check-in.\n", number, roomNumGuest);
	numOfGuests++; // Adds number of guests upon completion of check-in
	sem_post(&mutexCheckIn); // Mutual exclusion
	
	guestEvent = rand() % 4;
	printf("Guest %d ", number);
	switch(guestEvent)
	{
		case 0:
			printf("go to hotel swimming pool.\n");
			guestEventPrice = 0;
			numOfPool++;
			break;
		case 1:
			printf("go to hotel restaurant.\n");
			guestEventPrice = 50;
			numOfRestaurant++;
			break;
		case 2:
			printf("go to hotel fitness center.\n");
			guestEventPrice = 0;
			numOfFitCent++;
			break;
		case 3:
			printf("go to hotel business center.\n");
			guestEventPrice = 10;
			numOfBusCent++;
			break;
	}
	
	guestSleep = rand() % 3 + 1;
	printf("Guest %d sleeps for %d second(s).\n", number, guestSleep);
	
	sem_wait(&mutexCheckOut); // Mutual exclusion
	tempGuestNumOut = number;
	roomNumOut = roomNumGuest;
	eventPrice = guestEventPrice;
	printf("Guest %d goes to the check-out reservationist and returns Room %d.\n", number, roomNumGuest);
	sem_post(&eventOrderGreetCheckOut); // Event ordering
	
	sem_wait(&eventOrderCaclBal); // Event ordering
	guestTotal = totalPrice;
	printf("Guest %d receives the total balance of $%d.\n", number, guestTotal);
	
	printf("Guest %d makes a payment.\n", number);
	sem_post(&eventOrderMakePayment); // Event ordering
	sem_post(&mutexCheckOut);
	return NULL;
}

//Check-in function
void *Check_In(void *args)
{
	int i;
	for(i = 0; i < 10; i++)
	{
		int roomNumCheckIn; // Local variable for room number
		int guestNumCheckIn;// Local variable for guest number
		
		sem_wait(&eventOrderGreetCheckIn); // Event ordering
		guestNumCheckIn = tempGuestNumIn;
		printf("The check-in reservationist greets Guest %d.\n", guestNumCheckIn);
		
		do {
			roomNumCheckIn = rand() % 5 + 1;
		}while(roomOccupied[roomNumCheckIn - 1]);
		roomOccupied[roomNumCheckIn - 1] = true;
		
		roomNumIn = roomNumCheckIn;
		printf("Assign Room %d to Guest %d.\n", roomNumCheckIn, guestNumCheckIn);
		sem_post(&eventOrderAssignRoom); // Event ordering
	}
	return NULL;
}

//Check-out function
void *Check_Out(void *args)
{
	int i;
	for(i = 0; i < 10; i++)
	{
		int roomNumCheckOut; // Local variable for room number
		int guestNumCheckOut; // Local variable for guest number
		int totalPriceCheckOut; // local variable for price
		
		sem_wait(&eventOrderGreetCheckOut); // Event ordering
		guestNumCheckOut = tempGuestNumOut;
		roomNumCheckOut = roomNumOut;
		printf("The check-out greets Guest %d and receives the key from Room %d.\n", guestNumCheckOut, roomNumCheckOut);
		
		printf("Calculate the balance for Guest %d.\n", guestNumCheckOut);
		totalPrice = roomPrice + eventPrice;
		sem_post(&eventOrderCaclBal); // Event ordering
		
		sem_wait(&eventOrderMakePayment); // Event ordering
		printf("Receive $%d from Guest %d and complete the check-out.\n", totalPrice, guestNumCheckOut);
		roomOccupied[roomNumCheckOut - 1] = false;
		
		sem_post(&bufferSem); // Buffer size
	}
	return NULL;
}

int main()
{
	// Declare semaphores
	sem_init(&bufferSem, 0, sizeOfBuffer);
	sem_init(&mutexCheckIn, 0, 1);
	sem_init(&eventOrderGreetCheckIn, 0, 0);
	sem_init(&eventOrderAssignRoom, 0, 0);
	sem_init(&mutexCheckOut, 0, 1);
	sem_init(&eventOrderGreetCheckOut, 0, 0);
	sem_init(&eventOrderCaclBal, 0, 0);
	sem_init(&eventOrderMakePayment, 0, 0);
	
	// Declare globals for accounting
	numOfGuests = 0;
	numOfPool = 0;
	numOfRestaurant = 0;
	numOfFitCent = 0;
	numOfBusCent = 0;
	
	
	// Initialize threads
	pthread_t hotelGuests[10];
	pthread_t reservationist_Check_In;
	pthread_t reservationist_Check_Out;
	
	// local variables
	int i;
	int guestNumber[10]; // There are 10 guests total
	
	// Set bool array to false
	for(i = 0; i < 5; i++)
	{
		roomOccupied[i] = false;
	}
	
	// Create threads
	for(i = 0; i < 10; i++)
	{
		guestNumber[i] = i;
		pthread_create(&hotelGuests[i], NULL, Guest, &guestNumber[i]);
	}
	
	//changed (void*) to NULL in the last position
	pthread_create(&reservationist_Check_In, NULL, Check_In, NULL);
	pthread_create(&reservationist_Check_Out, NULL, Check_Out, NULL);
	
	// Wait for the Guest thread to finish
	for(i = 0; i < 10; i++)
	{
		pthread_join(hotelGuests[i], NULL);
	}
	
	printf("\n\t\tNumber of Customers\n\n");
	printf("\tTotal Guests: %d\n", numOfGuests);
	printf("\tPool: %d\n", numOfPool);
	printf("\tRestaurant: %d\n", numOfRestaurant);
	printf("\tFitness Center: %d\n", numOfFitCent);
	printf("\tBusiness Center: %d\n\n", numOfBusCent);
	
	return 0;
}
