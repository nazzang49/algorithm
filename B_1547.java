package test_190126;

import java.util.Scanner;

//�� 3��, 1�� �ſ� ���� ������ �� ���� ��ġ�� �ٲٴ� n���� ����� �־��� �� ���� ���� ����ִ� ���� ��ġ ���ϱ�
public class B_1547 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		//���� ��� ���� ��ġ
		int gong = 1;
		
		if(n<=50) {
			//���� ��ġ �ٲٱ�
			for(int i=0;i<n;i++) {
				int cup1 = sc.nextInt();
				int cup2 = sc.nextInt();
				if(cup1==gong) {
					gong=cup2;
				}else if(cup2==gong) {
					gong=cup1;
				}
			}
			System.out.println(gong);
		}
	}
}
