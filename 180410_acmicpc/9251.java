//9251
import java.util.Scanner;

public class Main {

	static void LCS() {
		Scanner sc = new Scanner(System.in);
		String str1 = sc.next();
		String str2 = sc.next();
		
		int dp[][] = new int[str1.length()+1][str2.length()+1];
		
		/*
		 * ACAYKP
		 * CAPCAK
		 * 
		 * dp[i][j]
		 * 0 0 0 0 0 0 0	j=0
		 * 0 0 1 1 1 1 1	j=1
		 * 0 1 1 1 2 2 2	j=2
		 * 0 1 2 2 2 3 3	j=3
		 * 0 1 2 2 2 3 3	j=4
		 * 0 1 2 2 2 3 4	j=5
		 * 0 1 2 3 3 3 4	j=6
		 */
		for (int i = 1; i <= str1.length(); i++) {
			for (int j = 1; j <= str2.length(); j++) { 
				if (str1.charAt(i-1)==str2.charAt(j-1)) {
					dp[i][j] = dp[i - 1][j - 1] + 1; 
				} else { 
						dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
				}
			} 
		}
		System.out.println(dp[str1.length()][str2.length()]);

	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main.LCS();
	}

}
