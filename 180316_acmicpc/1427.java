import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		new Main().sort();
	}
	
	public void sort() {
		Scanner sc= new Scanner(System.in);
		int n = sc.nextInt();
		int ci;
		
		ci = cipher(n);
		int num[] = new int[ci];
		
		div(n,num);
		selectionSort(num);
		printItem(num);
	}
	
	public int cipher(int n) {
		int cnt =0;
		while(n/10!=0) {
			n=n/10;
			cnt++;
		}
		return cnt+1;
	}
	
	public void div(int n,int num[]) {
		int index =0;
		while(n/10!=0) {
			num[index++] = n%10;
			n=n/10;
		}
		num[index] = n%10;
		
	}

	public void selectionSort(int[] N) {
		for(int i=0;i<N.length;i++) {
			int max_index = i;
			for(int j=i+1;j<N.length;j++) {
				if(N[max_index]<N[j]) max_index = j;
			}
			int temp = N[max_index];
			N[max_index] = N[i];
			N[i] = temp;
			
		}
	}
	
	public void printItem(int[] N) {
		for(int i=0;i<N.length;i++) {
			System.out.println(N[i]);
		}
	}
	
}
