import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
//https://www.acmicpc.net/problem/9019
public class Main {
	static char[] operation = {'D','S','L','R'};
	
	class Calculator{
		int num;
		String oper;
		Calculator(int num, String oper){
			this.num = num;
			this.oper = oper;
		}
	}
	
	void DSLR(int before, int after) {
		Queue<Calculator> q = new LinkedList<Calculator>();
		boolean[] isVisited = new boolean[10000];
		q.add(new Calculator(before,""));
		
		while(!q.isEmpty()) {
			Calculator calc = q.poll();
			if(calc.num == after) {
				System.out.println(calc.oper);
				return;
			}
			for(int i=0;i<4;i++) {
				switch(operation[i]) {
				case 'D':
					int temp_num = (calc.num*2)%10000;
					if(!isVisited[temp_num]) {
						q.add(new Calculator(temp_num,calc.oper+"D"));
						isVisited[temp_num] = true;
					}
					break;
				case 'S':
					int tmp_num = calc.num==0?9999:calc.num-1;
					if(!isVisited[tmp_num]) {
						q.add(new Calculator(tmp_num,calc.oper+"S"));
						isVisited[tmp_num] = true;
					}
					break;
				case 'L':
					char arr[] = new char[4];
					int tmp = calc.num;
					for(int j=3;j>=0;j--) {
						arr[j] = (char)(tmp%10+'0');
						tmp/=10;
					}
					int result_L = 0;
					result_L = (int)(arr[1]-'0')*1000+(int)(arr[2]-'0')*100+
							(int)(arr[3]-'0')*10+(int)(arr[0]-'0');
					if(!isVisited[result_L]) {
						q.add(new Calculator(result_L,calc.oper+"L"));
					}
					break;
				case 'R':
					char arr_R[] = new char[4];
					int tmp_R = calc.num;
					for(int j=3;j>=0;j--) {
						arr_R[j] = (char)(tmp_R%10+'0');
						tmp_R/=10;
					}
					int result_R = 0;
					result_R = (int)(arr_R[3]-'0')*1000+(int)(arr_R[0]-'0')*100+
							(int)(arr_R[1]-'0')*10+(int)(arr_R[2]-'0');
					if(!isVisited[result_R]) {
						q.add(new Calculator(result_R,calc.oper+"R"));
					}
					break;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int testcase = sc.nextInt();
		for(int t=0;t<testcase;t++) {
			int before = sc.nextInt();
			int after = sc.nextInt();
			new Main().DSLR(before, after);
		}
	}

}
