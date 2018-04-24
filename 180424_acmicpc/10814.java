//https://www.acmicpc.net/problem/10814
import java.util.Scanner;
public class Main {
	public void div(String num[][],int len) {

		int mid = len/2;
		String[][] left_arr = new String[mid][3];
		String[][] right_arr = new String[len-mid][3];

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
	/*
	 * 차례대로 나눈 뒤 오름차순으로 하나씩 병합.
	 */
	public void merge(String left[][],String right[][],String num[][]) {
		int left_idx=0;
		int right_idx=0;
		int merge_idx=0;

		while(left.length!=left_idx&&right.length!=right_idx) {
			if(Integer.parseInt(left[left_idx][0])<Integer.parseInt(right[right_idx][0])) {
				num[merge_idx++] = left[left_idx++];
			}else if(left[left_idx][0].compareTo(right[right_idx][0])==0) {
				num[merge_idx++] = 
						Integer.parseInt(left[left_idx][1])<
						Integer.parseInt(right[right_idx][1])?
								left[left_idx++]:right[right_idx++];
			}else {
				num[merge_idx++] = right[right_idx++];
			}
		}
		while(left.length!=left_idx) {
			num[merge_idx++] = left[left_idx++];
		}
		while(right.length!=right_idx) {
			num[merge_idx++] = right[right_idx++];
		}
	}
	
	public void print(String num[][]) {
		for(int i=0; i<num.length;i++) {
			System.out.println(num[i][0]+ " " + num[i][2]);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Main sort = new Main();
		
		int number_of = sc.nextInt();
		if(number_of == 0 )
			return;
		String[][] num = new String[number_of][3];	//x:0, y:1
		int index=0;
		for(int i=0;i<number_of;i++) {
			// 정렬 방식을 바꿔서 해도 되지만 귀찮아서 가입한 순서대로 번호 부여.
			num[i][0] = sc.next();
			num[i][1] = String.valueOf(index++);
			num[i][2] = sc.next();
		}
		sort.div(num,number_of);
		sort.print(num);
		
	}

}
