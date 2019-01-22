package test_190122;

import java.util.Scanner;

//입력된 단어에 사용된 각각의 알파벳들의 위치인 인덱스 출력하기
public class B_10809 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		
		if(str.length()<100) {
			int [] alpha = new int[26];
			//배열 초기화
			for(int i=0;i<alpha.length;i++) {
				alpha[i]=-1;
			}
			//탐색 실행
			for(int i=0;i<str.length();i++) {
				//처음 등장하는 경우에만 인덱스 저장
				if(alpha[str.charAt(i)-'a']==-1) {
					alpha[str.charAt(i)-'a']=i;
				}
			}
			//정답 출력
			for(int i=0;i<alpha.length;i++) {
				System.out.print(alpha[i]+" ");
			}
		}
	}
}
