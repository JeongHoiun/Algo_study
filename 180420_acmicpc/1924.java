//1924
import java.util.Scanner;


class Main{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int month,day;
		month = sc.nextInt();
		day = sc.nextInt();
		String week[] = {"SUN","MON","TUE","WED","THU","FRI","SAT"}; 
		int days[] = {31,28,31,30,31,30,31,31,30,31,30,31};
		int count = 0;
		for(int i=0;i<month-1;i++) {
			count+= days[i];
		}
		count += day;
		
		System.out.println(week[count%7]);
		
		
	}
}