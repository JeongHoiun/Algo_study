import java.util.Arrays;
import java.util.Scanner;
//https://www.acmicpc.net/problem/10815

public class Main {
	void NumberCard() {
		Scanner sc= new Scanner(System.in);
		int N; // ������ �ִ� ���� ī���� ����
		N = sc.nextInt();
		int deck[] = new int[N];	//������ �ִ� ���� ī��.
		for(int i=0;i<N;i++) 
			deck[i] = sc.nextInt();
		
		Arrays.sort(deck);		//ī�带 ������������ ����.
		
		int M; // �Ǵ��ؾ��� ����
		M = sc.nextInt();
		int number;
		for(int i=0;i<M;i++) {
			//���ڸ��� �˻� �� ���.
			number= sc.nextInt();
			System.out.print(BinarySearch(deck,number)+ " ");
		}		
	}
	
	int BinarySearch(int[] card, int num) {
		//�̺�Ž���� ���� ������ 1���� Ʋ���� 0 ����
		int left = 0;
		int right = card.length-1;
		
		while(left<=right) {
			int mid = (left+right)/2;
			if(card[mid]==num) 
				return 1;
			else if(card[mid]<num)
				left = mid+1;
			else
				right = mid-1;
		}
		return 0;
	}
	public static void main(String[] args) {
		new Main().NumberCard();
	}

}
