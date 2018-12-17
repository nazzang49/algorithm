package solution;

import java.util.Scanner;

//문장의 단어별 짝수, 홀수 인덱스를 판별하여 소문자 및 대문자 변환하기
public class Q49 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		
		//공백을 기준으로 단어 구분
		String [] words = str.split(" ");
		String [] answer = new String[words.length];
		for(int i=0;i<words.length;i++) {
			String tmp = "";
			for(int j=0;j<words[i].length();j++) {
				if(j%2==0) {
					char a = (char)(words[i].charAt(j)-32);
					tmp+=a;
				}else{
					tmp+=words[i].charAt(j);
				}
			}
			answer[i]=tmp;
			System.out.println(answer[i]);
		}
	}
}
