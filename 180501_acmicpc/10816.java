import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
//https://www.acmicpc.net/problem/10816
//�ð��ʰ�
public class Main {
	int deck[];
	void NumberCard2() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N; // ������ �ִ� ���� ī���� ����
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int k=0;
		deck = new int[N];	//������ �ִ� ���� ī��.
		while(st.hasMoreTokens())
			deck[k++] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(deck);		//ī�带 ������������ ����.
		
		int M; // �Ǵ��ؾ��� ����
		M = Integer.parseInt(br.readLine());
		int number;
		StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
		while(st2.hasMoreTokens()) {
			//���ڸ��� �˻� �� ���.
			number= Integer.parseInt(st2.nextToken());
			int left = 0;
			int right = deck.length-1;
			int cnt = 0;
			System.out.print(BinarySearch(number,left,right, cnt)+ " ");
		}		
	}
	
	int BinarySearch(int num, int left, int right, int cnt) {
		//�̺�Ž���� ���� ������ 1���� Ʋ���� 0 ����
		int mid = (left+right)/2;
		int result;
		if(left>right)	// ����Լ��� ���� ����
			return cnt;
		if(deck[mid]==num) {
			//ī�带 ã���� �翷�� ī�嵵 ���� �������� Ȯ�� �� ������� ����
			result = BinarySearch(num,mid+1,right,cnt);
			result += BinarySearch(num,left,mid-1,cnt);
			result ++;
		}
		else if(deck[mid]<num) {
			result = BinarySearch(num,mid+1,right,cnt);
		}
		else{
			result = BinarySearch(num,left,right-1,cnt);
		}
		return result;
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		new Main().NumberCard2();
	}

}
