import java.util.Scanner;

public class Main {

	public void bertrand() {
		Scanner sc = new Scanner(System.in);
		int n;
		do {
			n = sc.nextInt();
			if(n==0)break;
			System.out.println(thePrimeNum(n));
		}while(n!=0);
	}
	
	public int thePrimeNum(int n) {		//에라토스테네스의 체 이용
		int cnt=0;
		boolean isNotPrime[] = new boolean[2*n+1];
		isNotPrime[1] = true;
		int i=2;
		while(i<2*n) {
			for(int j=1;i*j<=2*n;j++) {
				isNotPrime[i*j]=true;
			}
			i++;
			if(i*i>2*n) break;
		}
		
		for(int j=n+1;j<=2*n;j++) {
			if(!isNotPrime[j]) cnt++;
		}
		return cnt;
	}
	
	public static void main(String[] args) {
		new Main().bertrand();

	}

}
