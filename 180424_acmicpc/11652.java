//https://www.acmicpc.net/problem/11652
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.Arrays;

class Main{
	void Card() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//시간을 줄이기 위해 Scanner 보단 Buffer reader 이용
		int n = Integer.parseInt(br.readLine().trim());
		
		BigInteger[] num = new BigInteger[n];
		
		for(int i=0;i<n;i++){
			num[i] = new BigInteger(br.readLine().trim());
		}
		
		Arrays.sort(num);	//오름차순 정렬
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BigInteger maxnum = BigInteger.ZERO;		// 가장 많이 있는 수
		int maxcnt = 0;								// 가장 많은 갯수
		BigInteger curNum = num[0];					//현재 수
		int curCnt = 0;								//현재 갯수
		
		for (int i=0;i<n;i++) {
			if(curNum.equals(num[i])) {
				curCnt++;
			}else {
				if(curCnt>maxcnt) {
					maxcnt = curCnt;
					maxnum = curNum;
				}
				curCnt=1;
				curNum=num[i];
			}
		}
		
		if(curCnt>maxcnt) {
			maxcnt = curCnt;
			maxnum = curNum;
		}
		
		bw.write(maxnum + "\n");
		//bw.flush();  사용하면 시간초과.
		br.close();
		bw.close();
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		new Main().Card();
	}
}
