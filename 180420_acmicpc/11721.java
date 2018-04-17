import java.util.Scanner;


class Main{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int sum=0;
		String N = sc.next();
		int i=0;
		
		while(i*10<N.length()) {
			for(int j=0;j<10;j++) {
				if((i*10)+j<N.length()) {
					System.out.print(N.charAt(i*10+j));
				}
			}
			System.out.println();
			i++;
		}
	}
}