package test_181103;

import java.util.Scanner;

//일반적인 원의 넓이와 택시 기하학에서의 원의 넓이를 함께 구하는 소스
public class B_3053 {
	
	//정적, 상수, 형태 순으로 변수 선언
	static final double pi = 3.14159265359;
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int r = sc.nextInt();
		
		if(1<=r&&r<=10000) {
			//일반적인 원의 넓이
			double general = r*r*pi;
			//택시 기하학 원의 넓이(=마름모 형태)
			double taxi = r*r*2;
			
			System.out.printf("%.6f",general);
			System.out.println();
			System.out.printf("%.6f",taxi);
			
		}
	}
}
