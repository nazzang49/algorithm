package test_181203;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

//괄호의 배열이 주어질 때 해당 배열이 안정성 판단 및 안정화 횟수 구하는 프로그램 만들기
public class B_4889 {

	//안정화 횟수
	static int cnt = 0;
	static ArrayList<Integer> answer;
	
	//괄호 배열 안정성 여부 판단 메소드
	public static void VPS(Stack<Character> vps, String str) {
		//첫 문자는 무조건 삽입
		vps.push(str.charAt(0));
		for(int i=1;i<str.length();i++) {
			if(str.charAt(i)=='{') {
				vps.push('{');
			}else if(str.charAt(i)=='}') {
				vps.pop();
			}
		}
		int left = 0;
		int right = 0;
		//스택이 비어 있지 않다면
		if(!vps.isEmpty()) {
			for(int i=0;i<vps.size();i++) {
				if(vps.get(i)=='}') {
					left++;
				}else {
					right++;
				}
			}
		}
		cnt=left*2+right/2;
		answer.add(cnt);
		cnt=0;
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		answer = new ArrayList<>();
		
		while(true) {
			String str = sc.next();
			//하이픈 입력 시 그간의 테스트 케이스별 정답 출력 후 종료
			if(str.charAt(0)=='-') {
				for(int i=0;i<answer.size();i++) {
					System.out.println(answer.get(i));
				}
				System.exit(0);
			}
			//문자열의 길이는 2000이하이며 항상 짝수
			if(str.length()<=2000&&str.length()%2==0) {
				Stack<Character> vps = new Stack<>();
				VPS(vps, str);
			}else {
				System.out.println("입력 범위를 확인하세요.");
				System.exit(0);
			}
		}
	}
}
