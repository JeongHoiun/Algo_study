/* Top Coder p.235 BadNeighbors
I/O data

int donations[] = { 10, 3, 2, 5, 7, 8};
Returns : 19

int donations[] = { 11, 15 };
Returns : 15

int donations[] = { 7,7,7,7,7,7,7 };
Returns : 21

int donations[] = { 1, 2, 3, 4, 5, 1, 2, 3, 4, 5};
Returns : 16

int donations[] = { 94, 40, 49, 65, 21, 21, 106, 80, 92, 81, 679, 4, 61, 6, 237, 12,
					72, 74, 29, 95, 265, 35, 47, 1, 61, 397, 52, 72, 37, 51, 1, 81,
					45, 435, 7, 36, 57, 86, 81, 72};
Returns : 2926

*/
#include<stdio.h>
#include<stdlib.h>


//Prototype
int maxDonations(int donations[], int count);
int Max(int a, int b);

//Main
int main() {
	int donations[] = { 94, 40, 49, 65, 21, 21, 106, 80, 92, 81, 679, 4, 61, 6, 237, 12,
		72, 74, 29, 95, 265, 35, 47, 1, 61, 397, 52, 72, 37, 51, 1, 81,
		45, 435, 7, 36, 57, 86, 81, 72 };

	printf("%d\n", maxDonations(donations, sizeof(donations)/sizeof(int)));
}

//Definitions
int maxDonations(int donations[], int count) {
	int* dp = (int*)malloc(count * sizeof(int));
	int i, sum = 0;
	
	for (i = 0; i < count-1 ; i++) {	// 첫번째 집이 포함되는 경우
		dp[i] = donations[i];
		if (i > 0) dp[i] = Max(dp[i], dp[i-1]);
		if (i > 1) dp[i] = Max(dp[i], dp[i - 2] + donations[i]);
		sum = max(sum, dp[i]);
	}

	for (i = 0; i < count-1 ; i++) {	//첫번째 집이 포함되지 않는 경우
		dp[i] = donations[i + 1];
		if (i > 0) dp[i] = Max(dp[i], dp[i - 1]);
		if (i > 1) dp[i] = Max(dp[i], dp[i - 2] + donations[i + 1]);
		sum = max(sum, dp[i]);
	}

	free(dp);

	return sum;
}

int Max(int a, int b) {
	return a > b ? a : b;
}
