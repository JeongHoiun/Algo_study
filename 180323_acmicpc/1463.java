import java.util.Scanner;

public class Main {
	static int num;
	static int cnt[]= new int[1000001];
	public static int min(int a,int b,int c){
		if(a<=b&&a<=c)
			return a;
		else if(b<=a&&b<=c)
			return b;
		else
			return c;
	}
	public static int cal(int n){
		if (n==1){
			return 0;
		}
		if (cnt[n]!=0)
			return cnt[n];
		if((n%3==0)&&(n%2==0)){
			return cnt[n] = min(cal(n/3),cal(n/2),cal(n-1))+1;
		}
		if((n%3==0)&&(n%2!=0))
			return cnt[n] = Math.min(cal(n/3),cal(n-1))+1;
		if((n%2==0)&&(n%3!=0)){
			return cnt[n] = Math.min(cal(n/2)+1,cal(n-1)+1);
		}
		else{
			return cnt[n] = Math.min(cal(n-1)+1,cal(n-1)+1);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		num = sc.nextInt();
		int c=0;
		cnt[1] = 0;
		cal(num);
		System.out.println(cnt[num]);
	}

}
