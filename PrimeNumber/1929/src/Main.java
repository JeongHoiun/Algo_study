import java.util.Scanner;

public class Main {

	public void eratosthenes() {
		Scanner sc = new Scanner(System.in);
		int lower = sc.nextInt();
		int higher = sc.nextInt();
		
		confirmPrime(lower,higher);
	}
	
	public void confirmPrime(int lower, int higher) {
		boolean isNotPrime[] = new boolean[higher+1];
		isNotPrime[1] = true;
		int i=2;
		while(i<higher) {
			for(int j=1;i*j<=higher;j++) {
				isNotPrime[i*j]=true;
			}
			i++;
			if(i*i>higher) break;
		}
		
		for(int j=lower;j<=higher;j++) {
			if(!isNotPrime[j]) System.out.println(j);
		}
	}
	
	public static void main(String[] args) {
		new Main().eratosthenes();
		
	}

}
