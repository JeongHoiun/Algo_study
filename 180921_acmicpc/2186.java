import java.awt.Point;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[] dx = {0,-1,1,0};
	static int[] dy = {1,0,0,-1};
	static String[] alpha;
	static int[][][] dp;

	class Word_q{
		Point p;
		int char_cnt;
		Word_q(Point p, int char_cnt){
			this.p = p;
			this.char_cnt=char_cnt;
		}
	}

	int characterBoard(int n, int m, int k, String word) {
		int cnt = 0;
		Queue<Word_q> q = new LinkedList<Word_q>();
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(alpha[i].charAt(j)==word.charAt(0)) {
					q.add(new Word_q(new Point(j,i),1));
					dp[i][j][1]=1;
				}
			}
		}
		//들어갈 수 있는 가장 첫 글자의 좌표

		while(!q.isEmpty()) {
			Word_q cur_p = q.poll();
			if(word.length()==cur_p.char_cnt) {
				cnt+=dp[cur_p.p.y][cur_p.p.x][cur_p.char_cnt];
				continue;
			}

			for(int i=1;i<=k;i++) {
				for(int j=0;j<4;j++) {
					int nx = cur_p.p.x+dx[j]*i;
					int ny = cur_p.p.y+dy[j]*i;
					if(nx<0||ny<0||nx>=m||ny>=n) continue;
					if(alpha[ny].charAt(nx)==word.charAt(cur_p.char_cnt)) {
						if(dp[ny][nx][cur_p.char_cnt+1]>0) 
							dp[ny][nx][cur_p.char_cnt+1]+=dp[cur_p.p.y][cur_p.p.x][cur_p.char_cnt];
						else {
							q.add(new Word_q(new Point(nx,ny),cur_p.char_cnt+1));
							dp[ny][nx][cur_p.char_cnt+1]+=dp[cur_p.p.y][cur_p.p.x][cur_p.char_cnt];
						}
					}
				}
			}
		}


		return cnt;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		alpha = new String[n];

		for(int i = 0 ; i<n ; i++) {
			alpha[i] = br.readLine();
		}
		String word = br.readLine();
		dp = new int[n][m][word.length()+1];

		int result = new Main().characterBoard(n, m, k, word);

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(String.valueOf(result));
		bw.close();
	}

}
