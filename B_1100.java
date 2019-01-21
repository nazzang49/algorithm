package test_190121;

import java.util.Scanner;

//흰색과 검정색이 번갈아가며 칠해진 8x8 크기의 체스판과 그 위에 있는 말의 위치가 주어질 때, 흰색 위에 있는 말이 몇개인지 출력하기
public class B_1100 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int cnt = 0;
		
		int k = 0;
		while(k<8) {
			//짝수번째 줄은 짝수번째 칸 탐색
			//홀수번째 줄은 홀수번째 칸 탐색
			String str = sc.next();
			if(k%2==0) {
				for(int i=0;i<str.length();i++) {
					if(i%2==0&&str.charAt(i)=='F') {
						cnt++;
					}
				}
			}else {
				for(int i=0;i<str.length();i++) {
					if(i%2==1&&str.charAt(i)=='F') {
						cnt++;
					}
				}
			}
			k++;
		}
		System.out.println(cnt);
	}
}
