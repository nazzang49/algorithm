package test_190123;

import java.util.Arrays;
import java.util.Scanner;

//�������� ������ ���� n��, ������ ���� h�� �־��� �� ���˹����� ��ֹ��� �μ��� ������ �ּҰ��� �ش� ������ ���� ���� ����ϱ�
public class B_3020 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int h = sc.nextInt();
		
		if(2<=n&&n<=200000&&2<=h&&h<=500000) {
			//����(�ٴڿ��� �ڶ��)�� ������(õ�忡�� �ڶ��)�� ���� �Է�
			int [] s = new int[h+2];
			int [] j = new int[h+2];
			
			//���̺� ����, ������ ����
			for(int i=0;i<n/2;i++) {
				s[sc.nextInt()]++;
				j[sc.nextInt()]++;
			}
			
			//Ư�� ���̸� ������ ����, ������ ����
			for(int i=h;i>=0;i--) {
				s[i]=s[i]+s[i+1];
				j[i]=j[i]+j[i+1];
			}
			
			int ans = 1;
			int min = Integer.MAX_VALUE;
			//�� ���̺� ���� ��
			for(int i=1;i<=h;i++) {
				int result = s[i]+j[h-i+1];
				if(min>result) {
					min=result;
				}else if(min==result) {
					ans++;
				}
			}
			System.out.println(min);
			System.out.println(ans);
		}
	}
}
