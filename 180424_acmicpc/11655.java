import java.util.Scanner;

public class Main {
	void ROT13() {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		
		for(int i=0;i<s.length();i++) {
			char a = s.charAt(i);
			if(a>=97&&a<=122) {
				char b = (a+13)>'z'?(char)((a+13)-26):(char)(a+13);
				System.out.print(b);
			}else if(a>=65&&a<=90) {
				char b = (a+13)>'Z'?(char)((a+13)-26):(char)(a+13);
				System.out.print(b);
			}else
				System.out.print(a);
		}
	}
	public static void main(String[] args) {
		new Main().ROT13();
	}

}
