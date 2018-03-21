import java.util.Scanner;

public class Main {
	//시간초과..
	public void statistics() {
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		int sum =0 , avg, mid,many, scope;
		int[] num = new int[size];
		
		for(int i=0;i<size;i++) {
			num[i] = sc.nextInt();
			sum+=num[i];
		}
		
		sort(num);
		
		avg = avg(sum,size);
		mid = num[size/2];
		many = counting(num);
		
		scope = num[size-1] - num[0];
		
		System.out.println(avg+"\n"+mid+"\n"+many+"\n"+scope);
	}
	
	public void sort(int num[]) {	//선택정렬
		for(int i=0;i<num.length;i++) {
			int min_index = i;
			for(int j=i+1;j<num.length;j++) {
				if(num[min_index]>num[j]) min_index = j;
			}
			int temp = num[min_index];
			num[min_index] = num[i];
			num[i] = temp;
			
		}
	}
	
	public int avg(int sum,int size) {		// 소수점 자리에서 반올림 ( No STL version ) 
		int avg ; 
		
		if(((float)sum/(float)size)*10%10>=5)  avg = sum/size+1;
		else avg = sum/size;
		
		return avg;
	}
	
	public int counting(int num[]) {
		 int mode1=8001, mode2=8001;  // 최빈값
         int[] index = new int[8001]; // data의 인덱스 카운터
         int max=Integer.MIN_VALUE;
         
         for(int i=0;i<num.length;i++){
                 index[num[i]+4000]++; // -4000부터 4000까지의 번호가 있으므로 index로 표현하기위해 +4000
         }
         for(int i=0;i<index.length;i++){
                 if(max<index[i]) {
                	 max = index[i];
                	 mode1=i;
                	 mode2 = 8001;
                 }else if(max==index[i]) {
                	 if(mode2==8001) mode2=i;
                 }
         }
         if(mode2==8001)
        	 return mode1-4000;
         else
        	 return mode2-4000;
	}
	
	public static void main(String[] args) {
		new Main().statistics();

	}

}
