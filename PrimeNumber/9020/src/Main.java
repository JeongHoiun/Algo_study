import java.util.Scanner;

public class Main {
	
	static boolean[] isNotPrime;
	
	public void goldbach() {
		Scanner sc = new Scanner(System.in);
		int testcase = sc.nextInt();
		isNotPrime = new boolean[10001];
		eratosthenes(10000);
		while(testcase--!=0) {
			int n = sc.nextInt();
			
			confirmPrime(n);
		}
	}
	
	public void eratosthenes(int higher) {
		isNotPrime[1] = true;
		int i=2;
		while(i<higher) {
			for(int j=i;i*j<=higher;j++) {
				isNotPrime[i*j]=true;
			}
			i++;
			if(i*i>higher) break;
		}
	}
	
	public void confirmPrime(int num) {
		int i,j,mid = num/2;
		for(i=j=mid;i<=num;i--,j++) {
			if(!isNotPrime[i]&&!isNotPrime[j]) {
				System.out.println(i+ " " + j);
				return;
			}
		}
	}
	
	public static void main(String[] args) {
		new Main().goldbach();
	}

}
