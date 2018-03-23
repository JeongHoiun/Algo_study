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
