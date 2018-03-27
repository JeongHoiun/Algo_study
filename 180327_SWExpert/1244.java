import java.util.Scanner;

public class 1244{
	void maxPrize(){
		Scanner sc = new Scanner(System.in);
		int testcase = sc.nextInt();
		for(int t=1; t<=testcase; t++) {
			System.out.print("#"+t+" ");
			int num = sc.nextInt(); int tempnum = num;
			int exchangeChance = sc.nextInt();
			int arrNum[];
			int carry=0;
			while(tempnum!=0) {
				carry++;
				tempnum/=10;
			}
			arrNum = new int[carry];
			int j=0;
			while(num!=0) {
				arrNum[j++] = num%10;		//�ڸ����� �������� arrNum�� �պκп� ��.
				num/=10;
			}
			Exchange(arrNum,exchangeChance);
			int sum=0; int ind=1;
			for(int i=0;i<arrNum.length;i++) {
				sum+=arrNum[i]*ind;
				ind*=10;
			}
			/*for(int i=carry-1;i>=0;i--) {
				System.out.print(arrNum[i]);
			}*/
			System.out.println(sum);
		}
	}
	
	void Exchange(int arr[], int exCh) {
		int index=0;
		int max ;
		int maxi=-1;
		int cnt[] = new int [10];
		for(int i=arr.length-1;i>0;i--) {			//������ ���� ���� ���ڰ� �ü� �ֵ��� ��
			max=-1;
			cnt[arr[i]]++;
			for(int j=i;j>=0;j--) {
				if(arr[j] >= max) {
					max = arr[j];
					maxi = j;
				}
			}
			if(i!=maxi) {
				Swap(arr,i,maxi);
				exCh--;
			}
			if(exCh==0)
				return;
		}
		for(int i=0;i<10;i++) {		//�ߺ��� ���ڰ� ������ ���� �ٲܼ� �ֱ� ������ �Լ� ������ ��
			if(cnt[i]>1)
				return;
		}
		if(exCh%2==1) {			//�ߺ��� ���ڰ� ������ �Ǹ����� ���ڸ� ��� ü����
			Swap(arr,0,1);
		}
	}
	void Swap(int arr[],int i, int j) {
		int t = arr[i];
		arr[i] = arr[j];
		arr[j] = t;
	}
	
	public static void main(String[] args) {
		new 1244().maxPrize();
	}
}
