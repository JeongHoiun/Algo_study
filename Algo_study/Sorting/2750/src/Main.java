import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Main sorting = new Main();
		Scanner sc = new Scanner(System.in);
		
		int number_of = sc.nextInt();
		int Num[] = new int[number_of];
		
		for(int i=0;i<number_of;i++) {
			Num[i]=sc.nextInt();
		}
		
		sorting.selectionSort(Num);
		sorting.pringItem(Num);
	}

	public void selectionSort(int[] N) {
		for(int i=0;i<N.length;i++) {
			int min_index = i;
			for(int j=i+1;j<N.length;j++) {
				if(N[min_index]>N[j]) min_index = j;
			}
			int temp = N[min_index];
			N[min_index] = N[i];
			N[i] = temp;
			
		}
	}
	
	public void pringItem(int[] N) {
		for(int i=0;i<N.length;i++) {
			System.out.println(N[i]);
		}
	}
	
}
