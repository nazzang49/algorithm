package solution;

import java.util.ArrayList;
import java.util.Scanner;

//특정 문자열이 주어질 때, 접두어와 접미어를 동시에 만족하는 부분 문자열의 길이를 차례대로 출력하기
public class Q73 {

	//정답이 되는 문자열의 길이 차례대로 저장할 정답 배열
	static ArrayList<Integer> answer = new ArrayList<>();
	
	//접두어 = 접미어 판별할 메소드
	public static void result(String str) {
		String front = "";
		String rear = "";
		for(int i=0;i<str.length();i++) {
			front+=str.charAt(i);
			rear=str.charAt(str.length()-1-i)+rear;
			if(front.equals(rear)) {
				answer.add(i+1);
			}
		}
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		
		if(1<=str.length()&&str.length()<=400000) {
			result(str);
			for(int i=0;i<answer.size();i++) {
				System.out.print(answer.get(i)+" ");
			}
		}
	}
}
