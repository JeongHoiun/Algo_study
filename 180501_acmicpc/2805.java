import java.util.Arrays;
import java.util.Scanner;
//https://www.acmicpc.net/problem/2805

public class Main {
	void EKO() {
		Scanner sc = new Scanner(System.in);
		int N; //N : �����Ǽ�
		long M ; // ���������� ������ ����
		long max = 0;	//���ܱ��� ���� �ִ�
		N = sc.nextInt();
		M = sc.nextLong();
		long tree[] = new long[N];
		for(int i=0;i<N;i++) {
			tree[i] = sc.nextLong();
		}
		Arrays.sort(tree);	//mid���� �۰� ��� ���� ���� �� (���� ū ��*2)�� right�� ����.
		long left = 0;
		long right = tree[N-1]*2;
		
		while(left<=right) {	// Binary Search
			long result = 0;
			long mid = (left+right)/2;		//�ڸ���  ����
			
			for(int i=0;i<N;i++) {
				long temp = tree[i]-mid;
				if(temp >0 )	//���߸��� ��� ������ �Ǵµ�  ������ �������� �ʴ´�.
					result += tree[i]-mid;
			}
			
			if(result>=M) {
				left = mid+1;
				if(mid > max) {
					max = mid;
				}
			}
			else {
				right = mid-1;
			}
		}
		System.out.println(max);
		
	}
	public static void main(String[] args) {
		new Main().EKO();
	}

}
