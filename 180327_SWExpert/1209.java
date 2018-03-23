import java.util.Scanner;
public class 1209{
	static int arr[][];
	
	void sum() {
		Scanner sc = new Scanner(System.in);
		for(int i=1;i<11;i++) {
			int n=sc.nextInt();
			int answer=1;
			arr = new int [100][100];
			for(int j=0;j<100;j++) {
				for(int k=0;k<100;k++) {
					arr[j][k] = sc.nextInt();
				}
			}
			answer = solve();
			System.out.println("#"+n+" ");
			System.out.println(answer);
		}
	}
	
	int solve() {
		int max=0;
		int sum=0;
		int sum2=0;
		int sum3=0;
		int sum4=0;
		
		for(int i=0;i<100;i++) {
			sum=0;
			sum2=0;
			for(int j=0;j<100;j++) {
				sum+=arr[i][j];
				sum2+=arr[j][i];
			}
			sum3 += arr[i][i];
			sum4 += arr[99-i][i];
			if(max<sum||i==0)
				max = sum;
			if(max<sum2)
				max = sum2;
		}
		if(sum3>max)
			max = sum3;
		if(sum4>max)
			max = sum4; 
		
		return max;
	}
	
	public static void main(String[] args) {
		new 1209().sum();
		
	}

}
