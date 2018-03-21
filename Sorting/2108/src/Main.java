import java.util.Scanner;

public class Main {
	//�ð��ʰ�..
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
	
	public void sort(int num[]) {	//��������
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
	
	public int avg(int sum,int size) {		// �Ҽ��� �ڸ����� �ݿø� ( No STL version ) 
		int avg ; 
		
		if(((float)sum/(float)size)*10%10>=5)  avg = sum/size+1;
		else avg = sum/size;
		
		return avg;
	}
	
	public int counting(int num[]) {
		 int mode1=8001, mode2=8001;  // �ֺ�
         int[] index = new int[8001]; // data�� �ε��� ī����
         int max=Integer.MIN_VALUE;
         
         for(int i=0;i<num.length;i++){
                 index[num[i]+4000]++; // -4000���� 4000������ ��ȣ�� �����Ƿ� index�� ǥ���ϱ����� +4000
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
