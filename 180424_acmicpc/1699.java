//	https://www.acmicpc.net/problem/1699
import java.util.Scanner;

public class Main {
	void SumofSquare() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int dp[] = new int[n+1];
		
		for(int i=1;i<=n;i++) {//�������� �߰��ɶ� ���� 1�� �Ǵ� ���� �̿�.
			for(int j=1;j*j<=i;j++) {
				if(dp[i]>dp[i-j*j]+1|| dp[i]==0)
					dp[i] = dp[i-j*j]+1;
			}
		}
		
		/* �� �̹���� Ʋ�ȴٰ� �����¤���?
		int cnt =0;
		
		 int i=(int) Math.sqrt((double)n);
		while(n!=0) {
			if(i*i<=n) {
				n-=i*i;
				cnt++;
			}else
				i--;
		}
		System.out.println(cnt);
		*/
		System.out.println(dp[n]);
	}
	public static void main(String[] args) {
		new Main().SumofSquare();
	}

}
