import java.util.Scanner;

public class Main {

	public void thePrimeNumber() {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int[] prime = new int[num];
		
		for(int i=0;i<num;i++) {
			prime[i] = sc.nextInt();
		}
		System.out.println(countPrime(prime));
	}
	
	public int countPrime(int[] prime) {
		int cnt = 0;
		boolean isPrime = true;
		for(int i=0;i<prime.length;i++) {
			if(prime[i] != 1){
				for(int j=2;j<prime[i];j++){
					if(prime[i]%j==0) {
						isPrime = false;
						break;
					}
				}
				if(isPrime==true)
					cnt++;
				else
					isPrime = true;
			}		
		}
		return cnt;
	}
	public static void main(String[] args) {
		new Main().thePrimeNumber();

	}

}
