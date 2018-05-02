import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// https://www.acmicpc.net/problem/10845
// 설명 생략
public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Queue q = new Queue();
		int n = Integer.parseInt(br.readLine().trim());
		for(int i=0;i<n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine().trim()," ");
			switch(st.nextToken()) {
			case "push":
				q.Push(Integer.parseInt(st.nextToken()));
				break;
			case "pop":
				System.out.println(q.Pop());
				break;
			case "size":
				System.out.println(q.Size());
				break;
			case "empty":
				System.out.println(q.Empty());
				break;
			case "front":
				System.out.println(q.Front());
				break;
			case "back":
				System.out.println(q.back());
				break;
			}
		}
		br.close();
	}
}

class Queue{
	int data[];
	int last;
	int first;
	Queue(){
		data = new int[10000];
		first =0;
		last = 0;
	}
	void Push(int a) {
		data[last++] = a;
	}
	int Pop() {
		if(Empty()==1)
			return -1;
		else
			return data[first++];
	}
	int Size() {
		return last-first;
	}
	int Empty() {
		if(first==last)
			return 1;
		else
			return 0;
	}
	int Front() {
		if(Empty()==1)
			return -1;
		else
			return data[first];
	}
	int back() {
		if(Empty()==1)
			return -1;
		else
			return data[last-1];
	}
}
