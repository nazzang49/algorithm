package test_181116;

import java.util.Scanner;

//직사각형 벽면에 1X1 크기의 타일을 붙이고 벽면에 대각선 줄을 그었을 때 대각선이 지나는 타일의 개수 구하기
//일차원함수로 변형하여 규칙성 찾기
public class B_2168 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		//지나는 개수
		int cnt = 0;
		//최초 직사각형의 가로길이 기억하기 위한 변수
		int x = 0;
		
		if(1<=n&&n<=1000000000&&1<=m&&m<=1000000000) {
			//주어진 두 수가 배수관계일 경우
			if(n%m==0||m%n==0) {
				if(n>m) {
					cnt=n;
				}else {
					cnt=m;
				}
			}
			//주어진 두 수가 배수관계가 아닐 경우
			//두 수 중 어느 한쪽이 소수가 될 때까지 반복
			else {
				System.out.println("들어온다");
				//계산 편의를 위해 기울이가 1보다 커지도록 변경
				if(n>m) {
					System.out.println("들어온다1");
					int tmp = n;
					n=m;
					m=tmp;
				}
				x=n;
				for(int i=2;i<=m/2;i++) {
					System.out.println("들어온다2");
					if(m%i==0&&n%i==0) {
						m=m/i;
						n=n/i;
						i=1;
					}
				}
				cnt=(m+n-1)*(x/n);
				System.out.println("들어온다3");
			}
			System.out.println(cnt);
		}
	}
}
