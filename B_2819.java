package test_181103;

import java.util.Scanner;

//�κ��� �̵���ο� ���� ���������� �Ÿ� �� ���(�Ÿ��� ����ư �Ÿ�(=�ý� ������)�� �������� ���)
//����ư �Ÿ� = ��ǥ ���� ������ �ƴ� ��ǥ ���� ���밪�� ���� �Ÿ� ���
public class B_2819 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		//������
		int [] x = new int[n];
		int [] y = new int[n];
		
		int [] answer = new int[m];
		
		//�κ��� ��ǥ
		int a = 0;
		int b = 0;
		
		String order = "";
		
		if(1<=n&&n<=100000&&1<=m&&m<=300000) {
			for(int i=0;i<n;i++) {
				int tmp1 = sc.nextInt();
				int tmp2 = sc.nextInt();
				if(tmp1<=1000000&&tmp2<=1000000) {
					x[i] = tmp1;
					y[i] = tmp2;	
				}
			}
			order = sc.next();
			
			for(int i=0;i<order.length();i++) {
				//�� ��ɾ� ���� �� ����������� �Ÿ� �հ� ����
				int sum=0;
				if(order.charAt(i)=='S') {
					b++;
					for(int j=0;j<x.length;j++) {
						sum+=Math.abs(x[j]-a)+Math.abs(y[j]-b);
					}
				}else if(order.charAt(i)=='J') {
					b--;
					for(int j=0;j<x.length;j++) {
						sum+=Math.abs(x[j]-a)+Math.abs(y[j]-b);
					}
				}else if(order.charAt(i)=='I') {
					a++;
					for(int j=0;j<x.length;j++) {
						sum+=Math.abs(x[j]-a)+Math.abs(y[j]-b);
					}
				}else if(order.charAt(i)=='Z') {
					a--;
					for(int j=0;j<x.length;j++) {
						sum+=Math.abs(x[j]-a)+Math.abs(y[j]-b);
					}
				}
				answer[i]=sum;
			}
			for(int i=0;i<answer.length;i++) {
				System.out.println(answer[i]);
			}
		}
	}
}
