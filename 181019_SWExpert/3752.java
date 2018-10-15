import java.util.Scanner;

public class Solution {
	static int n,sum;
	static int num[];
	static boolean isVisited[];

	void solve(int piv) {
		if(piv == n) return;
		
		for(int i=sum; i>=0;i--) {
			if(isVisited[i] == true)
				isVisited[i+num[piv]]=true;
		}
		
		solve(piv+1);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int testcase = sc.nextInt();
		for(int t = 1;t<=testcase;t++) {
			n = sc.nextInt();
			num = new int[n];
			sum = 0;
			for(int i=0;i<n;i++) {
				num[i] = sc.nextInt();
				sum += num[i];
			}
			isVisited = new boolean[sum+1];
			isVisited[0] = true;
			
			new Solution().solve(0);
			
			int cnt = 0;
			for(int i=0;i<sum+1;i++) {
				if(isVisited[i]) cnt ++;
			}
			System.out.println("#"+t+" "+cnt);
		}
	}

}
