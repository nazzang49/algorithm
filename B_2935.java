package test_181103;

import java.util.Scanner;

//���� ������ �ذ��ϱ� ���� �������� Ư��
public class B_2935 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String op = sc.next();
		int k = sc.nextInt();
		
		if(1<=n&&n<=Math.pow(10, 99)&&1<=k&&k<=Math.pow(10, 99)&&
				n%10==0&&k%10==0) {
			if(op.equals("*")) {
				System.out.println(n*k);
			}else if(op.equals("+")) {
				System.out.println(n+k);
			}else {
				System.out.println("�������� ������ ����, ������ �����մϴ�.");
				System.exit(0);
			}
		}
	}
}
