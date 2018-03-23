import java.util.Scanner;

public class Main {
	//틀렸다고 뜸.....
	public void div(int num[],int len) {
		//Merge 소트를 위한 분할
		
		int mid = len/2;
		int[] left_arr = new int[mid];
		int[] right_arr = new int[len-mid];	

		if(len ==1) return;
		
		for(int i=0;i<mid;i++) {
			left_arr[i] = num[i];
		}
		for(int i=0;i<len-mid;i++) {
			right_arr[i] = num[mid+i];
		}   
		
		div(left_arr,mid);
		div(right_arr,len-mid);
		merge(left_arr,right_arr,num);
		
	}
	public void merge(int left[],int right[],int num[]) {
		int left_idx=0;
		int right_idx=0;
		int merge_idx=0;

		while(left.length!=left_idx&&right.length!=right_idx) {
			if(left[left_idx]>right[right_idx]) 
				num[merge_idx++] = left[left_idx++];
			else
				num[merge_idx++] = right[right_idx++];
		}
		while(left.length!=left_idx) {
			num[merge_idx++] = left[left_idx++];
		}
		while(right.length!=right_idx) {
			num[merge_idx++] = right[right_idx++];
		}
	}
	
	public void print(int num[]) {
		for(int i=0; i<num.length;i++) {
			System.out.println(num[i]);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Main sort = new Main();
		
		int number_of = sc.nextInt();
		int[] num = new int[number_of];
		
		for(int i=0;i<number_of;i++) {
			num[i] = sc.nextInt();
		}
		sort.div(num,number_of);
		sort.print(num);
		
	}

}
