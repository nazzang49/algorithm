package test_181119;

import java.util.Scanner;

//현재 좌표에서 특정 지점까지 이동하는 두 가지 방법이 있을 때, 최소 시간 구하기
public class B_1459 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int y = sc.nextInt();
		int w = sc.nextInt();
		int s = sc.nextInt();
		//직선 경로 시간
		int tmp1 = 0;
		//대각선 경로 시간
		int tmp2 = 0;
		
		if(0<=x&&x<=1000000000&&0<=y&&y<=1000000000&&1<=w&&w<=10000
				&&1<=s&&s<=10000) {
			tmp1 = (x+y)*w;
			
			if(x>y) {
				int tmp = x;
				x=y;
				y=tmp;
			}
			
			for(int i=1;i<=x;i++) {
				//y의 좌표가 정수일 경우(=대각선 하나가 완성되면 시간 누적)
				if((y/x)*i%2==0||(y/x)*i%2==1) {
					tmp2 += s;
				}
			}
			System.out.println(tmp2);
			//삼항연산자
			System.out.println(tmp1>=tmp2?tmp2:tmp1);
		}
	}
}
