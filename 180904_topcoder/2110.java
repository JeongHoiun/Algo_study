import java.util.Arrays;
import java.util.Scanner;
//https://www.acmicpc.net/problem/2110

public class Main {
	void InstallHomeGateway() {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // ���� ����
		int C = sc.nextInt(); // �������� ���� (2 <= C <= N)
		long max = 0; 	// ������ �������� �ִ� �Ÿ�
		long house[] = new long[N];
		for(int i=0;i<N;i++) {
			house[i] = sc.nextLong();
		}
		
		Arrays.sort(house);
		long left = 1;		//������ �ּ� �Ÿ�
		long right = house[N-1]-house[0];		//������ �ִ� �Ÿ�
		while(left<=right) {
			long mid = (left+right)/2;	//��ġ ����.
			int cnt = 1;	// ���� ��ġ�� ����.
			long cur_pos = house[0];	//�ֱ� ��ġ�� ��.
			
			for(int i=0;i<N;i++) {
				if(house[i] - cur_pos >=mid) {	//mid ���ݸ��� ������ ��ġ
					cnt++;
					cur_pos = house[i];
				}
			}
			
			if(cnt>=C) {
				//��ġ�� �����Ⱑ �������� �ִ� �������� ���� ��� ������ �ʹ� ����.
				max = mid;
				left = mid+1;//������ �ø���.
			}else
				right=mid-1;//������ ���δ�.
			
		}
		System.out.println(max);
	}
	
	public static void main(String[] args) {
		new Main().InstallHomeGateway();

	}

}
