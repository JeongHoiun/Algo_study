//https://www.acmicpc.net/problem/9095
import java.util.Scanner;
public class Main {
	int dp[]; 
	void OneTwoThreeAdd() {
		Scanner sc = new Scanner(System.in);
		int testcase = sc.nextInt();
		for(int t=1;t<=testcase;t++) {
			int n=sc.nextInt();
			dp = new int[n+1];
			System.out.println(AddDp(n));
		}
		
	}
	
	int AddDp(int n) {
		//X(n) = X(n-1)+X(n-2)+X(n-3)
		if(n==1)
			return 1;
		else if(n==2)
			return 2;
		else if(n==3)
			return 4;
		else
			dp[n] = AddDp(n-1)+AddDp(n-2)+AddDp(n-3);
		return dp[n];
	}
	public static void main(String[] args) {
		new Main().OneTwoThreeAdd();
	}

}
