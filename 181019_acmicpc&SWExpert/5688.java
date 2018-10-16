import java.io.*;
public class Solution {

	long binarySearch(long n) {
		long x = -1;
		
		long left = 1;
		long right = (long)Math.pow(n, 0.34);
		while(left<=right) {
			long mid = (left+right)/2;
			long triple=mid*mid*mid;
			if(triple == n) return mid;
			else if(triple > n) right = mid-1;
			else left = mid+1;
		}
		
		return -1;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for(int t= 1; t<=T;t++) {
			long n = Long.parseLong(br.readLine());
			
			bw.write("#"+t+" "+String.valueOf(new Solution().binarySearch(n))+"\n");
		}
		bw.close();
	}

}
