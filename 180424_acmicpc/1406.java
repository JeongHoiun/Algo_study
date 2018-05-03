import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.StringTokenizer;
//https://www.acmicpc.net/problem/1406
//Timeover
public class Main {
	void Editor() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		LinkedList<Character> ll = new LinkedList<Character>();
		String str = br.readLine().trim();
		for(int i=0;i<str.length();i++) {	//List에 Char형태로 저장.
			ll.add(str.charAt(i));
		}
		int n = Integer.parseInt(br.readLine().trim());
		int cursor = ll.size();		//커서의 위치
		for(int i=0;i<n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			String command = st.nextToken();
			switch(command){
			case "L":	//커서 왼쪽으로
				if(cursor!=0)
					cursor--;
				break;
			case "D":	//커서 오른쪽으로
				if(cursor!=ll.size())
					cursor++;
				break;
			case "B":	//삭제 
				if(cursor!=0) {
					ll.remove(cursor-1);
					cursor--;
				}
				break;
			case "P":	//추가
				String add = st.nextToken();
				for(int j=0;j<add.length();j++) {
					ll.add(cursor, add.charAt(j));
					cursor++;
				}
				break;
			}
		}
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for(int i=0;i<ll.size();i++)
			bw.write(ll.get(i));
		bw.flush();
		br.close();
		bw.close();
	}
	public static void main(String[] args) throws IOException {
		new Main().Editor();
	}

}
