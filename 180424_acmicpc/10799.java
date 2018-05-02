import java.util.Scanner;
//https://www.acmicpc.net/problem/10799
//Stack을 이용하라 했지만 굳이 스택을 사용하지 않아도 될 것 같았음.
public class Main {
	void SteelStick() {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		int stick =0;		//총 막대의 갯수
		int cur_stick=0;	//현재 위치에 쌓여있는 막대의 수
		
		if(input.charAt(1)!=')'){	//처음에 '()'모양이 나올 경우 레이져이므로 stick 카운트 하지 않음.
			cur_stick++;
			stick++;
		}
		for(int i=1;i<input.length()-1;i++) {
			char cur = input.charAt(i);		//현재 위치의 괄호값
			char prev = input.charAt(i-1);	//이전 위치의 괄호값
			char next = input.charAt(i+1);	//다음 위치의 괄호값
			
			if(cur=='(') {			
				if(next!=')') {		// 현재 '('이면서 다음에 ')'가 나오지 않는다면 막대의 갯수 증가
					cur_stick++;
					stick++;
				}else				// 현재 '('이면서 다음에 ')'가 나오면 레이져이므로 현재위치의 막대 수 두배만큼 막대가 증가
					stick+=cur_stick;
			}else {
				if(prev!='(')		// 현재 ')'이면서 이전에 '('였다면 현재 막대의 갯수를 줄이지 않아도 됨.
					cur_stick--;
			
			}
		}
		System.out.println(stick);
	}
	public static void main(String[] args) {
		new Main().SteelStick();

	}

}
