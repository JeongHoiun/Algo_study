import java.util.Scanner;
//https://www.acmicpc.net/problem/1080
public class Main {
	public int matrix(int[][] A, int[][] B) {
		int cnt = 0;
		for(int i=0;i<A.length-2;i++) {
			for(int j=0;j<A[i].length-2;j++) {
				if(A[i][j]!=B[i][j]) {
					changMatrix(A,i,j);
					cnt++;
				}
			}
		}
		
		for(int i=0;i<A.length;i++) {
			for(int j=0;j<A[i].length;j++) {
				if(A[i][j]!=B[i][j]) 
					return -1;
			}
		}
		return cnt;
	}
	
	void changMatrix(int[][] A, int n, int m) {
		for(int i=n;i<n+3;i++) {
			for(int j=m;j<m+3;j++) {
				A[i][j] = A[i][j]==1?0:1;
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[][] A = new int[n][m];
		int[][] B = new int[n][m];
		for(int i=0;i<n;i++) {
			String tmp = sc.next();
			for(int j=0;j<m;j++) {
				A[i][j] = (int)(tmp.charAt(j)-'0');
			}
		}for(int i=0;i<n;i++) {
			String tmp = sc.next();
			for(int j=0;j<m;j++) {
				B[i][j] = (int)(tmp.charAt(j)-'0');
			}
		}
		
		
		System.out.println(new Main().matrix(A, B));
		
	}

}
