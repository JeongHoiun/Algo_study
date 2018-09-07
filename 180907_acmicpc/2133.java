import java.io.*;
//https://www.acmicpc.net/problem/2133

public class Main {
	
	void FillTiles(int n) {
		int result[] = new int[31];
		int dp[] = new int[31];
	    
	    dp[0] = 1;    result[0] = 1;
	    dp[2] = 3;
	    for (int i = 4; i <= 30; i += 2)
	        dp[i] = 2;
	 
	 
	    for (int i = 2; i <= n; i+=2){
	        for (int j = 2; j <= i; j += 2){
	            result[i] += dp[j] * result[i - j];
	 
	        }
	    }
	    System.out.println(result[n]);

	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		new Main().FillTiles(n);
	}

}