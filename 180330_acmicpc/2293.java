import java.util.Scanner;

public class Main {		//Q.2293
	
	static int coins[][];
	
	void coin1() {
		Scanner sc = new Scanner(System.in);
		int numOfCoin = sc.nextInt();
		int howMuch = sc.nextInt();
		int coin[] = new int[numOfCoin+1];
		coins = new int[numOfCoin+1][10001];
		for(int i=1;i<=numOfCoin;i++) {
			coin[i] = sc.nextInt();
		}
		for(int i=1;i<=numOfCoin;i++)
			coins[i][0]=1;
		for(int j=1;j<=numOfCoin;j++) {
			for(int i=1;i<=howMuch;i++) {
				if(i>=coin[j])
					coins[j][i]=coins[j-1][i]+coins[j][i-coin[j]];
				else
					coins[j][i]=coins[j-1][i];
			}
		}
		System.out.println(coins[numOfCoin][howMuch]);
	}

	public static void main(String[] args) {
		new Main().coin1();
	}
}
