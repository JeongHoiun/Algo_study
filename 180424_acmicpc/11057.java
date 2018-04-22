//https://www.acmicpc.net/problem/10844

import java.util.Scanner;

public class Main {
	int dp[][];
	long easyStairNum(int n) {	//n = 길이
		dp = new int[10][1001];//앞에껀 0~9를 나타냄, 뒤에꺼가 길이.
		for( int i=0;i<=9;i++)
			dp[i][1] = 1;
		for(int i=2;i<=n;i++) {
			for(int j=0;j<10;j++) {
					//오른쪽 숫자 증가
					for(int k=0;k<=j;k++) {
						dp[j][i]+=dp[k][i-1];
					}
				dp[j][i] %=10007;
			}
		}
		long result=0;
		for(int i=0;i<10;i++) {
			result += dp[i][n];
			result %=10007;
		}
		return result;
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n;
		n = sc.nextInt();
		System.out.println(new Main().easyStairNum(n));

	}

}
