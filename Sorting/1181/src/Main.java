import java.util.Scanner;

public class Main {
	//틀렸습니다.
	public void wordSort() {
		Scanner sc = new Scanner(System.in);
		int numOfWord = sc.nextInt();
		String[] word = new String[numOfWord];
		
		for(int i=0;i<numOfWord;i++) {
			word[i] = sc.next();
		}
		wordSort(word);
		selectionSort(word);
		printWord(word);
	}
	public void wordSort(String[] word) {
		//사전순으로 정렬
		for(int i=0;i<word.length;i++) {
			int min_index = i;
			for(int j=i+1;j<word.length;j++) {
				if(word[min_index].compareTo(word[j])>0) min_index = j;
			}
			String temp = word[min_index];
			word[min_index] = word[i];
			word[i] = temp;
			
		}
	}
	public void selectionSort(String[] word) {
		//길이순으로 정렬
		for(int i=0;i<word.length;i++) {
			int min_index = i;
			for(int j=i+1;j<word.length;j++) {
				if(word[min_index].length()>word[j].length()) min_index = j;
			}
			String temp = word[min_index];
			word[min_index] = word[i];
			word[i] = temp;
			
		}
	}
	
	public void printWord(String[] word) {
		System.out.println(word[0]);
		for(int i=1;i<word.length;i++) {
			if(!word[i].equals(word[i-1]))	System.out.println(word[i]);
		}
	}
	
	public static void main(String[] args) {
		new Main().wordSort();

	}
}
