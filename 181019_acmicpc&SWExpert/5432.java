import java.util.Scanner;

public class Solution {

	int ironStick(String lazer) {
		int stick = 0;
		int curstick = 1;
		int new_stick = 1;
		char prev = lazer.charAt(0);
		for(int i=1;i<lazer.length();i++) {
			char cur = lazer.charAt(i);
			if(cur == '(') {
				curstick++;
				new_stick++;
			}
			else if( cur ==')' && prev =='(') {
				curstick--;
				new_stick--;
				stick+=curstick;
				stick+=new_stick;
				new_stick = 0;
			}else if(cur ==')') {
				curstick --;
			}

			prev = cur;
		}


		return stick;
	}

	public static void main(String[] args) {
		Scanner sc=  new Scanner(System.in);

		int T = sc.nextInt();
		for(int t=1;t<=T;t++) {
			String lazer = sc.next();

			System.out.println("#"+t+" "+new Solution().ironStick(lazer));
		}
	}
}
