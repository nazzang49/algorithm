package test_181115;

import java.util.Scanner;

//���������(�ڿ��� X�� ���μ����� ���� ��, �����ϴ� �Ҽ��� ������ �Ҽ��� ��) ���ϱ�
public class B_1124 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		//�Ҽ��� ���� ������ ����
		int cnt = 0;
		//���� ���� ������ ����
		int answer = 0;
		
		if(2<=n&&n<=100000&&2<=m&&m<=100000&&n<=m) {
			for(int i=n;i<=m;i++) {
				int tmp = i;
				//������ �Ҽ��� ������ ������ �ݺ� ����
				for(int j=2;j<=tmp/2;j++) {
					if(tmp%j==0) {
						tmp=tmp/j;
						cnt++;
						//�ݺ����� ������ �ٽ� 2�� �����ϱ� ���� ��ġ
						j=1;
					}
				}
				//������ �����ϴ� �Ҽ� 1�� ����
				cnt++;
				boolean flag = false;
				for(int j=2;j<=cnt/2;j++) {
					if(cnt%j==0) {
						flag=true;
						break;
					}
				}
				//cnt�� ������ �Ҽ��̰� �� �� = �Ҽ� �ƴ� ��� ex)2,3,5,7 ��
				if(!flag&&!(cnt==1)) {
					answer++;
				}
				cnt=0;
			}
			System.out.println(answer);
		}
	}
}
