package solution;

import java.util.Scanner;

//�߾ӿ��� ������, �����ڸ��� �������� ĥ���� ���簢�� ���� ����� ī�꿡�� �� ���� ���� ���� ĭ���� ���� ��ü ī�� ũ�� �����ϱ�
public class Q39 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		//������ ����
		int n = sc.nextInt();
		//���� ����
		int m = sc.nextInt();
		
		if(1<=n&&n<=5000&&8<=m&&m<=2000000) {
			//���� �� ���� ����
			int wide = 0;
			int high = 0;
			
			if(n%2==0) {
				//1���� n���� ����� ���ö����� ���� ���� ���� Ž��
				for(int i=1;i<=n;i++) {
					if(n%i==0) {
						//������ ĭ�� ���� ����
						int column = n/i;
						//�� ������ �ϴ� ���� ĭ�� ��
						int total = (column+2)*2+i*2;
						if(total==m) {
							wide=column+2;
							high=i+2;
							if(wide<=high) {
								int tmp = wide;
								wide=high;
								high=tmp;
							}
							break;
						}
					}
				}
			}else {
				wide=n+2;
				high=3;
			}
			System.out.println(wide);
			System.out.println(high);
		}
	}
}
