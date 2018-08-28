/* Top Coder p.173 NumberMagicEasy 
 * 
 * I/O data
0)
String answer = "YNYY";
Returns : 5

1) 
String answer = "YNNN";
Returns : 8

2)
String answer = "NNNN";
Returns : 16

3)
String answer = "YYYY";
Returns : 1

4)
String answer = "NYNY";
Returns : 11

 */
public class NumberMagicEasy {
	public int theNumber(String answer) {
		int[][] card = {{1,2,3,4,5,6,7,8},{1,2,3,4,9,10,11,12},
				{1,2,5,6,9,10,13,14},{1,3,5,7,9,11,13,15}};
		
		
		int[] number = new int[17];
		
		for(int i=0;i<4;i++) {
			if(answer.charAt(i)=='N') {
				for(int j=0;j<8;j++) {
					number[card[i][j]]--;
				}
			}else {
				for(int j=0;j<8;j++) {
					number[card[i][j]]++;
				}
			}
		}
		int max = -1;
		int result=1;
		for(int i=1;i<17;i++) {
			if(max<number[i]) {
				result = i;
				max = number[i];
			}
		}
		return result;
	}
	public static void main(String[] args) {
		String answer = "NYNY";
		
		System.out.println(new NumberMagicEasy().theNumber(answer));

	}

}
