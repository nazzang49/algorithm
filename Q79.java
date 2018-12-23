package solution;

import java.util.Scanner;

//2019년 1월 1일(화요일)부터 100000년까지 누적되는 13일의 금요일 수 구하기
//(날짜 선정 기준) 7로 나누었을 때, 나머지가 1이면 화요일 -> 즉, 금요일은 나머지가 4
public class Q79 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		//입력할 연도
		int n = sc.nextInt();
		int cnt = 0;
		
		if(2019<=n&&n<=100000) {
			int date = 13;
			
			//연도 반복
			for(int i=2019;i<=n;i++) {
				//개월 수 반복(매월 13일은 단 한번)
				for(int j=1;j<=12;j++) {
					if(j==1||j==3||j==5||j==7||j==8||j==10||j==12) {
						//매월 13일이 금요일인지 확인
						if(date%7==4) {
							cnt++;
						}
						date+=31;
					}else if(j==4||j==6||j==9||j==11) {
						//매월 13일이 금요일인지 확인
						if(date%7==4) {
							cnt++;
						}
						date+=30;
					}
					//2월달의 경우, 윤년 확인
					else {
						//매월 13일이 금요일인지 확인
						if(date%7==4) {
							cnt++;
						}
						//400이나 4로 나누어지고, 100의 배수가 아닌 연도의 경우 윤년
						if(i%400==0||(i%4==0&&i%100!=0)) {
							date+=29;
						}else {
							date+=28;
						}
					}
				}
			}
			System.out.println(cnt);
		}
	}
}
