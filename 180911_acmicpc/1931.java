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
			start[i] = sc.nextInt();	//���۽ð�
			end[i] = sc.nextInt();	//���ð�
		}
		//start�� ���� 1�� ���� end�� ���� 2�� ���� ��
		//�� ���� 0���� ����ִ´�. i��° ���� 0���� ������ �ð��� ª����� 0�� ���� i�� ����ִ´�.
		// ���� i ��° ���� ���۽ð��� ���� ���� ������ �ð����� Ŭ��� �׳� ���� �ִ´�.
		
		System.out.println(new Main().maxMeeting(start, end, n));
	}

}
