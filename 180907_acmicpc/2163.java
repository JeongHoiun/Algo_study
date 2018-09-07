import java.util.Scanner;
//https://www.acmicpc.net/problem/2163
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//수학적으로 답이 그냥 나옴 
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		System.out.println(n*m-1);
	}

}
