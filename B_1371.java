package test_190118;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

//여러 개의 문장으로 이루어진 어떤 글이 주어질 때, 그 글에서 가장 많이 사용된 알파벳 출력하기
public class B_1371 {

	public static void main(String[] args) throws IOException{

		//알파벳 소문자, 공백을 포함한 문장을 한줄씩 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//각각의 알파벳별로 사용된 횟수 갱신
		int [] alpha = new int[26];
		ArrayList<Character> ans = new ArrayList<>();
		
		int len = 0;
		//전체 글의 길이가 5000자 이하
		while(len<=5000) {
			String str = br.readLine();
			len+=str.length();
			
			if(str.equals("")) {
				int max = 0;
				for(int i=0;i<alpha.length;i++) {
					//이전 자리에 위치한 알파벳보다 더 많이 사용된 경우
					if(alpha[i]>max) {
						max = alpha[i];
					}
				}
				//가장 많이 등장한 알파벳이 여러개인 경우 모두 저장
				for(int i=0;i<alpha.length;i++) {
					if(alpha[i]==max) {
						ans.add((char)(97+i));
					}
				}
				//정답 출력
				for(int i=0;i<ans.size();i++) {
					System.out.println(ans.get(i));
				}
				System.exit(0);
			}
			
			for(int i=0;i<str.length();i++) {
				//공백이 아니라면(=알파벳이라면)
				if(str.charAt(i)!=' ') {
					alpha[str.charAt(i)-'a']++;
				}
			}
		}
	}
}
