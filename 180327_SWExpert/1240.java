import java.util.Scanner;

public class 1240 {

	String codeNum[] = {"0001101","0011001", "0010011", "0111101","0100011","0110001","0101111",
			"0111011","0110111", "0001011"};
	
	void simpleBinaryCode() {
		Scanner sc = new Scanner(System.in);
		int testcase = sc.nextInt();
		
		for(int t=1;t<=testcase;t++){
			System.out.print("#" + t +" ");
			int row, col;
			row = sc.nextInt();
			col = sc.nextInt();
			
			String code[] = new String[row];
			for(int i=0;i<row;i++) {
				code[i] = sc.next();
			}	findMatchCode(code,row,col);
			
		}
		
	}
	
	void findMatchCode(String code[], int row, int col) {
		int eightcode[] = new int[8];
		int e=0;
		for(int i=0;i<row;i++) {
			for(int j=0;j<col-7;j++) {
				for(int k=0;k<10;k++) {			//숫자에 매칭
					if(codeNum[k].compareTo(code[i].substring(j, j+7))==0) {		//substring : string of char[j] ~ char[j+6]
						if(e==0&&(code[i].charAt(j+(7*8))=='1'||code[i].charAt(j+(7*8)+1)=='1'||code[i].charAt(j+(7*8)+2)=='1')) {
							//맨 첫 숫자가 잘못들어올경우 대비.
							j++;
							break;
						}
						eightcode[e++] = k;
						j=j+6;
						break;
					}
				}
				if(e==8) {		//8개의 연속된 숫자를 찾게되면 
					if(isCryptCode(eightcode)) {		//암호 해독 실시.
						int sum=0;
						for(int l=0;l<8;l++) {
							sum+=eightcode[l];
						}
						System.out.println(sum);
					}else
						System.out.println(0);
					return;
				}
			}
		}
		System.out.println(0);
	}
	
	boolean isCryptCode(int eightCode[]) {		//calculate about code
		int result=0;
		int sumOdd=0;
		for(int i=0;i<7;i+=2) {
			sumOdd+=eightCode[i];
		}
		result+=sumOdd*3;
		for(int i=1;i<8;i+=2)
			result+=eightCode[i];
		
		if(result%10==0) {
			return true;
		}
		else
			return false;
	}
	
	public static void main(String[] args) {
		new 1240().simpleBinaryCode();
	}

}
