import java.util.Scanner;
import java.util.Stack;

public class Main {	//Q.1005
	//timeover
	
	static int delay[];
	static int buildingDelay[];
	static boolean orderBuilding[][];
	
	void ACMCraft() {
		Scanner sc = new Scanner(System.in);
		int testcase = sc.nextInt();
		
		for(int T=1;T<=testcase;T++) {
			int numOfBuilding,numOfRule;
			numOfBuilding = sc.nextInt();
			numOfRule = sc.nextInt();
			buildingDelay = new int[numOfBuilding+1];
			for(int D = 1 ; D<=numOfBuilding ; D++)
				buildingDelay[D] = sc.nextInt();
			orderBuilding = new boolean[numOfBuilding+1][numOfBuilding+1];
			for(int K =0; K < numOfRule ;K++) {
				int x, y;
				x= sc.nextInt();
				y= sc.nextInt();
				orderBuilding[x][y] = true;
			}
			int winBuilding = sc.nextInt();
			delay = new int[1001];
			//여기까지가 입력..
			System.out.println(delayOfConstruction(winBuilding));
		}
	}
	
	int delayOfConstruction(int winBuilding)
	{
		if(delay[winBuilding] != 0) {
			return delay[winBuilding];
		}
		else {
			int result = 0;
			for(int i=1;i<buildingDelay.length;i++) {
				if(orderBuilding[i][winBuilding])
					result = Math.max(result, delayOfConstruction(i));
			}
			return delay[winBuilding] = result + buildingDelay[winBuilding];
		}
	}
	
	//bfs
	/*int delayOfConstruction(int winBuilding) {
		int delay[] = new int[buildingDelay.length];		//걸리는 시간총합
		boolean Start[] = new boolean[buildingDelay.length];		//시작지점이 여러개일 경우도 있을것이라 생각.
		boolean isStart=true;		
		Stack<Integer> st = new Stack<Integer>();
		
		st.push(winBuilding);
		st.push(buildingDelay[winBuilding]);
		
		int curBuilding,curDelay;
		
		while(!st.isEmpty()) {
			curDelay = st.pop();
			curBuilding = st.pop();
			if(delay[curBuilding]<curDelay) {
				delay[curBuilding]=curDelay;
			}
			isStart = true;
			for(int i=1;i<=buildingDelay.length-1;i++) {
				if(orderBuilding[i][curBuilding]) {
					st.push(i);
					st.push(curDelay+buildingDelay[i]);
					isStart = false;
				}
			}
			if(isStart)
				Start[curBuilding] = true;
		}
		int min = Integer.MAX_VALUE;
		for(int i=1;i<=delay.length-1;i++) {
			if(Start[i]==true&&min>delay[i])
				min = delay[i];
		}
		
		return min;
	}*/
	
	
	public static void main(String[] args) {
		new Main().ACMCraft();
	}

}
