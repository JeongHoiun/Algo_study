/* Top Coder p.302 AutoLoan
 I/O Data

0)
double price = 6800;
double monthlyPayment = 100;
double loanTerm = 68;
Returns = 1.3322616182218813E-13(0.0000000000001332)

1)
double price = 2000;
double monthlyPayment = 510;
double loanTerm = 4;
Returns : 9.56205462458368

2)
double price = 15000;
double monthlyPayment = 364;
double loanTerm = 48;
Returns: 7.687856394581649

*/

#include<cstdio>

double interestRate(double price, double monthlyPayment, int loanterm);

int main() {
	double price = 15000;
	double monthlyPayment = 364;
	int loanTerm = 48;

	printf("%e\n", interestRate(price, monthlyPayment, loanTerm));
}

double interestRate(double price, double monthlyPayment, int loanterm) {
	double interMax = 100;
	double interMin = 0;
	while ((1e-9<interMax-interMin)&&(1e-9<(interMax-interMin)/interMax)) {
		double interMid = (interMax + interMin) / 2.;
		double tmpPrice=price;
		for (int i = 0; i < loanterm; i++) {
			tmpPrice += tmpPrice*((interMid/12)/100.);
			tmpPrice -= monthlyPayment;
		}
		if (tmpPrice > 0) interMax = interMid;
		else if (tmpPrice < 0) interMin = interMid;
		else return interMid;
	}
	return interMin;
}