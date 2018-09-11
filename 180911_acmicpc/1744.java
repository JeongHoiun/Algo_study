import java.util.Arrays;
import java.util.Scanner;

/*
 * 양수는 값이 큰 값끼리 묶는다.
 * 음수는 절대값이 큰 값끼리 묶는다
 * 음수가 홀수개인 경우 -> 0이 있을 경우 절대값이 가장 작은 값과 0을 함께 묶는다
 * 음수가 홀수개인 경우 -> 0이 없을 경우 묶지 않는다.
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
		//남은 경우의 수
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
