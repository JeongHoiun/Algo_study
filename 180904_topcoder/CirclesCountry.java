/* TopCoder P.312 CirclesCountry

I/O data

0)
int[] X = {0};
int[] Y = {0};
int[] R = {2};
int x1 = -5;
int y1 = 1;
int x2 = 5;
int y2 = 1;
Returns: 0

1)
int[] X = {0, -6, 6};
int[] Y = {0, 1, 2};
int[] R = {2, 2, 2};
int x1 = -5;
int y1 = 1;
int x2 = 5;
int y2 = 1;
Returns: 2

2)
int[] X = {1, -3, 2, 5, -4, 12, 12};
int[] Y = {1, -1, 2, 5, 5, 1, 1};
int[] R = {8, 1, 2, 1, 1, 1, 2};
int x1 = -5;
int y1 = 1;
int x2 = 12;
int y2 = 1;
Returns: 3

3)
int[] X = {-3, 2, 2, 0, -4, 12, 12, 12};
int[] Y = {-1, 2, 3, 1, 5, 1, 1, 1};
int[] R = {1, 3, 1, 7, 1, 1, 2, 3};
int x1 = 2;
int y1 = 3;
int x2 = 13;
int y2 = 2;
Returns: 5

4)
int[] X = {-107, -38, 140, 148, -198, 172, -179, 148, 176, 153, -56, -187};
int[] Y = {175, -115, 23, -2, -49, -151, -52, 42, 0, 68, 109, -174};
int[] R = {135, 42, 70, 39, 89, 39, 43, 150, 10, 120, 16, 8};
int x1 = 102;
int y1 = 16;
int x2 = 19;
int y2 = -108;
Returns: 3
 */
public class CirclesCountry {

	public int leastBorders(int[] X, int[] Y, int[] R, int x1, int y1, int x2, int y2) {
		int result =0;
		for(int i=0;i<X.length;i++) {
			// i번째 Circle에 대해 포함여부 판단
			boolean pointInCircle1 = (X[i]-x1)*(X[i]-x1)+(Y[i]-y1)*(Y[i]-y1)<R[i]*R[i];
			boolean pointInCircle2 = (X[i]-x2)*(X[i]-x2)+(Y[i]-y2)*(Y[i]-y2)<R[i]*R[i];
			if(pointInCircle1!=pointInCircle2) result ++;
		}
		return result;
	}
	
	public static void main(String[] args) {
		int[] X = {-107, -38, 140, 148, -198, 172, -179, 148, 176, 153, -56, -187};
		int[] Y = {175, -115, 23, -2, -49, -151, -52, 42, 0, 68, 109, -174};
		int[] R = {135, 42, 70, 39, 89, 39, 43, 150, 10, 120, 16, 8};
		int x1 = 102;
		int y1 = 16;
		int x2 = 19;
		int y2 = -108;
		
		System.out.println(new CirclesCountry().leastBorders(X,Y,R,x1,y1,x2,y2));
		
	}

}
