import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int n = sc.nextInt();
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		for(int t=1;t<=n;t++) {
			int a = sc.nextInt();
			if(a>max)
				max = a;
			if(a<min)
				min = a;
		}
		
		System.out.println(min + " " + max);
	}

}
