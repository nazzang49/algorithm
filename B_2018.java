package test_181115;

import java.util.Scanner;

//��� �ڿ��� �Է°��� �־����� ��, ���ӵ� �ڿ����� ������ �ش� �ڿ����� ǥ���� �� �ִ� ����� �� ���ϱ�
public class B_2018 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		//����� �� ������ ����(�ڱ� �ڽ��� �ݵ�� �����ϹǷ� 1�� �ʱ�ȭ)
		int cnt = 1;
		
		if(1<=n&&n<=10000000) {
			for(int i=1;i<=n/2+1;i++) {
				int sum = 0;
				sum+=i;
				for(int j=i+1;j<=n/2+1;j++) {
					sum+=j;
					if(sum==n) {
						cnt++;
						break;
					}else if(sum>n) {
						break;
					}
				}
			}
			System.out.println(cnt);
		}
	}
}
