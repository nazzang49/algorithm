package solution;

import java.util.Scanner;

//� ���Կ����� �ܹ���, ����, ���̵� �޴�, ����Ʈ ���� ������ ���� ��ԵǴ� �� Į�θ� ����ϱ�
public class Q113 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int [] burger = new int[4];
		int [] drink = new int[4];
		int [] side = new int[4];
		int [] dessert = new int[4];
		
		//�� �޴��� Į�θ� �Է�
		for(int i=0;i<4;i++) {
			burger[i]=sc.nextInt();
		}
		for(int i=0;i<4;i++) {
			drink[i]=sc.nextInt();
		}
		for(int i=0;i<4;i++) {
			side[i]=sc.nextInt();
		}
		for(int i=0;i<4;i++) {
			dessert[i]=sc.nextInt();
		}
		
		int sum = 0;
		sum+=burger[sc.nextInt()];
		sum+=drink[sc.nextInt()];
		sum+=side[sc.nextInt()];
		sum+=dessert[sc.nextInt()];
		
		System.out.println("Your total Calroie count is "+sum);
		
	}
}
