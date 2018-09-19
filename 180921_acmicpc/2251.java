import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static Queue<String> list = new LinkedList<String>();
	static HashMap<String, Boolean> map = new HashMap<String, Boolean>();
	static ArrayList<Integer> st = new ArrayList<Integer>();
	void qMap(int[] num) {
		
		String save_num="";
		for(int i=0;i<3;i++) {
			int baek = num[i]/100;
			int sip = (num[i]%100)/10;
			int il = num[i]%10;
			save_num+=baek;
			save_num+=sip;
			save_num+=il;
		}
		if(map.containsKey(save_num)) return;
		if(num[0] == 0)
			st.add(num[2]);
		map.put(save_num, true);
		list.add(save_num);
	}
	
	void waterBottle(int a, int b, int c,int[] num) {
		qMap(num);
		
		while(!list.isEmpty()) {
			String now_bottle = list.poll();
			int bot_A = (int)(now_bottle.charAt(0)-'0')*100+(int)(now_bottle.charAt(1)-'0')*10+
					(int)(now_bottle.charAt(2)-'0');
			int bot_B = (int)(now_bottle.charAt(3)-'0')*100+(int)(now_bottle.charAt(4)-'0')*10+
					(int)(now_bottle.charAt(5)-'0');
			int bot_C = (int)(now_bottle.charAt(6)-'0')*100+(int)(now_bottle.charAt(7)-'0')*10+
					(int)(now_bottle.charAt(8)-'0');
			if(bot_A>0) {
				if(bot_B<b) {
					int[] bot = new int[3];
					if(bot_A+bot_B>b) {
						bot[0] = bot_A+bot_B-b;
						bot[1] = b;
						bot[2] = bot_C;
						qMap(bot);
					}else {
						bot[0] = 0;
						bot[1] = bot_A+bot_B;
						bot[2] = bot_C;
						qMap(bot);
					}
				}if(bot_C<c) {
					int[] bot = new int[3];
					if(bot_A+bot_C>c) {
						bot[0] = bot_A+bot_C-c;
						bot[1] = bot_B;
						bot[2] = c;
						qMap(bot);
					}else {
						bot[0] = 0;
						bot[1] = bot_B;
						bot[2] = bot_A+bot_C;
						qMap(bot);
					}
				}
			}if(bot_B>0) {
				if(bot_A<a) {
					int[] bot = new int[3];
					if(bot_B+bot_A>a) {
						bot[0] = a;
						bot[1] = bot_B+bot_A-a;
						bot[2] = bot_C;
						qMap(bot);
					}else {
						bot[0] = bot_A+bot_B;
						bot[1] = 0;
						bot[2] = bot_C;
						qMap(bot);
					}
				}if(bot_C<c) {
					int[] bot = new int[3];
					if(bot_B+bot_C>c) {
						bot[0] = bot_A;
						bot[1] = bot_B+bot_C-c;
						bot[2] = c;
						qMap(bot);
					}else {
						bot[0] = bot_A;
						bot[1] = 0;
						bot[2] = bot_B+bot_C;
						qMap(bot);
					}
				}
			}if(bot_C>0) {
				if(bot_B<b) {
					int[] bot = new int[3];
					if(bot_C+bot_B>b) {
						bot[0] = bot_A;
						bot[1] = b;
						bot[2] = bot_C+bot_B-b;
						qMap(bot);
					}else {
						bot[0] = bot_A;
						bot[1] = bot_C+bot_B;
						bot[2] = 0;
						qMap(bot);
					}
				}if(bot_A<a) {
					int[] bot = new int[3];
					if(bot_A+bot_C>a) {
						bot[0] = a;
						bot[1] = bot_B;
						bot[2] = bot_A+bot_C-a;
						qMap(bot);
					}else {
						bot[0] = bot_A+bot_C;
						bot[1] = bot_B;
						bot[2] = 0;
						qMap(bot);
					}
				}
			}
		}
		
		
		int[] arr = new int[st.size()];
		for(int i=0;i<st.size();i++) {
			arr[i] += (int)(st.get(i));
		}
		Arrays.sort(arr);
		
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c=  sc.nextInt();
		
		int[] cur = new int[3];
		cur[0]=cur[1]= 0;
		cur[2] = c;
		
		new Main().waterBottle(a,b,c,cur);
	}

}
