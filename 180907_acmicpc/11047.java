import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;
public class Main {

	int minCoinCnt(int[] coin, int K) {
		int cnt = 0;
		Arrays.sort(coin);
		
		for(int i=coin.length-1;i>=0;i--){
			if(coin[i]<=K) {
				K-=coin[i];
				cnt++;
				i++;
			}
			if(K==0)break;
		}
		return cnt;
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] coin = new int[N];
		for(int i=0;i<N;i++)
			coin[i] = Integer.parseInt(br.readLine());
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		bw.write(String.valueOf(new Main().minCoinCnt(coin,K)));
		bw.close();
	}

}
