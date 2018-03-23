import java.util.Scanner;

public class Main {
	static int n;
	static int dpc[][];
	static int[][] tri;
	
	public static int dp(int x,int y){
		if(dpc[x][y]!=-1)
			return dpc[x][y];
		if(x==n-1)
			return dpc[x][y]=tri[x][y];
		
		return dpc[x][y]=tri[x][y]+max(dp(x+1,y),dp(x+1,y+1));
	}
	
	private static int max(int dp, int dp2) {
		if(dp>dp2) return dp;
		else return dp2;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
				
		n = sc.nextInt();
		tri = new int[n][n];
		dpc = new int[n][n];
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++)
				dpc[i][j]=-1;
		}
		for(int i=0;i<n;i++){
			for(int j=0;j<=i;j++){
				tri[i][j] = sc.nextInt();
			}
		}
		System.out.println(dp(0,0));
	}

}
