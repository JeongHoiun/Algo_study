import java.util.Scanner;

public class Main {
	//시간초과..
	final static int MAX_NUM = 10000;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[] count = new int[MAX_NUM+1];
		int[] countSum = new int[MAX_NUM+1];
		
		int sizeOfNum = sc.nextInt();

		int num[] = new int[sizeOfNum+1];
		int result[] = new int[sizeOfNum+1];
		
		for(int i=1;i<=sizeOfNum;i++) {
			num[i] = sc.nextInt();
			count[num[i]]++;
		}

		for(int i=1;i<=MAX_NUM;i++) {
			countSum[i] = countSum[i-1]+count[i];
		}
		
		for(int i=sizeOfNum;i>=1;i--) {
			result[countSum[num[i]]] = num[i];
			countSum[num[i]]--;
		}
		
		for(int i=1;i<=sizeOfNum;i++) {
			System.out.println(result[i]);
		}
		
	}

}
