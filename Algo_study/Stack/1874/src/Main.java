import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		Stack<Integer> stack = new Stack<Integer>();

		int num = input.nextInt();
		int stackNum[] = new int[num];
		int resultN=0,st=1;
		char result[]=new char[200000];
		
		boolean no = false;
		
		for (int i = 0; i < num; i++) {
			stackNum[i] = input.nextInt();
			if (stack.isEmpty()||(stack.peek() < stackNum[i]))
				for (int j = st; j <= stackNum[i]; j++) {
					stack.push(st++);
					result[resultN++]='+';
				}
			if (stack.peek() == stackNum[i]){
				stack.pop();
				result[resultN++]='-';
			}
			else if(stack.peek()>stackNum[i]) no=true;
		}
		
		if(no)
			System.out.println("NO");
		else
			for(int i=0;i<resultN;i++)
				System.out.println(result[i]);

	}

}
