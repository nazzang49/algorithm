package test_190330;

import java.util.Scanner;

//N���� �۰ų� ���� ��� �Ҽ��� ã�� �����佺�׳׽��� ü �����ϰ�, k��° �������� �� ���ϱ�
public class B_2960 {

	public static void find(int n, int k) {
		int cnt = 0;
		int [] d = new int[n+1];
		//�迭 �ʱ�ȭ
		for(int i=2;i<=n;i++) {
			d[i]=i;
		}
		//�����佺�׳׽��� ü Ȱ��
		for(int i=2;i<=n/2;i++) {
			if(d[i]==0) continue;
			for(int j=1;i*j<=n;j++) {
				if(d[i*j]==0) continue;
				cnt++;
				if(cnt==k) {
					System.out.println(d[i*j]);
					System.exit(0);
				}
				d[i*j]=0;
			}
		}
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		if(n<=1000&&k<n) {
			find(n,k);
		}	
	}
}
