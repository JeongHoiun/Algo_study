import java.util.Scanner;
// https://www.acmicpc.net/problem/1780

public class Main {
	int zero = 0;		//0 의 개수
	int neg = 0;		//-1의 갯수
	int pos = 0;		//1의 갯수
	void NumberOfPaper() {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();		//종이의 크기
		int paper[][] = new int[N][N];	//종이의 상태
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				paper[i][j] = sc.nextInt();
			}
		}
		divide(paper,N);

		System.out.println(neg+"\n"+zero+"\n"+pos);
	}
	void divide(int paper[][],int n) {
		int a=paper[0][0];
		boolean isEqual = true;		//종이의 전체가 같은지 확인
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(a!=paper[i][j]) {
					isEqual = false;
					break;
				}
			}
			if(!isEqual)
				break;
		}
		if(isEqual)		//종이의 전체가 같으면 해당하는 종이의 변수를 1 증가
			switch(a) {
			case 0:   zero++; break;
			case 1:   pos++; break;
			case -1:  neg++; break;
			}
		else {
			int temp[][] = new int[n/3][n/3];	//다음 종이
			for(int g=0;g<3;g++) {	
				for(int h=0;h<3;h++) {
					//3*3으로 나누게 됨.
					for(int i=0;i<n/3;i++) {
						for(int j=0;j<n/3;j++) {
							temp[i][j] = paper[i+n/3*g][j+n/3*h];
							//각각 구역의 paper를 만듬
						}
					}
					divide(temp,n/3); //재귀.
				}
			}
		}
	}
	public static void main(String[] args) {
		new Main().NumberOfPaper();
	}

}
