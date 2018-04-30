import java.util.Arrays;
import java.util.Scanner;
//https://www.acmicpc.net/problem/2110

public class Main {
	void InstallHomeGateway() {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 집의 개수
		int C = sc.nextInt(); // 공유기의 갯수 (2 <= C <= N)
		long max = 0; 	// 인접한 공유기의 최대 거리
		long house[] = new long[N];
		for(int i=0;i<N;i++) {
			house[i] = sc.nextLong();
		}
		
		Arrays.sort(house);
		long left = 1;		//가능한 최소 거리
		long right = house[N-1]-house[0];		//가능한 최대 거리
		while(left<=right) {
			long mid = (left+right)/2;	//설치 간격.
			int cnt = 1;	// 현재 설치된 갯수.
			long cur_pos = house[0];	//최근 설치된 곳.
			
			for(int i=0;i<N;i++) {
				if(house[i] - cur_pos >=mid) {	//mid 간격마다 공유기 설치
					cnt++;
					cur_pos = house[i];
				}
			}
			
			if(cnt>=C) {
				//설치된 공유기가 공유기의 최대 갯수보다 많은 경우 간격이 너무 좁음.
				max = mid;
				left = mid+1;//간격을 늘린다.
			}else
				right=mid-1;//간격을 줄인다.
			
		}
		System.out.println(max);
	}
	
	public static void main(String[] args) {
		new Main().InstallHomeGateway();

	}

}
