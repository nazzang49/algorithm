package test_190114;

import java.util.Scanner;

//남극에서 단어가 형성되는 규칙이 있을 때, 입력으로 주어지는 단어 중 학생들이 읽을 수 있는 단어의 개수 최대값 출력하기
public class B_1062 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		//조건 만족하는 단어의 갯수
		int cnt = 0;
		
		if(1<=n&&n<=50&&0<=k&&k<=26) {
			if(k<5) {
				System.out.println("단어를 읽을 수 없습니다.");
				System.exit(0);
			}
			int j = 0;
			while(j<n) {
				//입력으로 주어지는 문자열
				String str = sc.next();
				//알파벳의 등장여부 저장할 배열
				int [] alpha = new int[26];
				int tmp = k;
				for(int i=0;i<str.length();i++) {
					//새로 등장한 문자열이면
					if(alpha[str.charAt(i)-'a']==0) {
						alpha[str.charAt(i)-'a']++;
						tmp--;
					}
				}
				//읽을 수 있는 경우
				if(tmp>=0) {
					cnt++;
				}
				j++;
			}
			System.out.println(cnt);
		}
	}
}
