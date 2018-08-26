/* Top Coder p.84 Interesting Party
 * 
 * I/O data
0)
int[] first = {"fishing", "gardening", "swimming", "fishing"};
int[] second = {"hunting", "fishing", "fishing", "biting"};

Returns : 4

1)
String[] first = {"variety", "diversity", "loquacity", "courtesy"}; 
String[] second = {"talking", "speaking", "discussion", "meeting"};

Returns : 1

2)
String[] first = {"snakes", "programming", "cobra", "monty"};
String[] second = {"python", "python", "anaconda", "python"};

Returns : 3

3)
String[] first = {"t", "o", "p", "c", "o", "d", "e", "r", "s", "i", "n", "g", "l", "e", "r", "o", "u",
			"n", "d", "m", "a", "t", "c", "h", "f", "o", "u", "r", "n", "i"};
String[] second = {"n", "e", "f", "o", "u", "r", "j", "a", "n", "u", "a", "r", "y", "t", "w", "e", "n",
			"t", "y", "t" ,"w" ,"o", "s", "a", "t", "u", "r", "d", "a", "y"};
			
Returns : 6

*/
public class InterestingParty {

	public int bestInvitation(String[] first, String[] second) {
		int max = 0;
		boolean isVisited[][] = new boolean[first.length][2];
		//이미 사용했던 문자열은 다시 카운팅하지 않기에 필요없는 부분은 지움.
		for(int i=0; i<first.length;i++) {
			int cnt=0;
			if(!isVisited[i][0]) {		//i의 first와 같은 문자열 확인.
				for(int j=0; j<first.length;j++) {
					if(first[i]==first[j]) {
						isVisited[j][0] = true;
						cnt ++;
					}
					if(first[i]==second[j]) {
						isVisited[j][1] = true;
						cnt++;
					}
				}
				max = cnt>max?cnt:max;
			}
			cnt =0;
			if(!isVisited[i][1]) {	//i의 second와 같은 문자열 확인
				for(int j=0; j<second.length;j++) {
					if(second[i]==first[j]) {
						isVisited[j][0] = true;
						cnt ++;
					}
					if(second[i]==second[j]) {
						isVisited[j][1] = true;
						cnt++;
					}
				}
				max = cnt>max?cnt:max;
			}
			cnt = 0;
		}
		return max;
	}
	public static void main(String[] args) {
		String[] first = {"t", "o", "p", "c", "o", "d", "e", "r", "s", "i", "n", "g", "l", "e", "r", "o", "u",
				"n", "d", "m", "a", "t", "c", "h", "f", "o", "u", "r", "n", "i"};
		String[] second = {"n", "e", "f", "o", "u", "r", "j", "a", "n", "u", "a", "r", "y", "t", "w", "e", "n",
				"t", "y", "t" ,"w" ,"o", "s", "a", "t", "u", "r", "d", "a", "y"};
		
		System.out.println(new InterestingParty().bestInvitation(first, second));
	}

}
