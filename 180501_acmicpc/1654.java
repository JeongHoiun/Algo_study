import java.util.Scanner;
// https://www.acmicpc.net/problem/1654

public class Main {
	void CutLAN() {
		Scanner sc = new Scanner(System.in);
		int K,N; // K : 가지고있는 랜선의 수 , N : 필요한 랜선의수
		K = sc.nextInt();
		N = sc.nextInt();
		long max = 0;	//랜선의 최대길이.
		long lan[] = new long[K];	//가지고있는 랜선.
		for(int i=0;i<K;i++) {
			lan[i] = sc.nextLong();
		}
		
		long left = 0;
		long right = Long.MAX_VALUE;		//랜선의 길이 최대범위
		
		while(left<=right) {
			long mid = (left+right)/2;		// 필요 랜선의 길이를 구할 중간값
			int result = 0;			// 현재 자르면 생기는 랜선의 갯수.
			
			for(int i=0;i<K;i++) {
				result += lan[i]/mid; //lan[i]에서 구할수 있는 랜선의 갯수
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
