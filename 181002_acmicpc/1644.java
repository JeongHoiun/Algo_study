import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;

//https://www.acmicpc.net/problem/1644
public class Main {

	int sumOfPrime(int n){
		int cnt = 0;
		int sum = 0;
		
		LinkedList<Integer> list = new LinkedList<Integer>();
		boolean[] arr = new boolean[n+1];
		
		arr[1] = true;
		for(int i=2;i<=n;i++) {
			if(arr[i] == true ) continue;
			
			for(int j=i+i;j<=n;j+=i) {
				arr[j] = true;
			}
			
		}
		
		for(int i=0;i<=n;i++) {
			if(arr[i]) continue;
			
			list.add(i);
			sum+=i;
			
			while(sum>n) 
				sum-=list.removeFirst();
			if(sum==n) cnt++;
		}
		
		return cnt;
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(String.valueOf(new Main().sumOfPrime(n)));
		bw.close();
	}

}
