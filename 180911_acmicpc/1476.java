import java.util.Scanner;

public class Main {
	int ESMtoYears(int E, int S, int M) {
		int i=0;
		while(true){
			if(i%15+1==E&&i%28+1==S&&i%19+1==M)
				return i+1;
			i++;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int E = sc.nextInt();
		int S = sc.nextInt();
		int M = sc.nextInt();
		
		System.out.println(new Main().ESMtoYears(E, S, M));
	}

}
