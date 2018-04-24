//https://www.acmicpc.net/problem/10989
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Main{
	void Sort() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//�ð��� ���̱� ���� Scanner ���� Buffer reader �̿�
		int n = Integer.parseInt(br.readLine().trim());
		int arr[] = new int[10001];
		for(int i=0;i<n;i++){
			int k = Integer.parseInt(br.readLine().trim());
			arr[k]++;
			// ������ ���� INDEX�� Ȱ��
		}
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for (int i=1;i<10001;i++) {
			if(arr[i]>0) {
				for(int j=0;j<arr[i];j++) {
					bw.write(Integer.toString(i) + "\n");
					//bw.flush();
				}
			}
		}
		br.close();
		bw.close();
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		new Main().Sort();
	}
}
