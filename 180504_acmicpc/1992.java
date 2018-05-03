import java.util.Scanner;
//https://www.acmicpc.net/problem/1992
//1780 문제와 비슷
public class Main {
	void QuadTree() {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.nextLine();		//줄바꿈이 있어서인지 한번 더 읽어야함.
		String vidio[] = new String[N];	//영상 정보
		for(int i=0;i<N;i++)
			vidio[i] = sc.nextLine();
		Divide(vidio,N);
	}
	
	void Divide(String vidio[], int n) {
		
		char temp = vidio[0].charAt(0);
		boolean isEqual = true;		//현재 부분 영상의 전체가 같은지 확인
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(temp!=vidio[i].charAt(j)) {
					isEqual = false;
					break;
				}
			}
			if(!isEqual)
				break;
		}
		if(isEqual) {	//같은 게 있을 경우 괄호정보를 출력하지 않고 숫자만 출력
			System.out.print(temp);
		}else {
			System.out.print("(");
			String tmp[] = new String[n/2];
			for(int g=0;g<2;g++) {
				for(int h=0;h<2;h++) {
					for(int i=0;i<n/2;i++) {
						//vidio를 4등분함.
						tmp[i] = vidio[i+n/2*g].substring(n/2*h, n/2*h+n/2);
					}
					Divide(tmp,n/2);
				}
			}
			System.out.print(")");
		}
		
	}
	public static void main(String[] args) {
		new Main().QuadTree();
	}

}
