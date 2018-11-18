package test_181103;

import java.util.Scanner;

//방학숙제를 하지 않고 놀 수 있는 최대일수
public class B_5532 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int l = sc.nextInt();
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		int d = sc.nextInt();
		
		if(2<=l&&l<=40&&1<=a&&a<=1000&&1<=b&&b<=1000&&1<=c&&c<=100&&1<=d&&d<=100) {
			int tmp1 = 0;
			int tmp2 = 0;
			
			for(int i=1;i<=l;i++) {
				if(c*i>a) {
					tmp1=i;
					break;
				}
			}
			
			for(int i=1;i<=l;i++) {
				if(d*i>b) {
					tmp2=i;
					break;
				}
			}
			
			if(tmp1>tmp2) {
				System.out.println(20-tmp1);
			}else {
				System.out.println(20-tmp2);
			}
		}
	}
}
