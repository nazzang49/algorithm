package test_181116;

import java.util.Scanner;

//n�� ����Ʈ�� ���� ��ǥ�� �־��� ��, ���� �����Ͽ� L1-metric �Ÿ�(|a-c|+|b-d|)�� �ִ밪 ã��
//����Ŭ���� �Ÿ�
//�ý� ������
public class B_2381 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int [] x = new int[n];
		int [] y = new int[n];
		int max = 0;
		
		if(1<=n&&n<=50000) {
			for(int i=0;i<n;i++) {
				int x1 = sc.nextInt();
				int y1 = sc.nextInt();
				if(-1000000<=x1&&x1<=1000000&&-1000000<=y1&&y1<=1000000) {
					x[i]=x1;
					y[i]=y1;
				}
			}
			for(int i=0;i<x.length-1;i++) {
				for(int j=i+1;j<x.length;j++) {
					int tmp = Math.abs(x[i]-x[j])+Math.abs(y[i]-y[j]);
					if(tmp>max) {
						max=tmp;
					}
				}
			}
			System.out.println(max);
		}
	}
}
