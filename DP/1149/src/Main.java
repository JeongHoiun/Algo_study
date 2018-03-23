import java.util.Scanner;

public class Main {
	static int[][] rgb;
	static int[][] rgbc;
	static int num;
	public static int dp(int house,int color){
		
		if(color==0){
			if(rgbc[house][color]!=0)
				return rgbc[house][color];
			if(house==0)
				return rgb[house][color];
			else
				return rgbc[house][color]=rgb[house][0]+min(dp((house-1),1),dp(house-1,2));
		}if(color==1){
			if(rgbc[house][color]!=0)
				return rgbc[house][color];
			if(house==0)
				return rgb[house][color];
			else
				return rgbc[house][color]=rgb[house][1]+min(dp((house-1),0),dp(house-1,2));
		}if(color==2){
			if(rgbc[house][color]!=0)
				return rgbc[house][color];
			if(house==0)
				return rgb[house][color];
			else
				return rgbc[house][color]=rgb[house][2]+min(dp((house-1),1),dp(house-1,0));
		}
		
		return 0; 
	}
	public static int min(int a,int b){
		if (a>b)
			return b;
		else 
			return a;
	}
	public static int min(int a,int b,int c){
		
		if(a<=b&&a<=c)
			return a;
		else if(b<=a&&b<=c)
			return b;
		else
			return c;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		num = sc.nextInt();
		rgb = new int[num][3];
		rgbc= new int[num][3];
		
		for(int i=0;i<num;i++){
			for(int j=0;j<3;j++){
				rgb[i][j]=sc.nextInt();
			}
		}
		System.out.println(min(dp(num-1,0),dp(num-1,1),dp(num-1,2)));
	}

}
