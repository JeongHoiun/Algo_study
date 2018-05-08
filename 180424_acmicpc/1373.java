import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();

		System.out.print(binaryToOctal(s));
	}

	static String binaryToOctal(String s) {
		int t = 0, n = s.length();
		boolean isfirst = false;
		StringBuilder sb = new StringBuilder();

		for (int i = n; i > 0; i = i - 3) {
			t = i - 3;
			if (t < 0) {
				t = 0;
				isfirst = true;
			}
			String r = s.substring(t, i);
			if (isfirst && r.length() < 3) {
				r = "00" + r;
				r = r.substring(r.length() - 3, r.length());
			}
			sb.append(radix(r));
		}

		return sb.reverse().toString();
	}

	static int radix(String r) {
		int c[] = { 4, 2, 1 };
		int k = 0;
		for (int i = 0; i < 3; i++)
			k += c[i] * ((int) r.charAt(i) - 48);
		return k;
	}

}