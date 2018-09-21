import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
//https://www.acmicpc.net/problem/1759

public class Main {
	static char[] vowel = {'a', 'e', 'i', 'o', 'u'};
	static char[] code;
	static ArrayList<String> list = new ArrayList<String>();
	void makePassword(int v, int l, int c, String str) {
		//length == l ?
		//sort, list.contain?
		//
		if(str.length()==l) {
			int vowel_num=0;
			int consonant_num = 0;
			for(int i=0;i<str.length();i++) {
				for(int j=0;j<5;j++) {
					if(vowel[j]==str.charAt(i)) {
						vowel_num++;
					}
				}
			}
			consonant_num = str.length()-vowel_num;
			if(vowel_num<1||consonant_num<2) return ;
			
			char[] tmpstr = new char[str.length()];
			String tmp = ""; 
			for(int i=0;i<str.length();i++) {
				tmpstr[i] = str.charAt(i);
			}
			Arrays.sort(tmpstr);
			for(int i=0;i<tmpstr.length;i++) {
				tmp +=tmpstr[i];
			}
			if(!list.contains(tmp)) {
				list.add(tmp);
			}
		}
		else {
			for(int i=v;i<code.length;i++) {
				boolean isthere = false;
				for(int j=0;j<str.length();j++) {
					if(str.charAt(j)==code[i]) {
						isthere = true;
						break;
					}
				}
				if(!isthere)
					makePassword(i+1,l,c,str+code[i]);
			}
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int  l =Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		code = new char[c];
		String s = br.readLine();
		
		for(int i =0;i<c;i++) 
			code[i] = s.charAt(i*2);
		
		Arrays.sort(code);
		
		new Main().makePassword(0,l, c, "");
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		for(int i=0;i<list.size();i++) {
			bw.write(list.get(i)+"\n");
		}
		bw.close();
	}

}
