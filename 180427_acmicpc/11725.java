import java.util.Scanner;

public class Main {
	void FindRootOfTree() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		Tree tree = new Tree();
		for(int i=0;i<n-1;i++) {
			int a= sc.nextInt();
			int b = sc.nextInt();
			tree.searchNadd(tree.root,a, b);
		}
		for(int i=2;i<=n;i++) {
			tree.findroot(tree.root, i, 1);
		}
	}
	public static void main(String[] args) {
		new Main().FindRootOfTree();
	}

}

class Node{
	int data;
	Node left, right;
	public Node(int data) {this.data = data;}
}

class Tree{
	Node root;
	public Tree() {root = new Node(1);}		//Tree의 Root는 항상 1
	public void findroot(Node root, int data, int prevdata) {
		if(root.data==data) System.out.println(prevdata);
		else {
			if(root.left!=null) findroot(root.left,data,root.data);
			if(root.right!=null)findroot(root.right,data,root.data);
		}
	}
	public void searchNadd(Node root, int parent, int data) {
		if(root !=null) {
			if(root.data == parent) {
				if(root.left==null) root.left = new Node(data);
				else root.right = new Node(data);
			}
			else {
				searchNadd(root.left, parent, data);
				searchNadd(root.right, parent, data);
			}
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