import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	class Que{
		int num;
		int cnt;
		Que(int num, int cnt){
			this.num = num;
			this.cnt = cnt;
		}
	}
	int routePrime(int before,int after) {
		
		boolean[] isVisited = new boolean[10000];
		isVisited[before] = true;
		int[] num = new int[4];
		Queue<Que> q = new LinkedList<Que>();
		
		q.add(new Que(before,0));
		
		while(!q.isEmpty()) {
			Que n = q.poll();
			
			if(n.num==after) return n.cnt;


			for(int i=0;i<4;i++) {
				num[0] = n.num/1000;
				num[1] = (n.num%1000)/100;
				num[2] = (n.num%100)/10;
				num[3] = n.num%10;
				for(int j=0;j<10;j++) {
					num[i]=j;
					if(num[0] == 0) continue;
					int tmp = num[0]*1000+num[1]*100+num[2]*10+num[3];
					if(isPrime(tmp)&&!isVisited[tmp]) {
						q.add(new Que(tmp,n.cnt+1));
						isVisited[tmp] = true;
					}
				}
			}
		}
		
		
		
		
		return -1;
	}
	
	boolean isPrime(int n) {
		for(int i=2;i<=n/2;i++) {
			if(n%i==0) return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int testcase = sc.nextInt();
		for(int t=0;t<testcase;t++) {
			int before = sc.nextInt();
			int after = sc.nextInt();
			int result = new Main().routePrime(before, after);
			if(result==-1)
				System.out.println("Impossible");
			else
				System.out.println(result);
		}
	}
}
