import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;
public class Main {

	public static void main(String[] args) throws  IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int arr[] = new int[N];
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		int sum = 0;
		for(int i=0;i<N;i++) {
			sum += arr[i];
			arr[i] = sum;
		}
		sum = 0;
		for(int i=0;i<N;i++) {
			sum += arr[i];
		}
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(String.valueOf(sum));
		bw.close();
	}

}
