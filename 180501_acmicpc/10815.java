import java.util.Arrays;
import java.util.Scanner;
//https://www.acmicpc.net/problem/10815

public class Main {
	void NumberCard() {
		Scanner sc= new Scanner(System.in);
		int N; // 가지고 있는 숫자 카드의 갯수
		N = sc.nextInt();
		int deck[] = new int[N];	//가지고 있는 숫자 카드.
		for(int i=0;i<N;i++) 
			deck[i] = sc.nextInt();
		
		Arrays.sort(deck);		//카드를 오름차순으로 정렬.
		
		int M; // 판단해야할 숫자
		M = sc.nextInt();
		int number;
		for(int i=0;i<M;i++) {
			//숫자마다 검색 후 출력.
			number= sc.nextInt();
			System.out.print(BinarySearch(deck,number)+ " ");
		}		
	}
	
	int BinarySearch(int[] card, int num) {
		//이분탐색의 정석 맞으면 1리턴 틀리면 0 리턴
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
