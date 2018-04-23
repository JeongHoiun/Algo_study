// https://www.acmicpc.net/problem/2011
import java.util.Scanner;

public class Main {
	void Alphacode() {
		Scanner sc = new Scanner(System.in);
		String code = sc.next();
		int dp[] = new int[code.length()+10];
		dp[0] =1;
		dp[1] =1;
		for (int i = 2; i <= code.length(); i++)
	    {
			/*
			 * 현재의 값이 0일때 알파벳은 존재하지 않으므로 이전 숫자의 경우의 수를 가져옴.
			 * 현재의 값이 10~26일경우 그 앞자리 값을 한번 더 더한것과 같음.
			 */
	        int now = i - 1;
	        if (code.charAt(now) > '0')
	            dp[i] = dp[i - 1] % 1000000;
	 
	        int x = (code.charAt(now- 1)-'0') * 10 + code.charAt(now)-'0';
	        
	        if (10 <= x && x <= 26)
	            dp[i] = (dp[i] + dp[i - 2]) % 1000000;
	    }if(code.compareTo("0")==0)
	    	System.out.println(0);
	    else
	    	System.out.println(dp[code.length()]);
		
	}
	public static void main(String[] args) {
		new Main().Alphacode();
	}

}
