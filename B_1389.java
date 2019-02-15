package test_190215;

import java.util.Arrays;
import java.util.Scanner;

//������ �� n, ģ�� ������ �� m, ģ�� ���� ������ �־��� ��, ��Ģ�� ���� ���� �ɺ� �������� �� �ּҰ� ���ϱ�(�÷��̵� �ͼ�)
public class B_1389 {

	static int n;
	static int m;
	//ģ�� ���� ����
	static int [][] f;
	static int ans = 0;
	static int [] kevin;
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		
		if(n<=100&&m<=100) {
			f = new int[n+1][n+1];
			kevin = new int[n+1];
			
			//���Ѱ����� �ʱ�ȭ
			for(int i=1;i<=n;i++) {
				Arrays.fill(f[i], 100001);
				//�ڱ� �ڽ��� ģ���� ��� = 0
				f[i][i]=0;
			}
			
			//ģ�� ���� �Է�
			for(int i=1;i<=m;i++) {
				int tmp1 = sc.nextInt();
				int tmp2 = sc.nextInt();
				f[tmp1][tmp2]=f[tmp2][tmp1]=1;
			}
			
			//�÷��̵� �ͼ� ����(i���� j�� �ٷ� ���� ��� = ���� ģ��, i���� k�� ���� j�� ���� ��� = ���� ģ��)
			for(int k=1;k<=n;k++) {
				for(int i=1;i<=n;i++) {
					for(int j=1;j<=n;j++) {
						//�ִ� �Ÿ� ����
						if(f[i][k]+f[k][j]<f[i][j]) {
							f[i][j]=f[i][k]+f[k][j];
						}
					}
				}
			}
			
			//����� kevin �迭�� ����
			for(int i=1;i<=n;i++) {
				for(int j=1;j<=n;j++) {
					kevin[i]+=f[i][j];
				}
			}
			
			int min = Integer.MAX_VALUE;
			for(int i=1;i<=n;i++) {
				if(min>kevin[i]) {
					min=kevin[i];
					ans=i;
				}
			}
			System.out.println(ans);
		}
	}
}
