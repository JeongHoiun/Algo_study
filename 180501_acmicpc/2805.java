import java.util.Arrays;
import java.util.Scanner;
//https://www.acmicpc.net/problem/2805

public class Main {
	void EKO() {
		Scanner sc = new Scanner(System.in);
		int N; //N : 나무의수
		long M ; // 가져가려는 나무의 길이
		long max = 0;	//절단기의 높이 최댓값
		N = sc.nextInt();
		M = sc.nextLong();
		long tree[] = new long[N];
		for(int i=0;i<N;i++) {
			tree[i] = sc.nextLong();
		}
		Arrays.sort(tree);	//mid값을 작게 잡기 위해 정렬 후 (가장 큰 값*2)를 right로 잡음.
		long left = 0;
		long right = tree[N-1]*2;
		
		while(left<=right) {	// Binary Search
			long result = 0;
			long mid = (left+right)/2;		//자르는  높이
			
			for(int i=0;i<N;i++) {
				long temp = tree[i]-mid;
				if(temp >0 )	//안잘리는 경우 음수가 되는데  음수는 저장하지 않는다.
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
