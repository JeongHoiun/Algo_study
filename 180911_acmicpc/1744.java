import java.util.Arrays;
import java.util.Scanner;

/*
 * ����� ���� ū ������ ���´�.
 * ������ ���밪�� ū ������ ���´�
 * ������ Ȧ������ ��� -> 0�� ���� ��� ���밪�� ���� ���� ���� 0�� �Բ� ���´�
 * ������ Ȧ������ ��� -> 0�� ���� ��� ���� �ʴ´�.
 */
public class Main {
	int sumOfSet(int[] arr) {
		int sum =0;
		Arrays.sort(arr);
		int i;
		int j;
		boolean iszero = false;
		for(i=arr.length-1;i>0;i-=2) {
			if(arr[i-1]<=1) break;
			sum+=arr[i]*arr[i-1];
		}
		for(j=0;j<arr.length-1;j+=2) {
			if(arr[j+1]>=0) {
				if(arr[j]==0||arr[j+1]==0)
					iszero = true;
				break;
			}
			sum+=arr[j]*arr[j+1];
		}
		//���� ����� ��
		if(arr[j]<0&&iszero) {
			j+=2;
		}
		for(;j<=i;j++) sum+=arr[j];
		return sum;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
		}
		System.out.println(new Main().sumOfSet(arr));
	}

}
