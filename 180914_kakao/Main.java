import java.util.Scanner;

public class Main {

	void secretMap(int n, int[] arr1, int[] arr2) {
		int bin = (int) Math.pow(2, n);
		
		char map[][] = new char[n][n];
		for(int i=0;i<n;i++) {
			for(int j=n-1;j>=0;j--) {
				int bin_n = arr1[i]%2;
				int bin_m = arr2[i]%2;
				arr1[i]/=2; arr2[i]/=2;
				
				if(bin_n==0&&bin_m==0) map[i][j] = ' ';
				else map[i][j] = '#';
			}
		}
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr1 = new int[n];
		int[] arr2 = new int[n];
		for(int i=0;i<n;i++) {
			arr1[i] = sc.nextInt();
		}
		for(int i=0;i<n;i++) {
			arr2[i] = sc.nextInt();
		}
		new Main().secretMap(n, arr1, arr2);
	}

}
