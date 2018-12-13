package solution;

import java.util.Scanner;

//입력된 문자열의 부분 문자열 중 가장 긴 팰린드롬(앞뒤를 바꾸어도 같은 문자열이 되는) 길이 구하기
public class Q44 {

	static String str;
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		str = sc.next();
		
		//어떤 문자를 기준으로 양쪽으로 index가 이동하면서 두 개의 값 서로 비교
		if(1<=str.length()&&str.length()<=2500) {
			//각 케이스별 최대값 저장
			int max = Integer.MIN_VALUE;
			for(int i=0;i<str.length();i++) {
				//인덱스 위치
				int idx = 1;
				//각 케이스별 팰린드롬 길이
				int cnt = 1;				
				while(true) {
					//비교하고자 하는 인덱스가 문자열 범위 벗어나는 경우
					if(i-idx<0||i+idx>=str.length()) {
						break;
					}
					//팰린드롬이 되는 경우
					if(str.charAt(i-idx)==str.charAt(i+idx)) {
						//오른쪽 1, 왼쪽 1 도합 2 길이 증가
						cnt+=2;
						idx++;
					}else {
						break;
					}
				}
				if(cnt>=max) {
					max=cnt;
				}
			}
			System.out.println(max);
		}
	}
}
