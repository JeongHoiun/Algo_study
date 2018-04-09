// 3665  INCOMPLETE

import java.util.LinkedList;
import java.util.Scanner;

public class Main {
	void finalGrade() {
		/*
		 * numOfTeam : 팀의 갯수
		 * lastGrade : 전년도 순위
		 * numOfChg  : 등수가 바뀐 쌍의 수
		 * chgGrade  : 상대적인 등수가 바뀐 두팀
		 * ingreed   : 그래프의 진입차수
		 */
		Scanner sc= new Scanner(System.in);
		int testcase = sc.nextInt();
		for(int t=1;t<=testcase;t++) {
			int numOfTeam =sc.nextInt();
			int[] lastGrade = new int[numOfTeam+1];
			int[] ingreed = new int[numOfTeam+1];
			for(int i=1;i<=numOfTeam;i++) 
				lastGrade[i] = sc.nextInt();
			int numOfChg = sc.nextInt();
			int chgGrade[][] = new int[numOfChg][2];
			for(int i=0;i<numOfChg;i++) {
				chgGrade[i][0] = sc.nextInt();
				chgGrade[i][1] = sc.nextInt();
				ingreed[chgGrade[i][1]] ++;
			}
			chg(lastGrade,chgGrade,ingreed);
		}
	}
	
	void chg(int[] lastGrade, int chgGrade[][], int ingreed[]) {
		/*
		 * - param -
		 * lastGrade : 전년도 순위
		 * chgGrade  : 상대적인 등수가 바뀐 두팀
		 * ingreed   : 그래프의 진입차수
		 * Mid		: 순위를 정할 수 없는 경우를 알아내기 위한 flag
		 * is		: 순위 변동과 관계없는 숫자의 경우
		 *
		 * - variable -
		 * curGrade	: 현재 순위를 저장할 배열
		 * gradeIndex : curGrade의 인덱스
		 * 
		 * - function -
		 * Q에 모든 노드를 저장하여 진입차수가 없는 경우
		 * 그대로 순위에 반영, 진입차수가 있는 경우
		 * 순위가 변경되어야 하므로 큐에 다시 넣음.
		 * 넣을 땐 맨 뒤가 아닌 index1에 넣어 매번 확인시켜줌.
		 */
		int curGrade[] = new int[lastGrade.length-1];
		int gradeIndex = 0;
		LinkedList<Integer> q = new LinkedList<Integer>();
		
		for(int i=1;i<lastGrade.length;i++)
			q.add(lastGrade[i]);
		boolean Mid=false;
		while(!q.isEmpty()) {
			int cur = q.get(0);
			q.remove(0);
			if(ingreed[cur]!=0) {
				q.add(1, cur);		//1에 넣으면 안됨, 다음것도 ingreed가 0이 아니면 무한루프 돌게 됨
				Mid=true;
				continue;
			}
			boolean is = false;
			for(int i=0;i<chgGrade.length;i++) {
				if(chgGrade[i][0] == cur) {
					curGrade[gradeIndex++] = cur;
					ingreed[chgGrade[i][1]]--;
					is = true;
					break;
				}else if(chgGrade[i][1] == cur) {
					curGrade[gradeIndex++] = cur;
					ingreed[chgGrade[i][0]]--;
					is = true;
					break;
				}
			}
			
			if(!is&&Mid) {
				System.out.println("?");
				return;
			}
			else if(!is&&!Mid)
				curGrade[gradeIndex++] = cur;
			Mid= false;
			
		}
		for(int i=0;i<chgGrade.length;i++) {
			if(chgGrade[i][0] >0) {
				System.out.println("IMPOSSIBLE");
				return;
			}
		}
		for(int i=0;i<curGrade.length;i++) {
			System.out.print(curGrade[i]+" ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		new Main().finalGrade();
	}

}