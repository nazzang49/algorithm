package test_181114;

import java.util.Arrays;
import java.util.Scanner;

//���������� �̷�� ���� 4�� �� 1���� ��Ծ��� �� ������ ������ ���� ���� ����� ���� ���ϱ�
public class B_2997 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int k = sc.nextInt();
		int [] arr = new int[4];
		
		if(-100<=n&&n<=100&&-100<=m&&m<=100&&-100<=k&&k<=100) {
			arr[0]=n;
			arr[1]=m;
			arr[2]=k;
			Arrays.sort(arr);

			//���������� ���հ�
			int tmp = arr[2]-arr[1];
			arr[0] = arr[1]-tmp;
			
			System.out.println(arr[0]);
		}
	}
}
