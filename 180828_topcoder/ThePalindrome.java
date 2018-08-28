/* Top Coder p.112 ThePalindrome
 * 
 * I/O data
 0)
 String s = "abab";
 Returns : 5

 1)
 String s = "abacaba";
 Returns : 7

 2)
 String s = "qwerty";
 Returns : 11

 3)
 String s = "abdfhdyrbdbsdfghjkllkjhgfds";
 Returns : 38
 */
public class ThePalindrome {
	public int find(String s){
		String tmp="";
		int result = s.length();
		int cnt = 0;
		for(int i=s.length()-1;i>=0;i--) {
			tmp+=s.charAt(i);
		}
		while(true) {
			if(tmp.compareTo(s)==0) {
				result += cnt;
				break;
			}else {
				tmp = tmp.substring(0, tmp.length()-1);
				s = s.substring(1, s.length());
				cnt++;
			}
		}
		return result;
	}
	public static void main(String[] args) {
		 String s = "abdfhdyrbdbsdfghjkllkjhgfds";
		System.out.println(new ThePalindrome().find(s));
	}

}