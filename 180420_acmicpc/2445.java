import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for(int i=1;i<=n;i++) {
			for(int j=0;j<i;j++) 
				System.out.print("*");
			for(int j=0;j<n-i*2+n;j++)
				System.out.print(" ");
			for(int j=0;j<i;j++)
				System.out.print("*");
			System.out.println();
		}
		for(int i=1;i<n;i++) {
			for(int j=0;j<n-i;j++)
				System.out.print("*");
			for(int j=0;j<i*2;j++)
				System.out.print(" ");
			for(int j=0;j<n-i;j++)
				System.out.print("*");
			System.out.println();
		}
	}

}
