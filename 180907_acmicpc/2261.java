import java.io.*;
import java.util.*;

//https://www.acmicpc.net/problem/2261
//Line Sweeping
//�ٸ� ����� �ڵ带 �����ϰ� �ߴµ��� �ð��ʰ��� ��.

public class Main {
	public void solveMinDistance(ArrayList<Point> list,int n) throws IOException {
		/* �⺻������ x�� ���� ���� ������ �� 
		 * ������ �� ���� ���� �� �������� �Ÿ����� �� ��� ������ ���� �ƴϰ� ��
		 * 
		 */
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		TreeSet<Point> candidate = new TreeSet<Point>(new ComparatorSet());
		int ans = 0;
		
		Collections.sort(list);
		
		
		candidate.add(list.get(0));
		candidate.add(list.get(1));
		ans = distance(list.get(0), list.get(1));

		int start = 0;
		for(int i=2;i<n;i++) {
			Point now = list.get(i);
			
			while(start < i) {
				Point pivot = list.get(start);
				int x = pivot.x - now.x;
				
				if(x*x>ans) {
					candidate.remove(pivot);
					start +=1;
				}else {
					break;
				}
			}
			
			int d = (int) Math.sqrt((double) ans)+1;
			Point lower_point = new Point(now.y-d,now.y+d);
			SortedSet<Point> lower = candidate.tailSet(lower_point);
	        Iterator<Point> it_lower = lower.iterator();
	 
	        while (it_lower.hasNext()) {
	            Point p = it_lower.next();
	            d = distance(now, p);
	            if (d < ans) {
	                ans = d;
	            }
	        }
	        candidate.add(list.get(i));
	    }
		bw.write(String.valueOf(ans));
		bw.close();
	
		 
		 
	}
	
	int distance(Point p1, Point p2) {
		return (p2.x - p1.x)*(p2.x-p1.x)+(p2.y-p1.y)*(p2.y-p1.y);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		ArrayList<Point> list = new ArrayList<Point>();
		for(int i=0;i<N;i++) {
			int x, y;
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			x= Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			list.add(new Point(x,y));
		}
		
		new Main().solveMinDistance(list,N);
	}
	
	static class ComparatorDescending implements Comparator<Point> {
	    public int compare(Point p1, Point p2) {
	        if (p1.x < p2.x) {
	            return -1;
	        } else if (p1.x == p2.x) {
	            return 0;
	        } else {
	            return 1;
	        }
	    }
	}

	static class ComparatorSet implements Comparator<Point> {
	    public int compare(Point p1, Point p2) {
	        if (p1.y == p2.y) {
	            if (p1.x < p2.x) {
	                return -1;
	            } else if (p1.x == p2.x) {
	                return 0;
	            } else {
	                return 1;
	            }
	        } else {
	            return p1.y < p2.y ? 1 : -1;
	        }
	    }
	}


	static class Point implements Comparable<Point> {
	    int x;
	    int y;
	 
	    Point(int x, int y) {
	        this.x = x;
	        this.y = y;
	    }
	 
	    public int compareTo(Point p) {
	    	if(x>p.x) {
	    		return 1;
	    	}
	    	if(x==p.x) {
	    		if(y>p.y)
	    			return 1;
	    	}
    		return -1;
	    }
	}



}
