/* Top Coder p.320 Hamilton Path
 * 
 * I/O data
0)
String[] roads = {"NYN",
				  "YNN",
				  "NNN"};
Returns: 4

1)
String[] roads = {"NYYY",
				  "YNNN",
				  "YNNN",
				  "YNNN"};
Returns : 0

2)
String[] roads = {"NYY",
				  "YNY",
				  "YYN"};
Returns : 0

3)
String[] roads = {"NNNNNY",
				  "NNNNYN",
				  "NNNNYN",
				  "NNNNNN",
				  "NYYNNN",
				  "YNNNNN"};
Returns : 24
*/
public class HamiltonPath {
	boolean[] visited;
	public int countPaths(String[] roads) {
		int group = 0, free = 0;
		int[] connect = new int[roads.length];
		long sum = 1;
		
		visited = new boolean[roads.length];
		
		for(int i=0;i<roads.length;i++)
		{
			int y = 0;
			for (int j=0;j<roads[i].length();j++) {
				if(roads[i].charAt(j)=='Y') {
					if(2<++y)return 0;
				}
			}
			connect[i] = y;
		}
		
		for(int i=0;i<connect.length;i++) {
			if(connect[i]==0) {
				visited[i] = true;
				free++;
			}else if(connect[i] == 1 && !visited[i]) {
				group++;
				dfs(i, roads);
			}
		}
		
		for(int i=0;i<visited.length;i++)
			if(!visited[i]) return 0;
		for(int i=0;i<group+free; i++)
			sum=sum*(i+1)%1000000007;
		for(int i=0;i<group;i++)
			sum=sum*2%1000000007;
		return (int)sum;
	}
	
	void dfs(int city, String[] roads) {
		visited[city] = true;
		for(int i=0;i<roads[city].length();i++)
			if(roads[city].charAt(i)=='Y'&&!visited[i]) dfs(i,roads);
	}

	public static void main(String[] args) {
		String[] roads = {"NNNNNY",
				  "NNNNYN",
				  "NNNNYN",
				  "NNNNNN",
				  "NYYNNN",
				  "YNNNNN"};

		System.out.println(new HamiltonPath().countPaths(roads));
	}

}