package test_190327;

import java.util.Scanner;

//64cm 길이의 막대를 가지고 있을 때, 해당 막대를 임의로 잘라 xcm의 막대를 만들고자 한다면 자르는 횟수 구하기
public class B_1094 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		if(n<=64) {
			int cnt = 0;
			String str = Integer.toBinaryString(n);
			for(int i=0;i<str.length();i++) {
				if(str.charAt(i)=='1') {
					cnt++;
				}
			}
			System.out.println(cnt);
		}
	}
}
