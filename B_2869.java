package test_190123;

import java.util.Scanner;

//�����̰� ���� a���� ���, ���ῡ b���� �ϰ��ϰ�, �ö󰡾��� ������ ���̴� v������ �� ��� �ö󰡴µ� ��ĥ�� �ɸ����� ����ϱ� 
public class B_2869 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int v = sc.nextInt();
		
		if(1<=b&&b<a&&a<=v&&v<=1000000000) {
			//�̺�Ž��
			int left = 0;
			int right = v/(a-b);
			int mid = 0;
			while(left<=right) {
				//���� �ϼ�
				mid = (left+right)/2;
				if(mid*a-(mid-1)*b>=v) {
					break;
				}else {
					left=mid+1;
				}
			}
			System.out.println(mid);
		}
	}
}
