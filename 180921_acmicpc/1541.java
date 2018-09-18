import java.util.Scanner;
//https://www.acmicpc.net/problem/1541
public class Main {
	public int lostParen(String s) {
		int sum = 0;
		boolean isPlus = true;
		int num = 0;
		for(int i=0;i<s.length();i++) {
			if(s.charAt(i)=='-'){
				if(isPlus)
					sum+=num;
				else
					sum-=num;
				isPlus = false;
				num=0;
			}
			else if(s.charAt(i)=='+') {
				if(isPlus)
					sum+=num;
				else
					sum-=num;
				num=0;
			}else {
				num*=10;
				num+=(int)(s.charAt(i)-'0');
			}
			
		}
		if(isPlus)
			sum+=num;
		else
			sum-=num;
		
		return sum;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		
		System.out.println(new Main().lostParen(s));
	}

}
