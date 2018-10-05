import java.io.*;
import java.util.StringTokenizer;
//
public class Main {
	static int set = 0;
	static StringBuilder sb = new StringBuilder();
	void Command(String command, int x) throws IOException {
		switch(command) {
		case "add":
			set |= 1<<x;
			break;
		case "remove":
			set &= ~(1<<x);
			break;
		case "check":
			int check = set&(1<<x);
			sb.append(check>0?"1":"0");
			sb.append('\n');
			break;
		case "toggle":
			set ^= 1<<x;
			break;
		case "all":
			set=Integer.MAX_VALUE;
			break;
		case "empty":
			set = 0;
			break;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int m = Integer.parseInt(br.readLine());
		
		for(int i=0;i<m;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			String command = st.nextToken();
			int x=0;
			if(st.hasMoreTokens())
				x = Integer.parseInt(st.nextToken());
			
			new Main().Command(command,x);
		}

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		bw.write(sb.toString());
		bw.flush();
	}

}
