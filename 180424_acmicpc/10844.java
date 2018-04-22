//https://www.acmicpc.net/problem/10844

import java.util.Scanner;

public class Main {
	int dp[][];
	long easyStairNum(int n) {	//n = ����
		dp = new int[10][101];//�տ��� 0~9�� ��Ÿ��, �ڿ����� ����.
		for( int i=1;i<=9;i++)
			dp[i][1] = 1;
		for(int i=2;i<=n;i++) {
			for(int j=0;j<10;j++) {
				if(j-1>=0) {//���� ����
					//���� ���� ����.
					dp[j][i] += dp[j-1][i-1];
				}
				if(j+1<=9) {//���� ����
					//������ ���� ����
					dp[j][i]+=dp[j+1][i-1];
				}
				dp[j][i] %=1000000000;
			}
		}
		long result=0;
		for(int i=0;i<10;i++) {
			result += dp[i][n];
			result %=1000000000;
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
