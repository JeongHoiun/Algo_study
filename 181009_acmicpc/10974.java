import java.io.*;
//https://www.acmicpc.net/problem/10974
public class Main {
	static int arr[];
	boolean nextPermutation() {
		if(arr.length==1) return false;
		//�����ʺ��� Ž���Ͽ� arr[i]���� arr[i-1]�� ���� ����� i�� ã��(���Ҽ���)
		int i = arr.length-1;
		while(arr[i]<arr[i-1]) { 
			i--;
			if(i<1) return false;
		}
		
		//arr[i-1]< arr[j]�� ���� ū j�� ã�� (j>=i).
		int j = arr.length-1;
		while(arr[i-1]>arr[j]&&j>i) j--;
		swap(i-1,j);
		//arr[i-1]���� arr[j]���� ������ ������.
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
