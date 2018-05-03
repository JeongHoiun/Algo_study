import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
	static Queue<Integer> q = new LinkedList<Integer>();
	static int counter = 0;		// 이동 횟수
	public static void move(int from, int to) {
		//하노이탑이 이동하는 곳 from -> to
		q.add(from);
		q.add(to);
		counter++;
	}
	public static void hanoi(int n, int from, int by, int to) {
		if(n == 1)		//바닥에 있는 타워
			move(from,to);
		else {
			// 하노이타워의 이동경로에 따라 이동.
			hanoi(n-1, from, to, by);
			move(from,to);
			hanoi(n-1, by, from, to);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int tower_num;
		
		tower_num = sc.nextInt();
		hanoi(tower_num, 1,2,3);
		
		System.out.println(counter);
		
		while(!q.isEmpty()) {
			System.out.println(q.poll()+" "+q.poll());
		}
	}
}
