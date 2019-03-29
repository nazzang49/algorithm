package test_190329;

import java.util.Arrays;
import java.util.Scanner;

//�ʿ��� N�� ������ ��� ���� ���� �� �ִ� 1�� ������ �ִ� ���� ���ϱ�
public class B_1654 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		//�̹� ������ �ִ� ���� ����
		int n = sc.nextInt();
		//����� �ϴ� ���� �� ����
		int k = sc.nextInt();
		
		if(n<=10000&&k<=1000000) {
			long [] lan = new long[n];
			//���� ���� ���� �������� ���� �Է�
			for(int i=0;i<lan.length;i++) {
				lan[i]=sc.nextInt();
			}
			//�������� ����
			Arrays.sort(lan);
			//�̺� Ž��
			long left = 1;
			long right = lan[lan.length-1];
			long mid = 0;
			long sum = 0;
			long ans = 0;
			while(left<=right) {
				mid = (left+right)/2;
				sum = 0;
				for(int i=0;i<lan.length;i++) {
					sum+=lan[i]/mid;
				}
				//���� ���� ���� >= ����� �ϴ� ���� ���� = ���� ����
				if(sum>=k) {
					left=mid+1;
					ans = Math.max(ans, mid);
				}
				//���� ���� ���� < ����� �ϴ� ���� ���� = ���� ����
				else right=mid-1;
			}
			System.out.println(ans);
		}
	}
}
