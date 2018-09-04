import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/10816
public class Main {
	int deck[];
	void NumberCard2() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N; // 가지고 있는 숫자 카드의 갯수
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
		deck = new int[N];	//가지고 있는 숫자 카드.
		while(st.hasMoreTokens()) {
			//HashMap에 넣어줌!
			int k = Integer.parseInt(st.nextToken());
			int key=0;
			if(map.containsKey(k))
				key=map.get(k);
			map.put(k,key+1);
		}
		
		int M; // 판단해야할 숫자
		M = Integer.parseInt(br.readLine());//필요없음
		int number;
		StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
		while(st2.hasMoreTokens()) {
			number = Integer.parseInt(st2.nextToken());
			if(map.containsKey(number))
				bw.write(String.valueOf(map.get(number))+" ");
			else bw.write("0 ");
		}		
		bw.close();
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		new Main().NumberCard2();
	}

}
