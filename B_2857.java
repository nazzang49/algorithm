package test_190116;

import java.util.ArrayList;
import java.util.Scanner;

//5개 문자열 계정에 FBI가 포함되어 있는 경찰의 인덱스 오름차순으로 정렬하여 출력하기
public class B_2857 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> ans = new ArrayList<>();
		
		//계정 입력
		for(int i=1;i<=5;i++) {
			String str = sc.next();
			for(int j=0;j<str.length();j++) {
				if(str.charAt(j)=='F'&&str.substring(j, j+3).equals("FBI")) {
					ans.add(i);
					break;
				}
			}
		}
		if(ans.isEmpty()) {
			System.out.println("HE GOT AWAY");
			System.exit(0);
		}
		for(int i=0;i<ans.size();i++) {
			System.out.println(ans.get(i));
		}
	}
}
