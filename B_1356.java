package test_181114;

import java.util.Scanner;

//������(� ���� 10������ ǥ���� �� �� ���� �� �κ����� ������ �� �� �κ� �ڸ� �� �� = �� �κ� �ڸ� �� ��) �Ǻ��ϱ�
public class B_1356 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		if(1<=n&&n<=2147483647) {
			String str = String.valueOf(n);
			//Ž���ؾ��� ����� �� = �Է°��� �ڸ� �� - 1
			for(int i=0;i<str.length()-1;i++) {
				//�� �κ� ��
				String str1 = "";
				//�� �κ� ��
				String str2 = "";
				
				//�� �κ� ����
				for(int j=0;j<=i;j++) {
					str1+=str.charAt(j);
				}
				//�� �κ� ����
				for(int j=i+1;j<str.length();j++) {
					str2+=str.charAt(j);
				}
				//�� �κ� ���� �� �ڸ� �� ��
				long num1 = 1;
				//�� �κ� ���� �� �ڸ� �� ��
				long num2 = 1;
				
				for(int j=0;j<str1.length();j++) {
					num1*=str1.charAt(j)-'0';
				}
				for(int j=0;j<str2.length();j++) {
					num2*=str2.charAt(j)-'0';
				}
				//�������� �Ǵ� �ϳ��� ���� �ִٸ�
				if(num1==num2) {
					System.out.println("YES");
					System.exit(0);
				}
			}
			//�������� �Ǵ� �ϳ��� ��쵵 ���ٸ�
			System.out.println("NO");
			System.exit(0);
		}
	}
}
