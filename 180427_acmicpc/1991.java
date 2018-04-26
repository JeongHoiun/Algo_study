import java.util.Scanner;
// https://www.acmicpc.net/problem/1991
public class Main {
	void TreeTraversal() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Tree t = new Tree();
		for(int i=0;i<n;i++) {
			t.add(sc.next().charAt(0),sc.next().charAt(0),sc.next().charAt(0));
		}
		t.preorder(t.root);
		System.out.println();
		t.inorder(t.root);
		System.out.println();
		t.postorder(t.root);
		System.out.println();
	}
	public static void main(String[] args) {
		new Main().TreeTraversal();
	}

}

class Node{
	char data;
	Node left, right;
	public Node(char data) {this.data = data;}
}

class Tree{
	Node root;
	public void add(char data, char leftdata, char rightdata) {
		//첫 노드 추가 부분
		if(root==null) {
			if(data!='.') root = new Node(data);
			if(leftdata!='.') root.left = new Node(leftdata);
			if(rightdata!='.') root.right = new Node(rightdata);
		}
		else search(root, data, leftdata, rightdata);
	
	}
	public void search(Node root, char data, char leftdata, char rightdata) {
		//이미 루트가 존재할경우 찾은 후 노드 추가.
		if(root==null) return;
		else if(root.data == data) {
			if(leftdata!='.') root.left = new Node(leftdata);
			if(rightdata!='.') root.right = new Node(rightdata);
		}
		else {
			search(root.left, data, leftdata, rightdata);
			search(root.right, data, leftdata, rightdata);
		}
	}
	public void preorder(Node root) {
		//전위
		System.out.print(root.data);
		if(root.left!=null) preorder(root.left);
		if(root.right!=null) preorder(root.right);
	}
	public void inorder(Node root) {
		//중위
		if(root.left!=null) inorder(root.left);
		System.out.print(root.data);
		if(root.right!=null) inorder(root.right);
	}
	public void postorder(Node root) {
		//후위
		if(root.left!=null) postorder(root.left);
		if(root.right!=null) postorder(root.right);
		System.out.print(root.data);
	}
}
