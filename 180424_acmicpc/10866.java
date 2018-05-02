import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// https://www.acmicpc.net/problem/10866
// 설명 생략
public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Queue q = new Queue();
		int n = Integer.parseInt(br.readLine().trim());
		for(int i=0;i<n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine().trim()," ");
			switch(st.nextToken()) {
			case "push_front":
				q.Push_front(Integer.parseInt(st.nextToken()));
				break;
			case "push_back":
				q.Push_back(Integer.parseInt(st.nextToken()));
				break;
			case "pop_front":
				System.out.println(q.Pop_front());
				break;
			case "pop_back":
				System.out.println(q.Pop_back());
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

class Node{
	Node prev;
	Node next;
	int data;
	Node(int data){
		this.data = data;
		this.prev = null;
		this.next = null;
	}
}
class Queue{
	Node front;
	Node rear;
	int size;
	Queue(){
		front = null;
		rear = null;
		size = 0;
	}
	void Push_front(int a) {
		Node t = new Node(a);
		Node temp = front;
		if(front!=null) 
			front.prev = t;
		if(Empty()==1)
			rear = t;
		front = t;
		t.next = temp;
		size++;
	}
	void Push_back(int a) {
		Node t = new Node(a);
		Node temp = rear;
		if(rear!=null)
			rear.next = t;
		if(Empty()==1)
			front=t;
		rear = t;
		t.prev = temp;
		size++;
	}
	int Pop_front() {
		if(Empty()==1)
			return -1;
		else {
			Node t = front;
			if(front.next!=null) {
				front = front.next;
				front.prev = null;
			}
			else {
				front = null;
				rear = null;
			}
			size --;
			return t.data;
		}
	}
	int Pop_back() {
		if(Empty()==1)
			return -1;
		else {
			Node t = rear;
			if(rear.prev!=null) {
				rear = rear.prev;
				rear.next=null;
			}
			else {
				front = null;
				rear = null;
			}
			size --;
			return t.data;
		}
	}
	int Size() {
		return size;
	}
	int Empty() {
		if(front==null&&rear==null)
			return 1;
		else
			return 0;
	}
	int Front() {
		return front.data;
	}
	int back() {
		return rear.data;
	}
}
