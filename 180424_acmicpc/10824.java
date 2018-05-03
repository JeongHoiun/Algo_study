import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	void FourNumber() {
		Scanner sc = new Scanner(System.in);
		StringTokenizer st = new StringTokenizer(sc.nextLine()," ");
		String number[] = new String[4];
		int i=0;
		while(st.hasMoreTokens()) {
			number[i++] = st.nextToken();
		}
		number[0] = number[0].concat(number[1]);
		number[2] = number[2].concat(number[3]);
		long result = Integer.parseInt(number[0])+Integer.parseInt(number[2]);
		System.out.println(result);
	}
	public static void main(String[] args) {
		new Main().FourNumber();

	}

}
