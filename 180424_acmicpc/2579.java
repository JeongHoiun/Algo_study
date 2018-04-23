// https://www.acmicpc.net/problem/2579
import java.util.Scanner;

public class Main {
	static int score[];
	static int dp[];
	public void stairs() {
		Scanner sc = new Scanner(System.in);
		int numOfStair = sc.nextInt();
		
		score = new int[numOfStair+1];
		dp = new int[numOfStair+1];
		for(int i=1;i<=numOfStair;i++) 
			score[i] = sc.nextInt();
		
		upstairs(numOfStair);
		
		System.out.println(dp[numOfStair]);


	}
	
	public void upstairs(int numOfStair) {
		/*
		 * 연속된 3계단을 밟을 수 없으므로 포도주 시식과 똑같은 문제.
		 * 같은 방식으로 현재를 뺄건지, -1을 뺄건지, -2를 뺄껀지를 선택하면 됨.
		 */
		for (int i = 1; i <= 3 && i <= numOfStair; i++)
	        if (i!=3)
	            dp[i] = dp[i - 1] + score[i];
	        else
	            dp[i] = Math.max(score[i] + dp[i - 2], score[i] + score[i - 1]);
	 
	    for (int i = 4; i <= numOfStair; i++)
	        dp[i]=Math.max(score[i] + dp[i - 2], score[i] + score[i - 1] + dp[i - 3]);
	}
	
	public static void main(String[] args) {
		new Main().stairs();
	}
}
