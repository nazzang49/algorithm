package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

//문자열, 밀어낼 거리가 주어질 때 결과로 출력되는 시저 암호 구하기
public class Q9 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<String> answer = new ArrayList<>();
		
		while(true) {
			//밀어내는 거리
			int n = Integer.parseInt(br.readLine());
			String str = br.readLine();
			//quit 입력 시 케이스별 정답 출력 후 종료
			if(str.equals("quit")) {
				for(int i=0;i<answer.size();i++) {
					System.out.println(answer.get(i));
					System.exit(0);
				}
			}
			String tmp = "";
			for(int i=0;i<str.length();i++) {
				//공백이면 그대로 공백 유지
				if(str.charAt(i)==' ') {
					tmp+=' ';
				}
				//공백이 아닌 문자면
				else {
					tmp+=(char)(str.charAt(i)+n);
				}
			}
			answer.add(tmp);
		}
	}
}
