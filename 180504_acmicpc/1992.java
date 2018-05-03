import java.util.Scanner;
//https://www.acmicpc.net/problem/1992
//1780 ������ ���
public class Main {
	void QuadTree() {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.nextLine();		//�ٹٲ��� �־���� �ѹ� �� �о����.
		String vidio[] = new String[N];	//���� ����
		for(int i=0;i<N;i++)
			vidio[i] = sc.nextLine();
		Divide(vidio,N);
	}
	
	void Divide(String vidio[], int n) {
		
		char temp = vidio[0].charAt(0);
		boolean isEqual = true;		//���� �κ� ������ ��ü�� ������ Ȯ��
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(temp!=vidio[i].charAt(j)) {
					isEqual = false;
					break;
				}
			}
			if(!isEqual)
				break;
		}
		if(isEqual) {	//���� �� ���� ��� ��ȣ������ ������� �ʰ� ���ڸ� ���
			System.out.print(temp);
		}else {
			System.out.print("(");
			String tmp[] = new String[n/2];
			for(int g=0;g<2;g++) {
				for(int h=0;h<2;h++) {
					for(int i=0;i<n/2;i++) {
						//vidio�� 4�����.
						tmp[i] = vidio[i+n/2*g].substring(n/2*h, n/2*h+n/2);
					}
					Divide(tmp,n/2);
				}
			}
			System.out.print(")");
		}
		
	}
	public static void main(String[] args) {
		new Main().QuadTree();
	}

}
