import java.io.*;
import java.util.StringTokenizer;

public class Main {

	int maxTeam(int N, int M, int K) {
		
		while(K>0) {
			if(N/2>M) {
				K--;
				N--;
			}else if(N/2<M) {
				K--;
				M--;
			}else {
				N--;
				K--;
			}
		}
		if(N/2>M)
			return M;
		else {
			return N/2;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(String.valueOf(new Main().maxTeam(N,M,K)));
		bw.close();
	}

}
