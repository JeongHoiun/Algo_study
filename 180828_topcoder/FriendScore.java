/* Top Coder p.120 FriendScore
 * 
 * I/O data
0) 
String[] friends = { "NNN",
                     "NNN",
                     "NNN" };
   Returns: 0
   
1) 
String[] friends = { "NYY",
                     "YNY",
                     "YYN" };
   Returns: 2
   
2) 
String[] friends = { "NYNNN",
                     "YNYNN",
                     "NYNYN",
                     "NNYNY",
                     "NNNYN" };
   Returns: 4

3) 
String[] friends = { "NNNNYNNNNN",
                     "NNNNYNYYNN",
                     "NNNYYYNNNN",
                     "NNYNNNNNNN",
                     "YYYNNNNNNY",
                     "NNYNNNNNYN",
                     "NYNNNNNYNN",
                     "NYNNNNYNNN",
                     "NNNNNYNNNN",
                     "NNNNYNNNNN" };
   Returns: 8       
   
4) 
String[] friends = { "NNNNNNNNNNNNNNY",
			 		 "NNNNNNNNNNNNNNN",
					 "NNNNNNNYNNNNNNN",
					 "NNNNNNNYNNNNNNY",
					 "NNNNNNNNNNNNNNY",
					 "NNNNNNNNYNNNNNN",
					 "NNNNNNNNNNNNNNN",
					 "NNYYNNNNNNNNNNN",
					 "NNNNNYNNNNNYNNN",
					 "NNNNNNNNNNNNNNY",
					 "NNNNNNNNNNNNNNN",
					 "NNNNNNNNYNNNNNN",
					 "NNNNNNNNNNNNNNN",
					 "NNNNNNNNNNNNNNN",
					 "YNNYYNNNNYNNNNN"};
   Returns: 6
*/

public class FriendScore {
	public int highestScore(String[] friends) {
		int max = 0;

		for(int i=0;i<friends.length;i++) {
			int cnt=0;
			boolean[] isVisited = new boolean[friends.length]; //i의 친구로 이미 셌을 경우를 대비.
			isVisited[i] = true;
			for(int j=0;j<friends[i].length();j++) {
				if(friends[i].charAt(j)=='Y'&&!isVisited[j]){//i의 직접친구인지 확인
					isVisited[j] = true;
					cnt++;
					for(int k=0;k<friends[j].length();k++) {
						if(friends[j].charAt(k)=='Y'&&!isVisited[k]) {	//i의 간접친구인지 확인
							isVisited[k] = true;
							cnt++;
						}
					}
				}
					
			}
			max = max<cnt?cnt:max;
		}
		
		return max;
	}
	
	public static void main(String[] args) {
		String[] friends = { "NNNNNNNNNNNNNNY",
		 		 "NNNNNNNNNNNNNNN",
				 "NNNNNNNYNNNNNNN",
				 "NNNNNNNYNNNNNNY",
				 "NNNNNNNNNNNNNNY",
				 "NNNNNNNNYNNNNNN",
				 "NNNNNNNNNNNNNNN",
				 "NNYYNNNNNNNNNNN",
				 "NNNNNYNNNNNYNNN",
				 "NNNNNNNNNNNNNNY",
				 "NNNNNNNNNNNNNNN",
				 "NNNNNNNNYNNNNNN",
				 "NNNNNNNNNNNNNNN",
				 "NNNNNNNNNNNNNNN",
				 "YNNYYNNNNYNNNNN"};
			
		System.out.println(new FriendScore().highestScore(friends));
	}

}
