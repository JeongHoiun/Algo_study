/*Top Coder p.158 MazeMaker
 * 
 * I/O data
0)
String[] maze = {"...",
				 "...",
				 "..."};
int startRow = 0;
int startCol = 1;
int[] moveRow = {1,0,-1,0};
int[] moveCol = {0,1,0,-1};
Returns: 3

1)
String[] maze = {"...",
				 "...",
				 "..."};
int startRow = 0;
int startCol = 1;
int[] moveRow = {1,0,-1,0,1,1,-1,-1};
int[] moveCol = {0,1,0,-1,1,-1,1,-1};
Returns: 2

2)
String[] maze = {"X.X",
				 "...",
				 "XXX",
				 "X.X"};
int startRow = 0;
int startCol = 1;
int[] moveRow = {1,0,-1,0};
int[] moveCol = {0,1,0,-1};
Returns: -1

3)
String[] maze = {".......",
				 "X.X.X..",
				 "XXX...X",
				 "....X..",
				 "X....X.",
				 "......."};
int startRow = 5;
int startCol = 0;
int[] moveRow = {1,0,-1,0,-2,1};
int[] moveCol = {0,1,0,-1,3,0};
Returns: 7

4)
String[] maze = {"......."};
int startRow = 0;
int startCol = 0;
int[] moveRow = {1,0,1,0,1,0};
int[] moveCol = {0,1,0,1,0,1};
Returns: 6

5)
String[] maze = {"..X.X.X.X.X.X."};
int startRow = 0;
int startCol = 0;
int[] moveRow = {2,0,-2,0};
int[] moveCol = {0,2,0,-2};
Returns: -1


 */
import java.util.Queue;
import java.util.LinkedList;

//moving¿Ã x{1,0,0,-1}, y{0,1,-1,0} ¥ÎΩ≈  moveRow, moveCol
public class MazeMaker {
	public int longestPath(String[] maze, int startRow, int startCol, int[] moveRow, int[] moveCol) {
		//DFS
		boolean isVisited[][] = new boolean[maze[0].length()][maze.length];

		Queue<Integer> stX = new LinkedList<Integer>();
		Queue<Integer> stY = new LinkedList<Integer>();
		Queue<Integer> stCnt = new LinkedList<Integer>();

		stX.add(startCol);
		stY.add(startRow);
		stCnt.add(1);
		int max = 0;

		int board[][] = new int[maze[0].length()][maze.length];

		while(!stX.isEmpty()&&!stY.isEmpty()) {
			int x = stX.poll();
			int y = stY.poll();
			int cnt = stCnt.poll();
			if(board[x][y]==0) {
				board[x][y] = cnt;
				cnt ++;
			}
			for(int i=0;i<moveRow.length;i++) {
				int tx = x+moveCol[i];
				int ty = y+moveRow[i];
				if(tx>=0&&ty>=0&&tx<maze[0].length()&&ty<maze.length&&board[tx][ty]==0&&maze[ty].charAt(tx)=='.') {
					stX.add(tx);
					stY.add(ty);
					stCnt.add(cnt);
				}
			}
		}

		for(int i=0;i<maze[0].length();i++) {
			for(int j=0;j<maze.length;j++) {
				if(maze[j].charAt(i)=='.'&&board[i][j]==0) {
					return -1;
				}else if(maze[j].charAt(i)=='.') {
					max = max<board[i][j]?board[i][j]:max;
				}
			}
		}

		return max-1;
	}



	public static void main(String[] args) {
		String[] maze = {"..X.X.X.X.X.X."};
		int startRow = 0;
		int startCol = 0;
		int[] moveRow = {2,0,-2,0};
		int[] moveCol = {0,2,0,-2};

		System.out.println(new MazeMaker().longestPath(maze, startRow, startCol, moveRow, moveCol));

	}

}
