import java.util.Scanner;
//https://www.acmicpc.net/problem/1931

public class Main {

	int maxMeeting(long[] start, long[] end, long n) {
		int cnt = 1;
		
		sort(start,end);
		
		long curStart = start[0];
		long curEnd = end[0];	
		for(int i=1;i<n;i++) {
			
			if(curEnd>end[i]) {
				curStart = start[i];
				curEnd = end[i];
			}else if(start[i]>=curEnd) {
				curStart= start[i];
				curEnd = end[i];
				cnt++;
			}
		}

		return cnt;
	}

	void sort(long[] a, long[] b) {
		for(int j = 1; j < a.length; j++) {
			long key = a[j];
			long tmp = b[j];
			int i = j-1;

			while(i >= 0 && a[i] > key) {
				a[i+1]=a[i];
				b[i+1]=b[i];
				i = i - 1;
			}
			a[i+1]=key;
			b[i+1]=tmp;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long[] start = new long[n];
		long[] end = new long[n];

		for(int i=0;i<n;i++) {
			start[i] = sc.nextInt();	//시작시간
			end[i] = sc.nextInt();	//끝시간
		}
		//start에 대해 1차 정렬 end에 대해 2차 정렬 후
		//각 값을 0부터 집어넣는다. i번째 값이 0보다 끝나는 시간이 짧은경우 0을 빼고 i를 집어넣는다.
		// 또한 i 번째 값의 시작시간이 이전 값의 끝나는 시간보다 클경우 그냥 집어 넣는다.
		
		System.out.println(new Main().maxMeeting(start, end, n));
	}

}
