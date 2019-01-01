package solution;

import java.util.Scanner;

//AX + BY = D(A�� B�� �ִ�����)�� �����ϴ� X, Y, D ����ϱ�(��Ŭ���� Ȯ�� ����)
public class Q114 {

	public static int GCD(int a, int b) {
		if(b>a) {
			int tmp = a;
			a=b;
			b=tmp;
		}
		//���׿���(ū ���� ���� ���� ������ �� �������� �������� ������ ���� ���� �ִ�����)
		return a%b==0? b:GCD(a%b,b);
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int gcd = GCD(a,b);
		
		int x = 0;
		int y = 0;
		
		while(true) {
			y=(gcd-a*x)/b;
			if(a*x+b*y==gcd) {
				break;
			}
			x--;
		}
		System.out.println(x);
		System.out.println(y);
		System.out.println(gcd);
	}
}
