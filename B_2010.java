package test_181107;

import java.util.Scanner;

//�ܼ�Ʈ �÷��װ� �ϳ��ۿ� ���� �� ������ �ִ� ��Ƽ���� Ȱ���Ͽ� �ִ�� �÷��׸� Ȯ���� �� �ִ� ���
public class B_2010 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		//���� Ȯ���� �÷��� ���� ����
		int cnt = 1;
		
		//��Ƽ�� ������ ������ �÷��� ������ -1 and +tmp
		if(1<=n&&n<=500000) {
			for(int i=0;i<n;i++) {
				int tmp = sc.nextInt();
				if(1<=tmp&&tmp<1000) {
					cnt+=tmp;
					cnt-=1;
				}
			}
			System.out.println(cnt);
		}
	}
}
