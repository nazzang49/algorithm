package test_181107;

import java.util.Scanner;

//완전제곱수(제곱근이 자연수가 되는)의 합 중 최소값 구하기
public class B_1977 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int n = sc.nextInt();
		int min = 0;
		int sum = 0;
		
		if(1<=m&&m<=10000&&1<=n&&n<=10000&&m<=n) {
			for(int i=m;i<=n;i++) {
				String str = String.valueOf(Math.sqrt(i));
				int k = str.indexOf('.');
				//소수점 이하의 숫자 중 하나라도 0이 아니면 완전제곱수 아님
				boolean flag = false;
				for(int j=k+1;j<str.length();j++) {
					if(str.charAt(j)!='0') {
						flag = true;
						break;
					}
				}
				if(!flag) {
					if(min==0) {
						min=(int)i;
					}
					sum+=(int)i;
				}
			}
			if(min==0) {
				System.out.println(-1);
			}else {
				System.out.println(sum);
				System.out.println(min);
			}
		}
	}
}
