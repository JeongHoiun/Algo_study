/* Top Coder p.101 InterestingDigits
 * 
 * I/O data
0)
int base = 10;

Return : {3, 9}

1)
int base = 3;

Return : {2}

2)
int base = 9;

Return : {2,4,8}

3)
int base = 26;

Return : {5, 25}

4)
int base = 30;

Return : {29}

 */

public class InterestingDigits {

	public int[] digits(int base) {
		int[] result = new int[base];
		int idx = 0;
		for(int j=2;j<base;j++) {
			//%base /base %base /base
			boolean isDig=true;
			for (int i=base;i<base*base*base;i++) {
				//약수 && base보다 작음 && 각자리수의 합 = N
				if(i%j==0) {
					int tmp = i;
					int sum = 0;
					while(tmp>0) {
						sum+=tmp%base;
						tmp/=base;
					}
					if(sum % j!=0) {
						isDig=false;
						break;
					}
				}
			}
			if(isDig) {
				result[idx++] = j;
				isDig = true;
			}

		}
		return result;
	}
	public static void main(String[] args) {
		int base = 30;
		int[] arr =new InterestingDigits().digits(base);
		int i=0;
		while(arr[i]!=0) {
			System.out.print(arr[i++]+" ");
		}
		System.out.println();
	}

}
