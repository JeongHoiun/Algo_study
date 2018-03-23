import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		String bracket = input.nextLine();
		Stack<Character> question=new Stack<Character>();
		char f;
		int mul=1,ans=0;
		for(int i=0;i<bracket.length();i++){
			if(bracket.charAt(i)=='['){
				question.push(bracket.charAt(i));
				mul*=3;
				if(bracket.charAt(i+1)==']') ans+=mul;
			}//([)]
			else if(bracket.charAt(i)=='('){
				question.push(bracket.charAt(i));
				mul*=2;
				if(bracket.charAt(i+1)==')')ans+=mul;
			}
			else if(!question.empty()&&bracket.charAt(i)==']'){
				if(question.pop()!='['){
					ans=0;
					break;
				}
				mul/=3;
			}
			else if(!question.empty()&&bracket.charAt(i)==')'){
				if(question.pop()!='('){
					ans=0;
					break;
				}
				mul/=2;
			}
		}
		if(!question.empty()||bracket.length()>30||bracket.length()<=0) ans=0;
		System.out.println(ans);
	}

}
