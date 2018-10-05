import java.io.*;
//https://www.acmicpc.net/problem/10974
public class Main {
	static int arr[];
	boolean nextPermutation() {
		if(arr.length==1) return false;
		//오른쪽부터 탐색하여 arr[i]보다 arr[i-1]이 작은 경우의 i를 찾음(감소수열)
		int i = arr.length-1;
		while(arr[i]<arr[i-1]) { 
			i--;
			if(i<1) return false;
		}
		
		//arr[i-1]< arr[j]인 가장 큰 j를 찾음 (j>=i).
		int j = arr.length-1;
		while(arr[i-1]>arr[j]&&j>i) j--;
		swap(i-1,j);
		//arr[i-1]부터 arr[j]까지 순열을 뒤집음.
		reverse(i,arr.length-1);
		
		return true;
	}
	
	void reverse(int x,int y) {
		for(;x<y;x++,y--) {
			swap(x,y);
		}
	}
	
	void swap(int x,int y) {
		int t = arr[x];
		arr[x] = arr [y];
		arr[y] = t;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		arr = new int[n];
		
		for(int i=0;i<n;i++) {
			arr[i] = i+1;
			bw.write(String.valueOf(arr[i])+" ");
		}
		bw.write("\n");
		
		while(new Main().nextPermutation()) {
			for(int i=0;i<n;i++) 
				bw.write(String.valueOf(arr[i])+" ");
			bw.write("\n");
			
		}
		
		bw.close();
	}

}
