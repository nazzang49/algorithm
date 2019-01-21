package test_190121;

import java.util.Scanner;

//어떠한 음악곡의 음계가 문자열로 주어질 때, 해당 음계가 가단조인지 다장조인지 판별하는 프로그램 작성하기
public class B_5211 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		
		if(5<=str.length()&&str.length()<100) {
			int [] alpha = new int[7];
			//'|'마디선을 기준으로 음계 나눔(그냥 |을 적으면 기호로 인식하지 못함)
			//(다른 방법) StringTokenzier st = new StringTokenizer(str,"|");
			//StringTokenizer는 문자열 사이에 있는 공백 포함 X
			//split메소드는 문자열 사이에 있는 공백 포함 O
			String [] music = str.split("\\|");
			for(int i=0;i<music.length;i++) {
				//사용된 알파벳의 갯수 저장
				alpha[music[i].charAt(0)-'A']++;
			}
			int ga = 0;
			int da = 0;
			for(int i=0;i<alpha.length;i++) {
				if(i==0||i==3||i==4) {
					ga+=alpha[i];
				}else {
					da+=alpha[i];
				}
			}
			if(ga>da) {
				System.out.println("A-minor");
			}else if(ga<da) {
				System.out.println("C-major");
			}
			//중심음의 갯수가 같을 경우 제일 마지막 마디의 음계 비교
			else {
				char tmp = music[music.length-1].charAt(0);
				if(tmp=='C'||tmp=='F'||tmp=='G') {
					System.out.println("C-major");
				}else {
					System.out.println("A-minor");
				}
			}
		}
	}
}
