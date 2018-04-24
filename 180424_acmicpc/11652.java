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
		//�ð��� ���̱� ���� Scanner ���� Buffer reader �̿�
		int n = Integer.parseInt(br.readLine().trim());
		
		BigInteger[] num = new BigInteger[n];
		
		for(int i=0;i<n;i++){
			num[i] = new BigInteger(br.readLine().trim());
		}
		
		Arrays.sort(num);	//�������� ����
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BigInteger maxnum = BigInteger.ZERO;		// ���� ���� �ִ� ��
		int maxcnt = 0;								// ���� ���� ����
		BigInteger curNum = num[0];					//���� ��
		int curCnt = 0;								//���� ����
		
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
		//bw.flush();  ����ϸ� �ð��ʰ�.
		br.close();
		bw.close();
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		new Main().Card();
	}
}
