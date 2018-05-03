import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// https://www.acmicpc.net/problem/11728
// �ּ����� ó���� ����� ���� ����� ��� �ΰ��� �� �غôµ� �� Ʋ�Ƚ��ϴ� �ߴ��� �𸣰���.
// �Է� �κп��� ������ ������ ���� �ִٰ� ����.
public class Main {
	void MergeArr() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine().trim();
		int n = s.charAt(0)-'0';		//�迭 A�� ũ��
		int m = s.charAt(2)-'0';		//�迭 B�� ũ��
		StringTokenizer st1 = new StringTokenizer(br.readLine().trim()," ");
		int arrA[] = new int[n];	//�迭 A
		int arrB[] = new int[m];	//�迭 B
		for(int i=0;i<n;i++) {
			arrA[i] = Integer.parseInt(st1.nextToken());
		}
		StringTokenizer st2 = new StringTokenizer(br.readLine().trim()," ");
		for(int i=0;i<m;i++) {
			arrB[i] = Integer.parseInt(st2.nextToken());
		}
		
		int result_arr[] = new int[n+m];
		Merge(arrA,arrB,result_arr);
		//for(int i=0;i<n+m;i++)
		//	System.out.print(result_arr[i]+" ");
		System.out.println();
		
		br.close();
	}
	
	void Merge(int arrA[], int arrB[], int result[]) {
		int idx_A=0;
		int idx_B=0;
		int idx=0;
		while(idx_A!=arrA.length&&idx_B!=arrB.length) {
			if(arrA[idx_A]>arrB[idx_B]) 
				System.out.print(arrB[idx_B++]+" ");
				//result[idx++] = arrB[idx_B++];
			else
				System.out.print(arrA[idx_A++]+" ");
				//result[idx++] = arrA[idx_A++];
		}
		if(idx_A==arrA.length) {
			while(idx_B!=arrB.length)
				System.out.print(arrB[idx_B++]+" ");
				//result[idx++] = arrB[idx_B++];
		}else if(idx_B==arrB.length)
			while(idx_A!=arrA.length)
				System.out.print(arrA[idx_A++]+" ");
				//result[idx++] = arrA[idx_A++];
		
	}
	public static void main(String[] args) throws IOException {
		new Main().MergeArr();
	}

}
