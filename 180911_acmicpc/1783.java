import java.awt.Point;
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/1783
//Timeover
//문제를 잘 이해 못하겠음.
public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int cnt=0;
		if(n == 1) cnt = 1;
		else if(n == 2) cnt =  Math.min(4, (m+1)/2);
		else if(m < 7) cnt = Math.min(4, m);
	    else cnt = m-7+5;

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		bw.write(String.valueOf(cnt));
		bw.close();
	}

}
