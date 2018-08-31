/* Top Coder p.226 CorporationSalary
 * 
 * I/O data
0)
String[] relations = {"N"};
Returns : 1

1)
 String[] relations = {"NNYN", "NNYN", "NNNN", "NYYN"};
 Returns : 5
 
 2)
 String[] relations = { "NNNNNN",
 						"YNYNNY",
 						"YNNNNY",
 						"NNNNNN",
 						"YNYNNN",
 						"YNNYNN"};
 Returns : 17
 
 3)
 String[] relations = { "NYNNYN",
 						"NNNNNN",
 						"NNNNNN",
 						"NNYNNN",
 						"NNNNNN",
 						"NNNYYN"};
Returns : 8
 						
 4)
 String[] relations = { "NNNN",
 						"NNNN",
 						"NNNN",
 						"NNNN"};
 Returns : 4
 */

public class CorporationSalary {
	long[] dp;
	
	public long totalSalary(String[] relations) {
		
		dp = new long[relations.length];
		
		for(int i=0;i<relations.length;i++) {
			dp[i] = Salary(relations, i);
			//하위까지 연봉 계산을 위해 재귀함수로 접근.
		}
		
		int sum = 0;
		for(int i=0;i<dp.length;i++) {
			sum+=dp[i];
		}
		return sum;
	}
	public long Salary(String[] relations, int idx) {
		if(dp[idx] > 0 ) return dp[idx];
		boolean isBase = true;
		
		for(int i=0;i<relations[idx].length();i++) {
			if(relations[idx].charAt(i)=='Y') {
				isBase = false;
				dp[idx]+=Salary(relations, i);
			}
		}

		if(isBase) 
			return dp[idx] = 1;
		return dp[idx];
	}
	
	public static void main(String[] args) {
		 String[] relations = { "NNNN",
					"NNNN",
					"NNNN",
					"NNNN"};
		System.out.println(new CorporationSalary().totalSalary(relations));
	}

}
