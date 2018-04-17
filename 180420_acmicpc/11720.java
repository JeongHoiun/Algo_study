import java.util.Scanner;


class Main{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int sum=0;
		int n = sc.nextInt();
		String N = sc.next();
		
		
		
		for(int i=0;i<n ;i++) {
			if(n!=0) {
				sum += N.charAt(i)-48;
			}
		}
		
		System.out.println(sum);
		
	}
}