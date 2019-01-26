package test_190126;

import java.util.Scanner;

//4개의 정차역이 있는 기차 노선이 있을 때, 사람이 내리고(1) 타는(2) 행위가 반복될 시 가장 많은 인원이 기차 안에 머무는 정차역이 어딘지 출력하기
public class B_2455 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int max = Integer.MIN_VALUE;
		int total = 0;
		
		//정차역별 내리는or타는 인원 수 입력
		for(int i=0;i<4;i++) {
			total-=sc.nextInt();
			total+=sc.nextInt();
			if(max<total) {
				max=total;
			}
		}
		System.out.println(max);
	}
}
