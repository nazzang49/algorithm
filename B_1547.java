package test_190126;

import java.util.Scanner;

//컵 3개, 1번 컵에 공이 들어가있을 때 컵의 위치를 바꾸는 n개의 명령이 주어질 시 최종 공이 들어있는 컵의 위치 구하기
public class B_1547 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		//공이 담긴 컵의 위치
		int gong = 1;
		
		if(n<=50) {
			//컵의 위치 바꾸기
			for(int i=0;i<n;i++) {
				int cup1 = sc.nextInt();
				int cup2 = sc.nextInt();
				if(cup1==gong) {
					gong=cup2;
				}else if(cup2==gong) {
					gong=cup1;
				}
			}
			System.out.println(gong);
		}
	}
}
