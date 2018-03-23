import java.util.Scanner;

public class 1954{

	void snailNum() {
		Scanner sc = new Scanner(System.in);
		int testcase = sc.nextInt();
		for(int t=1;t<=testcase ; t++) {
			System.out.println("#"+t);
			int N = sc.nextInt();
			int x=0, y=0;
			int snail[][] = new int[N][N];
			
			int direction = 0; 	//direction   0:right 1:down 2:left 3:up
			
			for(int i=0;i<N*N;i++) {
				snail[x][y] = i+1;
				switch(direction) {		//route of snail
				case 0:
					x++;
					if(x==N||snail[x][y]>0) {
						direction=1;
						y++;x--;
					}
					break;
				case 1:
					y++;
					if(y==N||snail[x][y]>0) {
						direction=2;
						x--;y--;
					}
					break;
				case 2:
					x--;
					if(x==-1||snail[x][y]>0) {
						direction=3;
						y--;x++;
					}
					break;
				case 3:
					y--;
					if(y==-1||snail[x][y]>0) {
						direction=0;
						x++;y++;
					}
					break;
				}
			}
			printSnailNum(snail,N);
		}
		
	}
	
	void printSnailNum(int snail[][],int num) {
		for(int i=0;i<num;i++){
			for(int j=0;j<num;j++) {
				System.out.print(snail[j][i]+" ");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		new Solution().snailNum();
	}

}
