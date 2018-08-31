/*Top Coder p.247 ChessMetric
I/O data

0)
int size = 3;
int start[2] = {0,0};
int end[2] = {0,0};
int numMoves = 1;
Returns : 1

1)
int size = 3;
int start[2] = {0,0};
int end[2] = {1,2};
int numMoves = 1;
Returns = 1

2)
int size = 3;
int start[2] = {0,0};
int end[2] = {2, 2};
int numMoves = 1;
Returns : 0

3)
int size = 3;
int start[2] = {0,0};
int end[2] = {0,0};
numMoves = 2;
Returns: 5

4)
int size= 100;
int start[2] = {0,0};
int end[2] = {0,99};
int numMoves = 50;
Returns : 243097320072600
*/

#include<stdio.h>
#include<stdlib.h>

long long map[101][101][51] = { 0 };
int dx[] = { 1, 1, 1, 0, -1, -1, -1, 0, 1, 2, 2, 1, -1, -2, -2, -1 };
int dy[] = { 1, 0, -1, -1, -1, 0, 1, 1, 2, 1, -1, -2, -2, -1, 1, 2 };

long long howMany(int size, int start[], int end[], int numMoves);

int main() {
	
	int size = 100;
	int start[2] = { 0,0 };
	int end[2] = { 0,99 };
	int numMoves = 50;

	printf("%lld\n", howMany(size, start, end, numMoves));

	return 0;
}

long long howMany(int size, int start[], int end[], int numMoves) {

	map[start[1]][start[0]][0] = 1;

	for (int i = 1; i <= numMoves; i++) {
		
		//¸ğµç ÁÂÇ¥¸¦ »ìÆìº½.....
		for (int x = 0; x < size; x++) {
			for (int y = 0; y < size; y++) {
				for (int j = 0; j < 16; j++) {
					int tx = x + dx[j];
					int ty = y + dy[j];
					if (tx >= 0 && ty >= 0 && tx < size&&ty < size) {
						map[ty][tx][i] += map[y][x][i - 1];
					}
				}
			}
		}
	}

	return map[end[1]][end[0]][numMoves];
}