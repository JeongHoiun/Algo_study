/* Top Coder p.93 Cryptography
 * 
 * I/O data
0) 
int[] numbers = {1, 2, 3};

Returns : 12

1)
int[] numbers = {1, 3, 2, 1, 1, 3};

Returns : 36

2)
int[] numbers = {1000, 999, 998, 997, 996, 995};

Returns : 986074810223904000

3)
int[] numbers = {1, 1, 1, 1};

Retruns : 2

 */
public class Cryptography {
	public long encrypt(int[] numbers) {
		long max = 0;
		for(int i=0;i<numbers.length;i++) {
			long mul=1;
			for(int j=0;j<numbers.length;j++) {
				if(i==j)
					mul*=(numbers[j]+1);
				else
					mul*=numbers[j];
			}
			max = max<mul?mul:max;
		}
		return max;
	}
	public static void main(String[] args) {
		int[] numbers = {1, 1, 1, 1};

		System.out.println(new Cryptography().encrypt(numbers));
	}

}
