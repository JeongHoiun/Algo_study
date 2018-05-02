import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	void NumberK() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer input1 = new StringTokenizer(br.readLine().trim());
		int n = Integer.parseInt(input1.nextToken());
		int k = Integer.parseInt(input1.nextToken());
		
		int arr[] = new int[n];
		StringTokenizer input2 = new StringTokenizer(br.readLine().trim());
		int arr_idx=0;
		while(input2.hasMoreTokens())
			arr[arr_idx++] = Integer.parseInt(input2.nextToken());
		Arrays.sort(arr);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(arr[k-1]);
		System.out.println(arr[k-1]);
		br.close();
		bw.flush();
		bw.close();
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		new Main().NumberK();

	}

}
