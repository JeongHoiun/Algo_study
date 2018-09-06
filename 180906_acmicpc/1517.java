import java.util.Scanner;

public class Main {
	static int arr[];
	static int sortedArr[];
	
	long countBubbleSortSwap(int left, int right) {
		if (left == right) return 0;
	    int mid = (left + right) / 2;
	    
	    long cnt = countBubbleSortSwap(left, mid) + countBubbleSortSwap(mid + 1, right);

	    int i = left;
	    int j = mid + 1;
	    int k = 0;

	    while (i <= mid || j <= right)
	    {
	        if (i <= mid && (j > right || arr[i] <= arr[j]))
	        {
	            sortedArr[k++] = arr[i++];
	        }
	        else
	        {
	            // 왼쪽 배열의 남아있는 원소들의 개수
	            cnt += (long)(mid - i + 1);
	            sortedArr[k++] = arr[j++];
	        }
	    }

	    for (int a = left; a <= right; a++) {
	        arr[a] = sortedArr[a - left];
	    }
		return cnt;
	}
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N  = sc.nextInt();
		arr = new int[N];
		sortedArr = new int [N];
		for(int i=0;i<N;i++) {
			arr[i] = sc.nextInt();
		}
		
		System.out.println(new Main().countBubbleSortSwap(0,N-1));
	}

}
