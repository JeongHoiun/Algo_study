/*Top Coder p.265 ColorfulBoxesAndBalls
I/O data

0)
int numRed = 2;
int numBlue = 3;
int onlyRed = 100;
int onlyBlue = 400;
int bothColors = 200;
Returns : 1400

1)
int numRed = 2;
int numBlue = 3;
int onlyRed = 100;
int onlyBlue = 400;
int bothColors = 300;
Returns : 1600

2)
int numRed = 5;
int numBlue = 5;
int onlyRed = 464;
int onlyBlue = 464;
int bothColors = 464;
Returns : 4640

3)
int numRed = 1;
int numBlue = 4;
int onlyRed = 20;
int onlyBlue = -30;
int bothColors = -10;
Returns : -100

4)
int numRed = 9;
int numBlue = 1;
int onlyRed = -1;
int onlyBlue = -10;
int bothColors = 4;
Returns : 0
*/

#include<stdio.h>
#include<math.h>

int getMaximum(int numRed, int numBlue, int onlyRed, int onlyBlue, int bothColors);
int max(int a, int b) { return a > b ? a : b; }

int main() {
	int numRed = 9;
	int numBlue = 1;
	int onlyRed = -1;
	int onlyBlue = -10;
	int bothColors = 4;

	printf("%d\n", getMaximum(numRed, numBlue, onlyRed, onlyBlue, bothColors));
	return 0;
}
int getMaximum(int numRed, int numBlue, int onlyRed, int onlyBlue, int bothColors) {
	int scoreA = 0, scoreB = 0;
	scoreA = numRed*onlyRed + numBlue*onlyBlue;
	scoreB = numRed > numBlue ? (numRed - numBlue)*onlyRed + numBlue*2*bothColors : (numBlue - numRed)*onlyBlue + numRed*2*bothColors;

	return max(scoreA, scoreB);
}