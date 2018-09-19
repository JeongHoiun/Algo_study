import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
//https://www.acmicpc.net/problem/1525
public class Main {
	static int dx[] = {1,-1,0,0};
	static int dy[] = {0,0,1,-1};
	int puzzle(int[][] arr) {
		int[][] correct_arr = {{1,2,3},{4,5,6},{7,8,0}};
		HashMap<Integer,Boolean> map = new HashMap<Integer,Boolean>();
		Queue<Integer> q = new LinkedList<Integer>();
		Queue<Integer> q_cnt = new LinkedList<Integer>();

		int cur_num = 0;
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				cur_num*=10;
				cur_num+=arr[i][j];
			}
		}

		q.add(cur_num);
		q_cnt.add(0);
		map.put(cur_num, true);
		
		while(!q.isEmpty()) {
			int num = q.poll();
			int cur_cnt = q_cnt.poll();
			int[][] cur_arr = new int[3][3];
			boolean correct = true;

			int zx = 0;
			int zy = 0;

			for(int i=2;i>=0;i--) {
				for(int j=2;j>=0;j--) {
					cur_arr[i][j] = num%10;
					num/=10;
					if(cur_arr[i][j]!=correct_arr[i][j]) 
						correct = false;
					if(cur_arr[i][j] == 0) {
						zx = j;
						zy = i;
					}
				}
			}
			if(correct)
				return cur_cnt;
			
			for(int i=0;i<4;i++) {
				int[][] tmp_arr = new int[3][3];
				for(int j=0;j<3;j++) {
					for(int k=0;k<3;k++)
						tmp_arr[j][k] = cur_arr[j][k];
				}
				int nx = zx+dx[i];
				int ny = zy+dy[i];
				if(nx<0||ny<0||nx>=3||ny>=3) continue;
				int t = tmp_arr[ny][nx];
				tmp_arr[ny][nx] = tmp_arr[zy][zx];
				tmp_arr[zy][zx] = t;
				int tmp_num=0;
				for(int k=0;k<3;k++) {
					for(int j=0;j<3;j++) {
						tmp_num*=10;
						tmp_num+=tmp_arr[k][j];
					}
				}
				if(!map.containsKey(tmp_num)) {
					q.add(tmp_num);
					q_cnt.add(cur_cnt+1);
					map.put(tmp_num,true);
				}
			}
		}




		return -1;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] arr = new int[3][3];
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		System.out.println(new Main().puzzle(arr));

	}

}
