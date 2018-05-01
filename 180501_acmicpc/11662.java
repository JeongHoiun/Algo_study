import java.util.Scanner;
//https://www.acmicpc.net/problem/11662
//오차를 어떻게 줄일지 모르겠음
public class Main {
	void MinhoNKangho() {
		Scanner sc= new Scanner(System.in);
		double ax,ay,bx,by,cx,cy,dx,dy;
		ax = sc.nextDouble();
		ay = sc.nextDouble();
		bx = sc.nextDouble();
		by = sc.nextDouble();
		cx = sc.nextDouble();
		cy = sc.nextDouble();
		dx = sc.nextDouble();
		dy = sc.nextDouble();
		
		
		double min = Math.abs(Math.sqrt((cx-ax)*(cx-ax)+(cy-ay)*(cy-ay)));
		double mino_leftx = ax;
		double mino_lefty = ay;
		double mino_rightx = bx;
		double mino_righty = by;
		double kang_leftx = cx;
		double kang_lefty = cy;
		double kang_rightx = dx;
		double kang_righty = dy;
		while(Math.abs(mino_righty-mino_lefty)>0.0000001) {
			double mino_midx = (mino_leftx+mino_rightx)/2.0f;
			double mino_midy = (mino_lefty+mino_righty)/2.0f;
			double kang_midx = (kang_leftx+kang_rightx)/2.0f;
			double kang_midy = (kang_lefty+kang_righty)/2.0f;
			
			double mid_result = Math.abs(Math.sqrt((kang_midx-mino_midx)*(kang_midx-mino_midx)
					+((kang_midy-mino_midy)*((kang_midy-mino_midy)))));
			
			
			if(min>mid_result) {
				 mino_leftx = mino_midx;
				 mino_lefty = mino_midy;
				 kang_leftx = kang_midx;
				 kang_lefty = kang_midy;
				 min = mid_result;
			}else {
				mino_rightx = mino_midx;
				mino_righty = mino_midy;
				kang_rightx = kang_midx;
				kang_righty = kang_midy;
			}
				
		}
		System.out.println(Double.parseDouble(String.format("%.10f",min)));
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main().MinhoNKangho();
	}

}
