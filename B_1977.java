package test_181107;

import java.util.Scanner;

//����������(�������� �ڿ����� �Ǵ�)�� �� �� �ּҰ� ���ϱ�
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
				//�Ҽ��� ������ ���� �� �ϳ��� 0�� �ƴϸ� ���������� �ƴ�
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
