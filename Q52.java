package solution;

import java.util.Scanner;

//1900년 1월 1일은 월요일일 때, 1901년 1월 1일부터 현재까지 매월 1일이 일요일인 경우의 수 구하기
public class Q52 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		//현재 시점으로 주어질 입력값
		int year = sc.nextInt();
		int month = sc.nextInt();
		int day = sc.nextInt();
		//매월 1일이 일요일인 경우 빈도
		int cnt = 0;
		//일수를 누적할 변수(1900년 1월 1일을 1로 잡는다)
		int date = 1;
		
		//연도 반복(1900년 ~ 현재)
		for(int i=1900;i<=year;i++) {
			//달 반복(1월 ~ 12월)
			for(int j=1;j<=12;j++) {
				//+31
				if(i==1||i==3||i==5||i==7||i==8||i==10||i==12) {
					if(date%7==0) {
						cnt++;
					}
					date+=31;
				}
				//+30
				else if(i==4||i==6||i==9||i==11){
					if(date%7==0) {
						cnt++;
					}
					date+=30;
				}
				//2월달은 윤년 계산
				else {
					if(date%7==0) {
						cnt++;
					}
					if(i%4==0&&i%400==0) {
						date+=29;
					}else {
						date+=28;
					}
				}
			}
		}
	}
}
