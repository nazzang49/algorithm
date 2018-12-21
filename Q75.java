package solution;

import java.util.Scanner;

//���ϰ��� �ϴ� �� ���� �ִ�����(GCD), �ּҰ����(LCM)�� �־��� �� ������ �� �� ���ϱ�(���� �������� ��� ���� �ּҰ� �Ǵ� ��)
public class Q75 {

	//�ִ����� ���ϴ� �޼ҵ�
	public static int GCD(int left, int right) {
		if(right>left) {
			int tmp = left;
			left = right;
			right = tmp;
		}
		//���׿����� Ȱ��(��� ������ �ٸ� ���ʿ� ���� ó������ �������� ���� �� �ٸ� ������ �ִ������� �ȴ�)
		return left%right==0 ? right : GCD(right, left%right);
	}
	
	public static void main(String[] args) {

		Scanner sc= new Scanner(System.in);
		int gcd = sc.nextInt();
		int lcm = sc.nextInt();
		int tmp = lcm/gcd;
		
		int aa = 0;
		int bb = 0;
		for(int i=1;i*i<tmp;i++) {
			if(tmp%i==0) {
				if(GCD(i,tmp/i)==1) {
					aa=i;
					bb=tmp/i;
				}
			}
		}
		System.out.println(gcd*aa);
		System.out.println(gcd*bb);
	}
}
