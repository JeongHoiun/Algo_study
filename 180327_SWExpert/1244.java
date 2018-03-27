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
				arrNum[j++] = num%10;		//자릿수가 낮은것이 arrNum의 앞부분에 들어감.
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
		for(int i=arr.length-1;i>0;i--) {			//정렬을 통해 높은 숫자가 올수 있도록 함
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
		for(int i=0;i<10;i++) {		//중복된 숫자가 있으면 서로 바꿀수 있기 때문에 함수 끝내도 됨
			if(cnt[i]>1)
				return;
		}
		if(exCh%2==1) {			//중복된 숫자가 없으면 맨마지막 숫자만 계쏙 체인지
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
