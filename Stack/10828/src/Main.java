import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	static ArrayList<Integer> a = new ArrayList<Integer>();
	static void Push(int x)
	{
		a.add(x);
	}
	static void Pop()
	{
		if(a.isEmpty())
		{
			System.out.println("-1");
			return;
		}
		System.out.println(a.get(a.size()-1));
		a.remove(a.size()-1);
	}
	static void Size()
	{
		System.out.println(a.size());
	}
	static void Empty()
	{
		if(a.isEmpty())
			System.out.println("1");
		else
			System.out.println("0");
	}
	static void top()
	{
		if(a.isEmpty()){
			System.out.println("-1");
			return;
		}
		System.out.println(a.get(a.size()-1));
	}
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		String comm;
		int ele;
		int testcase;
		
		testcase = sc.nextInt();
		while(testcase--!=0)
		{
			comm = sc.next();
			switch(comm)
			{
			case "push":
				ele = sc.nextInt();
				Push(ele);
				break;
			case "pop":
				Pop();
				break;
			case "size":
				Size();
				break;
			case "empty":
				Empty();
				break;
			case "top":
				top();
			}
		}
		
	}
}