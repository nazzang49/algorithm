package test_190125;

import java.util.Scanner;

//5를 6으로, 6을 5로 볼 수도 있는 상황에서 두 수가 주어질 때, 두 수의 합 중 최소값과 최대값 구하기
public class B_2864 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		if(1<=n&&n<=1000000&&1<=m&&m<=1000000) {
			//최소값은 모든 6을 5로, 최대값은 모든 5를 6으로
			int min = 0;
			int max = 0;
			
			String A = String.valueOf(n);
			String B = String.valueOf(m);
			
			String A_min = "";
			String B_min = "";
			String A_max = "";
			String B_max = "";
						
			for(int i=0;i<A.length();i++) {
				if(A.charAt(i)=='5') {
					A_max+='6';
					A_min+='5';
				}else if(A.charAt(i)=='6') {
					A_max+='6';
					A_min+='5';
				}else {
					A_min+=A.charAt(i);
					A_max+=A.charAt(i);
				}
				
				if(B.charAt(i)=='5') {
					B_max+='6';
					B_min+='5';
				}else if(B.charAt(i)=='6') {
					B_max+='6';
					B_min+='5';
				}else {
					B_min+=B.charAt(i);
					B_max+=B.charAt(i);
				}
			}
			min = Integer.parseInt(A_min)+Integer.parseInt(B_min);
			max = Integer.parseInt(A_max)+Integer.parseInt(B_max);
			System.out.println(min);
			System.out.println(max);
		}
	}
}
