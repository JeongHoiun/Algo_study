// 3665  INCOMPLETE

import java.util.LinkedList;
import java.util.Scanner;

public class Main {
	void finalGrade() {
		/*
		 * numOfTeam : ���� ����
		 * lastGrade : ���⵵ ����
		 * numOfChg  : ����� �ٲ� ���� ��
		 * chgGrade  : ������� ����� �ٲ� ����
		 * ingreed   : �׷����� ��������
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
		 * lastGrade : ���⵵ ����
		 * chgGrade  : ������� ����� �ٲ� ����
		 * ingreed   : �׷����� ��������
		 * Mid		: ������ ���� �� ���� ��츦 �˾Ƴ��� ���� flag
		 * is		: ���� ������ ������� ������ ���
		 *
		 * - variable -
		 * curGrade	: ���� ������ ������ �迭
		 * gradeIndex : curGrade�� �ε���
		 * 
		 * - function -
		 * Q�� ��� ��带 �����Ͽ� ���������� ���� ���
		 * �״�� ������ �ݿ�, ���������� �ִ� ���
		 * ������ ����Ǿ�� �ϹǷ� ť�� �ٽ� ����.
		 * ���� �� �� �ڰ� �ƴ� index1�� �־� �Ź� Ȯ�ν�����.
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
				q.add(1, cur);		//1�� ������ �ȵ�, �����͵� ingreed�� 0�� �ƴϸ� ���ѷ��� ���� ��
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