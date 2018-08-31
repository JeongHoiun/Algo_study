/*Top Coder p.257 HandShaking
I/O data

0)
int n=2;
Returns : 1

1)
int n=4;
Returns : 2

2)
int n=8;
Returns : 14
*/

#include<stdio.h>

long count[10001];

long countPerfect(int n);

int main() {
	int n = 4;

	printf("%ld\n", countPerfect(n));
}

long countPerfect(int n) {
	//C(n) = C(n-1)*1+C(1)*C(n-2)+C(2)*C(n-3)...+C(n-3)*C(2)+C(n-2)*C(1)+C(n-1)*1
	count[0] = 1;
	for (int i = 1; i <= n / 2; i++) {
		count[i] = 0;
		for (int j = 0; j < i; j++) {
			count[i] += count[j] * count[i - j - 1];
		}
	}

	return count[n/2];
}