package test_190128;

import java.util.Scanner;

//�����̰� �µ��� ��� ������ n�� ������ �µ� ��Ȳ�� �־��� ��, k�� ���� ���� �µ� ������ �߾Ӱ� ��ü �� ����ϱ� 
public class B_1572 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		//��ü ����
		int n = sc.nextInt();
		//k�� ������ �κ� ����
		int k = sc.nextInt();
		
		if(n<=250000&&k<=5000&&n>=k) {
			int [] arr = new int[n];
			//��ü ���� �Է�
			for(int i=0;i<n;i++) {
				arr[i]=sc.nextInt();
			}
			int sum = 0;
			int cri = 0;
			//�κ� ������ ���̰� ¦���̸�
			if(k%2==0) {
				cri = k/2-1;
			}
			//�κ� ������ ���̰� Ȧ���̸�
			else {
				cri = k/2;
			}
			for(int i=cri;i<arr.length-k/2;i++) {
				sum+=arr[i];
			}
			System.out.println(sum);
		}
	}
}
