import java.util.Scanner;

public class 1961{

	void numberArrayRotation() {
		Scanner sc = new Scanner(System.in);
		int testcase = sc.nextInt();
		
		for(int T=1;T<=testcase;T++) {
			System.out.println("#"+T);
			
			int size= sc.nextInt();
			int num[][] = new int[size][size];
			for(int i=0;i<size;i++) {
				for(int j=0;j<size;j++) {
					num[i][j] = sc.nextInt();
				}
			}
			
			printRotation(num,size);
		}
		
	}
	
	void printRotation(int num[][], int size) {
		for(int i=0;i<size;i++) {
			for(int j=0;j<size;j++) {
				System.out.print(num[size-1-j][i]);		//print 90 degree rotation
			}
			System.out.print(" ");
			for(int j=0;j<size;j++) { 		//print 180 degree rotation
				System.out.print(num[size-1-i][size-1-j]);
			}
			System.out.print(" ");
			for(int j=0;j<size;j++) {	//print 270 degree rotation
				System.out.print(num[j][size-1-i]);
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		new 1961().numberArrayRotation();

	}

}
