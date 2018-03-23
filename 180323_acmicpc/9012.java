import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int num = input.nextInt();
		Stack stck = new Stack();
		boolean isNotVPS;

		while (num--!=0) {
			isNotVPS=false;
			stck.removeAllElements();
			String VPS = input.next();
			for (int i = 0; i < VPS.length(); i++) {
				if (VPS.charAt(i) == '(')
					stck.push(VPS.charAt(i));
				else{
					if(stck.isEmpty()){
						isNotVPS=true;
						break;
					}
						
					stck.pop();
				}
			}
			if (!isNotVPS&&stck.isEmpty())
				System.out.println("YES");
			else
				System.out.println("NO");
		}
	}

}