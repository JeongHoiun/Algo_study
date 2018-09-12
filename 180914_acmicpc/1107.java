import java.util.Scanner;
//
public class Main {
	int clickButton(int channel, boolean[] isButton) {
		int ans = Math.abs(channel - 100);
		for (int i = 0; i <= 888888; i++) {
			// i는 번호 버튼을 눌러 가까운 번호로 이동으로 가정.
			boolean flag = false;
			String current = String.valueOf(i);
			int len = current.length();

			for (int j = 0; j < len; j++) {
				int value = current.charAt(j) - '0';

				if (!isButton[value]) {
					flag = true;
					break;
				}

			}
			if (!flag) { // 숫자 버튼 횟수 + 이동한 번호와 목표 번호간의 차이
				if (ans > Math.abs(i - channel) + len) {
					ans = Math.abs(i - channel) + len; 
				}
			}
		}

		return ans;
	}


public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int channel = sc.nextInt();
	int m = sc.nextInt();
	boolean[] isButton = new boolean[11];
	for(int i=0;i<11;i++) {
		isButton[i] = true;
	}
	for(int i=0;i<m;i++) {
		isButton[sc.nextInt()] = false;
	}

	System.out.println(new Main().clickButton(channel, isButton));
}

}
