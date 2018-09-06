//https://www.acmicpc.net/problem/10610

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
	void maxNum(String n) {
		int sum = 0;
		int[] ar = new int[n.length()];
		boolean isZero = false;
		for(int i=0;i<n.length();i++) {
			sum+=n.charAt(i);
			ar[i] = n.charAt(i)-48;
			if(ar[i] == 0)
				isZero = true;
		}
		if(sum%3!=0||!isZero)
			System.out.println(-1);
		else {
			Arrays.sort(ar);
			for(int i=n.length()-1;i>=0;i--)
				System.out.print(ar[i]);
		}
		System.out.println();
		
		
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String N = br.readLine();
		
		new Main().maxNum(N);
	}

}
