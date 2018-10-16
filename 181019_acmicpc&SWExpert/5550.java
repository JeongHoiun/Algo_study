import java.util.Scanner;

public class Solution {
	int frog(String croak) {
		int[] n = new int[5];
		int frog_num=0;
		for(int i=0;i<croak.length();i++) {
			switch(croak.charAt(i)){
			case 'c':
				if(frog_num>0)
					frog_num-=1;
				n[0]++;
				break;
			case 'r':
				n[1]++;
				break;
			case 'o':
				n[2]++;
				break;
			case 'a':
				n[3]++;
				break;
			case 'k':
				n[4]++;
				frog_num++;
				break;
			}
			
			for(int j=0;j<4;j++) {
				if(n[j]<n[j+1]) {
					return -1;
				}
			}
		}

		int result = n[0];
		for(int i=1;i<5;i++)
			if(n[i]!=result) return -1;
		return frog_num;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=1;t<=T;t++) {
			String croak = sc.next();
			System.out.println("#"+t+" "+new Solution().frog(croak));
		}
	}

}
