import java.util.Scanner;

public class Main {		//2156
	int dp[];
	void wine() {
		Scanner sc = new Scanner(System.in);
		int numOfWine = sc.nextInt();
		dp = new int[numOfWine+10];
		int wine[] = new int[numOfWine+10];
		for(int i=1;i<=numOfWine;i++)
			wine[i] = sc.nextInt();
		System.out.println(drinkWine(wine,numOfWine));
	}
	
	int drinkWine(int wine[], int numOfWine) {
		dp[1] = wine[1];
		dp[2] = wine[1]+wine[2];
		dp[2] = Math.max(wine[2]+dp[0], wine[2]+dp[1]);
	
		for(int i=3;i<=numOfWine;i++)
			dp[i] = Math.max(Math.max(wine[i]+dp[i-2],dp[i-1]), wine[i]+wine[i-1]+dp[i-3]);
		
		
		return dp[numOfWine];
		
	}
	
	public static void main(String[] args) {
		new Main().wine();

	}

}
