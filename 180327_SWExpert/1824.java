import java.util.Scanner;
import java.util.Random;
public class 1824{	//incomplete
	boolean isVisited[][][];
	boolean isVisited_direction[][][][];
	void verifyProgramming() {
		Scanner sc = new Scanner(System.in);
		int testcase = sc.nextInt();
		for(int t=1;t<=testcase;t++) {
			System.out.print("#"+t+" ");
			int row,col;
			row = sc.nextInt();
			col = sc.nextInt();
			isVisited = new boolean[row][col][16];		// 현재 위치를 현재의 숫자로 방문한적 있는지
			isVisited_direction = new boolean[row][col][16][4];	//현재 위치를 현재 숫자, 현재 방향으로 방문한적 있는지
			String character[] = new String[row];
			for(int i=0;i<row;i++) {
				character[i] = sc.next();
			}
			if(moving(character,row,col))
				System.out.println("YES");
			else
				System.out.println("NO");
		}
	}
	
	boolean moving(String[] character,int row, int col) {
		int curPosX=0, curPosY=0;
		int memory=0;
		int direction=0;	// 0 : > , 1 : < , 2 : ^ , 3: v
		while(true) {
			switch(character[curPosY].charAt(curPosX)) {

			case '<':
				if(isVisited(curPosY,curPosX,memory))
					return false;
				direction = 1;
				break;
			case '>':
				if(isVisited(curPosY,curPosX,memory))
					return false;
				direction = 0;
				break;
			case '^':
				if(isVisited(curPosY,curPosX,memory))
					return false;
				direction = 2;
				break;
			case 'v':
				if(isVisited(curPosY,curPosX,memory))
					return false;
				direction = 3;
				break;
			case '_':
				if(isVisited(curPosY,curPosX,memory))
					return false;
				if(memory==0)
					direction = 0;
				else
					direction = 1;
				break;
			case '|':
				if(isVisited(curPosY,curPosX,memory))
					return false;
				if(memory==0)
					direction = 3;
				else
					direction = 2;
				break;
			case '?':
				direction= (int)(Math.random()*4);
				boolean isNotAllVisit=false;
				for(int i=0;i<4;i++) {
					if(!isVisited(curPosY,curPosX,memory,direction))
						isNotAllVisit = true;
				}
				if(!isNotAllVisit)
					return false;
				break;
			case '.':
				if(isVisited(curPosY,curPosX,memory,direction))
					return false;
				break;
			case '@':
				return true;
			case '+':
				if(isVisited(curPosY,curPosX,memory,direction))
					return false;
				memory++;
				if(memory==16)
					memory=0;
				break;
			case '-':
				if(isVisited(curPosY,curPosX,memory,direction))
					return false;
				memory--;
				if(memory==-1)
					memory=15;
				break;
			default :
				if(isVisited(curPosY,curPosX,memory,direction))
					return false;
				memory = character[curPosY].charAt(curPosX)-48;
			}


			switch(direction) {
			case 0:
				curPosX++;
				if(curPosX==col)
					curPosX=0;
				break;
			case 1:
				curPosX--;
				if(curPosX<0)
					curPosX=col-1;
				break;
			case 2:
				curPosY--;
				if(curPosY<0)
					curPosY=row-1;
				break;
			case 3:
				curPosY++;
				if(curPosY==row)
					curPosY=0;
				break;
			}
		}
		
	}
	
	boolean isVisited(int row, int col, int num, int direction) {
		if(isVisited_direction[row][col][num][direction])
			return true;
		else {
			isVisited_direction[row][col][num][direction] = true;
			return false;
		}
	}
	boolean isVisited(int row, int col, int num) {
		if(isVisited[row][col][num])
			return true;
		else {
			isVisited[row][col][num] = true;
			return false;
		}
	}
	
	
	
	public static void main(String[] args) {

		new 1824().verifyProgramming();
	}

}
