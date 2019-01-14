package test_190114;

import java.util.ArrayList;
import java.util.Scanner;

//입력으로 주어지는 문자열과 폭발 문자열이 주어질 때, 모든 폭발이 끝나고 남아있는 문자열 출력하기
public class B_9935 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		String exp = sc.next();
		ArrayList<Character> list = new ArrayList<>();
		
		if(1<=str.length()&&str.length()<=1000000&&1<=exp.length()&&exp.length()<=36) {
			//가변배열에 입력 문자열 저장
			for(int i=0;i<str.length();i++) {
				list.add(str.charAt(i));
			}
			while(true) {
				int cnt = 0;
				//탐색 실행
				for(int i=0;i<list.size()-1;i++) {
					//문자열의 특정 문자와 폭발 문자열의 첫글자가 같다면
					if(list.get(i)==exp.charAt(0)) {
						boolean flag = false;
						for(int j=1;j<exp.length();j++) {
							//한 글자라도 다르면 폭발 일어나지 않음
							if(list.get(i+j)!=exp.charAt(j)) {
								flag=true;
								break;
							}
						}
						//폭발하는 경우
						if(!flag) {
							cnt++;
							for(int j=0;j<exp.length();j++) {
								list.remove(i);
							}
						}
					}
				}
				//폭발하는 문자가 하나도 없으면(반복 종료)
				if(cnt==0) {
					break;
				}
			}
			for(int i=0;i<list.size();i++) {
				System.out.print(list.get(i));
			}
		}
	}
}
