import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static int min = Integer.MAX_VALUE;
	static boolean[] visited;
	void minTime(int n, int k) {


		Queue<Integer> q = new LinkedList<Integer>();
		Queue<Integer> cnt_q = new LinkedList<Integer>();
		q.add(n);
		cnt_q.add(0);
		while(!q.isEmpty()) {

			int num = q.poll();
			int cn = cnt_q.poll();
			visited[num] = true;
			if(num<0||num>100000) continue;
			if(k==num&&min>num) min = cn;

			if(num>0)
				if(!visited[num-1]) {
					q.add(num-1);
					cnt_q.add(cn+1);
				}
			if(!visited[num+1]) {
				q.add(num+1);
				cnt_q.add(cn+1);
			}
			if(!visited[2*num]) {
				q.add(2*num);
				cnt_q.add(cn+1);
			}
		}

		/*if(cnt>min||n<0||n>100000)
			return;
		if(n==k) {
			min = min>cnt?cnt:min;
			return;
		}
		visited[n] = true;
		if(visited[2*n]) return;
		minTime(2*n,k,cnt+1);
		if(n>0)
		if(visited[n-1]) return;
		minTime(n-1,k,cnt+1);
		if(visited[n+1]) return;
		minTime(n+1,k,cnt+1);
		 */

	}

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int n, k;
		n = sc.nextInt();
		k = sc.nextInt();
		visited = new boolean[200001];
		new Main().minTime(n, k);

		System.out.println(min);
	}

}