package solution;

import java.util.Scanner;

//ġ�� 1kg�� A/B��ŭ ���İ��� ��, �����ִ� ġ���� ���� ���м��� ǥ���ϱ�
public class Q90 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		if(1<=n&&n<k&&k<=9) {
			int p = k-n;
			int q = k;
			boolean flag = true;
			//���м� üũ
			while(flag) {
				//�и� �м��� ��� 2�� ����������
				if(p%2==0&&q%2==0) {
					p/=2;
					q/=2;
					continue;
				}
				//�и� �м��� ��� 3�� ����������
				if(p%3==0&&q%3==0) {
					p/=3;
					q/=3;
					continue;
				}
				flag = false;
			}
			System.out.println(p);
			System.out.println(q);
		}
	}
}
