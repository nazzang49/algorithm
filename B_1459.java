package test_181119;

import java.util.Scanner;

//���� ��ǥ���� Ư�� �������� �̵��ϴ� �� ���� ����� ���� ��, �ּ� �ð� ���ϱ�
public class B_1459 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int y = sc.nextInt();
		int w = sc.nextInt();
		int s = sc.nextInt();
		//���� ��� �ð�
		int tmp1 = 0;
		//�밢�� ��� �ð�
		int tmp2 = 0;
		
		if(0<=x&&x<=1000000000&&0<=y&&y<=1000000000&&1<=w&&w<=10000
				&&1<=s&&s<=10000) {
			tmp1 = (x+y)*w;
			
			if(x>y) {
				int tmp = x;
				x=y;
				y=tmp;
			}
			
			for(int i=1;i<=x;i++) {
				//y�� ��ǥ�� ������ ���(=�밢�� �ϳ��� �ϼ��Ǹ� �ð� ����)
				if((y/x)*i%2==0||(y/x)*i%2==1) {
					tmp2 += s;
				}
			}
			System.out.println(tmp2);
			//���׿�����
			System.out.println(tmp1>=tmp2?tmp2:tmp1);
		}
	}
}
