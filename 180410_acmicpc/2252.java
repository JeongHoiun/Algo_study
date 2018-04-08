//2252

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	/*
	 * compare
	 */
	
	void lineUp() {
		Scanner sc = new Scanner(System.in);
		int numOfStudent = sc.nextInt();
		int student[] = new int[numOfStudent+1];
		for(int i=1;i<=numOfStudent;i++) {
			student[i] = i;
		}
		int numOfComp = sc.nextInt();
		int[][] compare = new int[numOfComp][2];
		int indegree[] = new int[numOfStudent+1];
		
		
		for(int i=0;i<numOfComp;i++) {
			compare[i][0] = sc.nextInt();
			compare[i][1] = sc.nextInt();
			indegree[compare[i][1]]++;
		}
		
		Queue<Integer> lineup = new LinkedList<Integer>();
		Queue<Integer> resultlineup = new LinkedList<Integer>();
		
		for(int i=1;i<=numOfStudent;i++)
			if(indegree[i]==0)
				lineup.offer(i);
		
		while(!lineup.isEmpty()) {
			int zeroIndegreeNode = lineup.poll();
			resultlineup.offer(zeroIndegreeNode);
			
			for(int i=0;i<numOfComp;i++) {
				if(compare[i][0]==zeroIndegreeNode) {
					indegree[compare[i][1]]--;
					if(indegree[compare[i][1]]==0)
						lineup.offer(compare[i][1]);
				}
			}
		}
		while(!resultlineup.isEmpty())
			System.out.print(resultlineup.poll()+" ");
		
		/*for(int i=1;i<=numOfStudent;i++)
			lineup.add(i);
		while(!lineup.isEmpty()) {
			int cur = lineup.poll();
			if(ingreed[cur]!=0) {
				lineup.add(cur);
				continue;
			}
			boolean is = false;
			for(int i=0;i<numOfComp;i++) {
				if(compare[i][0] == cur) {
					System.out.print(cur+" ");
					ingreed[compare[i][1]]--;
					is = true;
					break;
				}
			}
			if(!is)
				System.out.print(cur+" ");
		}
		System.out.println();*/
		
	}
	
	
	public static void main(String[] args) {
		new Main().lineUp();
	}

}
