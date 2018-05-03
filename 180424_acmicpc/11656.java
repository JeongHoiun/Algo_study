import java.util.Arrays;
import java.util.Scanner;
// https://www.acmicpc.net/problem/11656
// substring을 이용하면 간단.
public class Main {
	void SuffixArr() {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		String[] arr = new String[s.length()];
		for(int i=0;i<s.length();i++) {
			arr[i] = s.substring(i);
		}
		Arrays.sort(arr);
		for(int i=0;i<s.length();i++)
			System.out.println(arr[i]);
	}
	public static void main(String[] args) {
		new Main().SuffixArr();
	}

}
