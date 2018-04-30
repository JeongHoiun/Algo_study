import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
//https://www.acmicpc.net/problem/10816
//시간초과
public class Main {
	int deck[];
	void NumberCard2() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N; // 가지고 있는 숫자 카드의 갯수
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int k=0;
		deck = new int[N];	//가지고 있는 숫자 카드.
		while(st.hasMoreTokens())
			deck[k++] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(deck);		//카드를 오름차순으로 정렬.
		
		int M; // 판단해야할 숫자
		M = Integer.parseInt(br.readLine());
		int number;
		StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
		while(st2.hasMoreTokens()) {
			//숫자마다 검색 후 출력.
			number= Integer.parseInt(st2.nextToken());
			int left = 0;
			int right = deck.length-1;
			int cnt = 0;
			System.out.print(BinarySearch(number,left,right, cnt)+ " ");
		}		
	}
	
	int BinarySearch(int num, int left, int right, int cnt) {
		//이분탐색의 정석 맞으면 1리턴 틀리면 0 리턴
		int mid = (left+right)/2;
		int result;
		if(left>right)	// 재귀함수의 종료 조건
			return cnt;
		if(deck[mid]==num) {
			//카드를 찾으면 양옆의 카드도 같은 숫자인지 확인 후 결과값에 저장
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
