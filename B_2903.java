package test_181109;

import java.util.Scanner;

//중앙 이동 알고리즘에 의해 새로운 포인트를 생성할 때, 중복을 배제하고 새로 생긴 점의 개수 구하기
//수열의 규칙을 찾는 문제
public class B_2903 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		//특정 단계
		int n = sc.nextInt();
		int [] point = new int[n+1];
		
		if(1<=n&&n<=15) {
			//특정 단계에서의 모든 포인트 개수 = 새로 생긴 포인트 개수+이전 단계의 포인트 개수
			point[0]=4;
			
			for(int i=1;i<=n;i++) {
				point[i]=(int)Math.pow(Math.pow(2, i)+1,2);
			}
			System.out.println(point[n]);
		}
		
	}

}
