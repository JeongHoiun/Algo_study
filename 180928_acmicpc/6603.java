import java.util.Scanner;
//https://www.acmicpc.net/problem/6603
public class Main {
	static int[] num;
	static boolean[] visit;
	void lotto(int cur, int cnt) {
		if(cur == num.length && cnt == 6) {
			for(int i=0;i<num.length;i++) {
				if(visit[i] == true)
					System.out.print(num[i]+" ");
			}
			System.out.println();
		}
		if(cur==num.length) return;
		visit[cur] = true;
		lotto(cur+1,cnt+1);
		visit[cur] = false;
		lotto(cur+1,cnt);

	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			int k = sc.nextInt();
			if(k==0) return;
			num = new int[k];
			for(int i=0;i<k;i++) {
				num[i] = sc.nextInt();
			}
			visit = new boolean[k];
			new Main().lotto(0,0);
			System.out.println();
		}
	}

}
