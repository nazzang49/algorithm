package test_181113;

import java.util.Scanner;

//�� ���� �ڿ����� ���Ͽ� �Էµ� ���� �������� ����� �� ���ϱ�
public class B_1940 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int [] arr = new int[n];
		int cnt = 0;
		
		if(1<=n&&n<=15000&&1<=m&&m<=10000000) {
			for(int i=0;i<n;i++) {
				arr[i]=sc.nextInt();
			}
			//�������� ��İ� ������ Ž��
			for(int i=0;i<arr.length-1;i++) {
				for(int j=i+1;j<arr.length;j++) {
					if(arr[i]+arr[j]==m) {
						cnt++;
					}
				}
			}
			System.out.println(cnt);
		}
	}
}
