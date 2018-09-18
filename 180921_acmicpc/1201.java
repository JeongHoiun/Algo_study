import java.util.Scanner;

public class Main {

	void NMK(int n, int m, int k) {
		int[][] group = new int[m][k];
		if(m+k-1>n||n>m*k) {
			System.out.println(-1);
			return;
		}
		//오름차순
		//m개의 그룹을지정, 그룹의 원소의 갯수는 k보다 같거나 작아야함(같은것 한개 포함)

		for(int i=0;i<k;i++) {
			group[0][i] = i+1;
		}

		int l = 1;
		int j = 0;
		for(int i=k+1;i<=n;i++) {
			group[l++][j] = i;
			if(l>=m) {
				l=1;
				j++;
				j%=k;
			}
		}
		//각 그룹에 대해 내림차순 정렬
		for(int i=0;i<m;i++) {
			sort(group[i]);
			for(int h=0;h<k;h++) {
				if(group[i][h]!=0)
					System.out.print(group[i][h]+ " ");
			}
		}
		System.out.println();
	}

	void sort(int[] arr) {
		for(int i=0;i<arr.length-1;i++) {
			int min = -1;
			for(int j=i+1;j<arr.length;j++) {
				if(arr[j]>arr[j-1])
					min = j;
			}
			if(min!=-1) {
				int t = arr[min];
				arr[min] = arr[i];
				arr[i] = t;
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();
		int k = sc.nextInt();


		new Main().NMK(n,m,k);


	}

}
