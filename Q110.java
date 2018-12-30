package solution1;

import java.util.Scanner;

//한국에서 나이를 계산하는 방식인 만 나이, 세는 나이, 연 나이 세가지 모두 출력하기
public class Q110 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		//생년월일
		int year = sc.nextInt();
		int month = sc.nextInt();
		int day = sc.nextInt();
		
		//나이를 계산하고자 하는 현재 시점
		int now_y = sc.nextInt();
		int now_m = sc.nextInt();
		int now_d = sc.nextInt();
		
		//정답을 차례대로 저장할 배열
		int [] answer = new int[3];
		
		int i = 0;
		while(i<3) {
			//만 나이 계산
			if(i==0) {
				if(now_m>=month) {
					if(now_d>=day) {
						answer[i]=now_y-year;		
					}else {
						if(now_y-year-1<=0) {
							answer[i]=0;
						}else {
							answer[i]=now_y-year-1;
						}
					}
				}else {
					if(now_y-year-1<=0) {
						answer[i]=0;
					}else {
						answer[i]=now_y-year-1;
					}
				}
			}
			//일반적인 나이 계산
			else if(i==1) {
				answer[i]=now_y-year+1;
			}
			//법정 나이 계산
			else {
				answer[i]=now_y-year;
			}
			i++;
		}
		
		//정답 출력
		for(int j=0;j<answer.length;j++) {
			System.out.println(answer[j]);
		}
	}
}
