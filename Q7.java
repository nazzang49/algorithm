package solution;

import java.util.Scanner;

//���� a�� b�� �־��� �� �� �� ������ ��� �� ���ϱ�
public class Q7 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int sum = 0;
		
		if(Math.abs(a)<=10000000&&Math.abs(b)<=10000000) {
			if(a==b) {
				System.out.println(a);
				System.exit(0);
			}else if(a<b) {
				for(int i=a;i<=b;i++) {
					sum+=i;
				}
			}else {
				for(int i=b;i<=a;i++) {
					sum+=i;
				}
			}
			System.out.println(sum);
		}
	}
}
