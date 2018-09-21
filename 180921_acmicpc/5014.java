import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	class Ev{
		int floor;
		int cnt;
		Ev(int floor, int cnt){
			this.floor = floor;
			this.cnt = cnt;
		}
	}
	
	void startLink(int f, int s, int g, int u, int d) {
		boolean[] isVisited = new boolean[f+1];
		Queue<Ev> q = new LinkedList<Ev>(); 
		
		q.add(new Ev(s,0));
		isVisited[s] = true;
		while(!q.isEmpty()) {
			Ev curEv = q.poll();
			if(curEv.floor==g) {
				System.out.println(curEv.cnt);
				return;
			}
			
			if(curEv.floor+u<=f&&!isVisited[curEv.floor+u]) {
				q.add(new Ev(curEv.floor+u,curEv.cnt+1));
				isVisited[curEv.floor+u] = true; 
			}
			if(curEv.floor-d>=1&&!isVisited[curEv.floor-d]) {
				q.add(new Ev(curEv.floor-d,curEv.cnt+1));
				isVisited[curEv.floor-d] = true;
			}
		}
		System.out.println("use the stairs");
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int f, g, s, u, d;
		f = Integer.parseInt(st.nextToken());
		s = Integer.parseInt(st.nextToken());
		g = Integer.parseInt(st.nextToken());
		u = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		
		new Main().startLink(f, s, g, u, d);
	}

}
