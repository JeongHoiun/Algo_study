import java.util.Scanner;

public class Main {
	public void thePrimeNumber() {
		Scanner sc = new Scanner(System.in);
		int low = sc.nextInt();
		int high = sc.nextInt();
		
		countPrime(low,high);
		
	}
	public void countPrime(int low, int high) {
		int sum = 0;
		int Lower = 0;
		boolean isPrime = true;
		for(int i=low;i<=high;i++) {
			if(i != 1){
				for(int j=2;j<i;j++){
					if(i%j==0) {
						isPrime = false;
						break;
					}
				}
				if(isPrime==true) {
					sum+=i;
					if(Lower == 0)  Lower = i;
				}
				else
					isPrime = true;
			}		
		}
		if(sum ==0)
			System.out.println(-1);
		else
			System.out.println(sum+"\n"+Lower);
	}
	public static void main(String[] args) {
		new Main().thePrimeNumber();
	}

}
