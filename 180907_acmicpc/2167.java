import java.io.*;
import java.util.StringTokenizer;
public class Main {

	public static void main(String[] args) throws IOException {
		long startTime = System.currentTimeMillis();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int arr[][] = new int[m+1][n+1];
		
		for(int i=1;i<=n;i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=1;j<=m;j++) {
				arr[j][i] = Integer.parseInt(st.nextToken());
			}
		}
		int k = Integer.parseInt(br.readLine());
		int[][] pt = new int[4][k];

		
		for(int i=0;i<k;i++) {

			int sum = 0;
			
			st = new StringTokenizer(br.readLine()," ");
			pt[0][i] = Integer.parseInt(st.nextToken());//x1
			pt[1][i] = Integer.parseInt(st.nextToken());//y1
			pt[2][i] = Integer.parseInt(st.nextToken());//x2
			pt[3][i] = Integer.parseInt(st.nextToken());//y2
			
			for(int j=pt[0][i];j<=pt[2][i];j++) {
				for(int l=pt[1][i];l<=pt[3][i];l++) {
					sum+= arr[l][j];
				}
			}
			System.out.println(sum);
		}
		
		long endTime = System.currentTimeMillis();
		long lTime = endTime - startTime;
		System.out.println("TIME : " + lTime + "(ms)");
	}

}
