import java.util.Scanner;
//https://www.acmicpc.net/problem/10809
//설명 생략
public class Main {
	void NumOfAlphabet() {
		Scanner sc = new Scanner(System.in);
		int alpha[] = new int[26];
		String word = sc.nextLine();
		for(int i=0;i<26;i++)
			alpha[i] = -1;
		for(int i=0;i<word.length();i++) {
			if(alpha[word.charAt(i)-97]==-1)
				alpha[word.charAt(i)-97]=i;	//Ascii code 97 = a
		}
		for(int i=0;i<26;i++) {
			System.out.print(alpha[i] + " ");
		}
	}
	public static void main(String[] args) {
		new Main().NumOfAlphabet();
	}

}
