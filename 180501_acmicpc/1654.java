import java.util.Scanner;
// https://www.acmicpc.net/problem/1654

public class Main {
	void CutLAN() {
		Scanner sc = new Scanner(System.in);
		int K,N; // K : �������ִ� ������ �� , N : �ʿ��� �����Ǽ�
		K = sc.nextInt();
		N = sc.nextInt();
		long max = 0;	//������ �ִ����.
		long lan[] = new long[K];	//�������ִ� ����.
		for(int i=0;i<K;i++) {
			lan[i] = sc.nextLong();
		}
		
		long left = 0;
		long right = Long.MAX_VALUE;		//������ ���� �ִ����
		
		while(left<=right) {
			long mid = (left+right)/2;		// �ʿ� ������ ���̸� ���� �߰���
			int result = 0;			// ���� �ڸ��� ����� ������ ����.
			
			for(int i=0;i<K;i++) {
				result += lan[i]/mid; //lan[i]���� ���Ҽ� �ִ� ������ ����
			}
			
			if(result >= N) {
				left = mid+1;
				if(mid>max)
					max = mid;
			}
			else
				right = mid-1;
		}
		System.out.println(max);
	}
	public static void main(String[] args) {
		new Main().CutLAN();
	}

}
