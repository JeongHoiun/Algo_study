import java.util.Scanner;
//https://www.acmicpc.net/problem/10799
//Stack�� �̿��϶� ������ ���� ������ ������� �ʾƵ� �� �� ������.
public class Main {
	void SteelStick() {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		int stick =0;		//�� ������ ����
		int cur_stick=0;	//���� ��ġ�� �׿��ִ� ������ ��
		
		if(input.charAt(1)!=')'){	//ó���� '()'����� ���� ��� �������̹Ƿ� stick ī��Ʈ ���� ����.
			cur_stick++;
			stick++;
		}
		for(int i=1;i<input.length()-1;i++) {
			char cur = input.charAt(i);		//���� ��ġ�� ��ȣ��
			char prev = input.charAt(i-1);	//���� ��ġ�� ��ȣ��
			char next = input.charAt(i+1);	//���� ��ġ�� ��ȣ��
			
			if(cur=='(') {			
				if(next!=')') {		// ���� '('�̸鼭 ������ ')'�� ������ �ʴ´ٸ� ������ ���� ����
					cur_stick++;
					stick++;
				}else				// ���� '('�̸鼭 ������ ')'�� ������ �������̹Ƿ� ������ġ�� ���� �� �ι踸ŭ ���밡 ����
					stick+=cur_stick;
			}else {
				if(prev!='(')		// ���� ')'�̸鼭 ������ '('���ٸ� ���� ������ ������ ������ �ʾƵ� ��.
					cur_stick--;
			
			}
		}
		System.out.println(stick);
	}
	public static void main(String[] args) {
		new Main().SteelStick();

	}

}
