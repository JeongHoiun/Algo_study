import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] inorder;
	static int[] postorder;
	static int[] preorder;
	static int[] position;
	static int pre_idx;
	static int n;
	void getPreorder(int in_st, int in_en, int po_st, int po_en) {
		
		if(in_st>in_en||po_st>po_en) return;
		preorder[pre_idx++] = postorder[po_en];
		
		getPreorder(in_st,position[postorder[po_en]-1]-1,po_st,po_st+position[postorder[po_en]-1]-in_st-1);
		getPreorder(position[postorder[po_en]-1]+1,in_en,po_st+position[postorder[po_en]-1]-in_st,po_en-1);
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		inorder = new int[n];
		postorder = new int[n];
		preorder = new int[n];
		position = new int[n];
		
		for(int i=0;i<n;i++) {
			inorder[i] = Integer.parseInt(st.nextToken());
			position[inorder[i]-1] = i;
		}
		st = new StringTokenizer(br.readLine()," ");
		for(int i=0;i<n;i++) {
			postorder[i] = Integer.parseInt(st.nextToken());
		}
		
		pre_idx = 0;
		
		new Main().getPreorder(0,inorder.length-1,0,postorder.length-1);
		
		for(int i=0;i<n;i++) {
			System.out.print(preorder[i]+" ");
		}
		System.out.println();
		
	}

}
