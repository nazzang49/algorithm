package test_190126;

import java.util.Scanner;

//4���� �������� �ִ� ���� �뼱�� ���� ��, ����� ������(1) Ÿ��(2) ������ �ݺ��� �� ���� ���� �ο��� ���� �ȿ� �ӹ��� �������� ����� ����ϱ�
public class B_2455 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int max = Integer.MIN_VALUE;
		int total = 0;
		
		//�������� ������orŸ�� �ο� �� �Է�
		for(int i=0;i<4;i++) {
			total-=sc.nextInt();
			total+=sc.nextInt();
			if(max<total) {
				max=total;
			}
		}
		System.out.println(max);
	}
}
