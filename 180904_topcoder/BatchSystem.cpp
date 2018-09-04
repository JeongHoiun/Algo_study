/* Top Coder p.290 BatchSystem
I/O data

0)
int duration[] = {400, 100, 100, 100};
char* user[] = {"Danny Messer", "Stella Bonasera", "Stella Bonasera", "Mac Taylor"};
Returns : { 3, 1, 2, 0 }

1)
int duration[] = {200, 200, 200};
char* user[] = {"Gil", "Sarah", "Warrick"};
Returns : { 0, 1, 2 }

2)
int duration[] = {100, 200, 50};
char* user[] = {"Horatio Caine", "horatio caine", "Stella Bonasera"};
Returns : { 1, 2, 0 }

*/

#include<cstdio>
#include<cstdlib>
#include<string.h>

int* schedule(int duration[], char* user[], int len);

int main() {
	int duration[] = { 400, 100, 100, 200 };
	char* user[] = { "Danny Messer", "Stella Bonasera", "Stella Bonasera", "Mac Taylor"};

	int len = sizeof(duration) / sizeof(int);

	int* result = (int *)malloc(sizeof(int)*len);
	result = schedule(duration, user, len);

	for (int i = 0; i < len; i++) {
		printf("%d ", result[i]);
	}
	printf("\n");

	return 0;
}

//같은 사람의 작업은 더함.
//가장 적게 걸리는 사람의 작업이 가장 먼저 수행하도록
int* schedule(int duration[], char* user[], int len) {
	int* totalDuration = (int *)malloc(sizeof(int)*len);
	for (int i = 0; i < len; i++) {
		totalDuration[i] = 0;
	}
	for (int i = 0; i < len - 1; i++) {
		if (totalDuration[i] != 0) continue;
		totalDuration[i] = duration[i];
		for (int j = i + 1; j < len; j++) {
			if (strcmp(user[i], user[j]) == 0) {
				totalDuration[i] += duration[j];
				totalDuration[j] = totalDuration[i];
			}
		}
	}
	if (totalDuration[len - 1] <= 0) totalDuration[len - 1] = duration[len - 1];

	int* result = (int *)malloc(sizeof(int)*len);
	int* isVisited = (int *)malloc(sizeof(int)*len);

	for (int i = 0; i < len; i++) {
		int min = 1000000000;
		int idx = 0;
		for (int j = 0; j < len; j++) {
			if ((min > *(totalDuration + j)) && *(isVisited + j) != 1) {
				min = *(totalDuration + j);
				idx = j;
			}
			else if (min == *(totalDuration + j) && *(isVisited + j) != 1) {
				if (strcmp(user[idx], user[j]) > 0) {
					min = *(totalDuration + j);
					idx = j;
				}
			}
		}
		*(isVisited + idx) = 1;
		*(result + idx) = i;
	}
	return result;
}