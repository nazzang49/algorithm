package test_190328;

import java.util.Scanner;

//5�� �л��� ��� ���� ����ϱ�
public class B_10039 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int sum = 0;
		for(int i=0;i<5;i++) {
			int tmp = sc.nextInt();
			if(tmp>=40) sum+=tmp;
			else sum+=40;
		}
		System.out.println(sum/5);
	}
}
