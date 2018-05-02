import java.util.Scanner;
//https://www.acmicpc.net/problem/10820
//설명생략 ( Ascii Code ) 

public class Main {
	void AnalysisString() {
		Scanner sc =  new Scanner(System.in);
		while(sc.hasNext()) {
			String s = sc.nextLine();
			int small=0;
			int large=0;
			int number=0;
			int space = 0;
			for(int i=0;i<s.length();i++) {
				char a = s.charAt(i);
				if(a>=97&&a<=122)
					small++;
				else if(a>=65&&a<=90)
					large++;
				else if(a>=48&&a<=57)
					number++;
				else
					space++;
			}
			System.out.println(small+ " " + large + " " + number + " " + space);
		}
	}
	public static void main(String[] args) {
		new Main().AnalysisString();
	}

}
