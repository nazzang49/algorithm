package test_190113;

import java.util.Scanner;

public class B_1613 {

	static int n;
	static int m;
	static int k;
	static int des;
	static int result=0;
	static int [][] history;
	
	//���� ���� �޶����� �� �̻� ������ �� ����
	public static void dfs(int sta, int bfo, int count) {
		//Ž�� ������ ���
		if(history[sta][des]!=0) {
			//�ٷ� ������ ���
			if(count==0) {
				result=history[sta][des];
				return;	
			}
			//�ѹ� �̻� ���ļ� ������ ���(�������� �� �ʼ�)
			else {
				if(history[sta][des]==bfo) {
					result=history[sta][des];
					return;
				}
			}
		}
		//���İ��� ���
		else {
			count++;
			for(int i=1;i<=n;i++) {
				//���İ��� �����ϴ� ���
				if(history[sta][i]!=0) {
					//ó���̸� ������ ����
					if(count==1) {
						bfo=history[sta][i];
						dfs(i,bfo,count);
					}
					//ó���� �ƴϸ� �������� ��(���� ���� ����Լ� ȣ��)
					else {
						if(bfo==history[sta][i]) {
							dfs(i,bfo,count);
						}
					}
				}
			}	
		}
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		
		if(1<=n&&n<=400&&1<=m&&m<=50000) {
			history = new int[n+1][n+1];
			//��� ���İ��� �Է�
			for(int i=0;i<m;i++) {
				int tmp1 = sc.nextInt();
				int tmp2 = sc.nextInt();
				history[tmp1][tmp2]=-1;
				history[tmp2][tmp1]=1;
			}
			k = sc.nextInt();
			//���İ��踦 �˰��� �ϴ� ���� ����
			if(1<=k&&k<=50000) {
				int [] ans = new int[k];
				int j = 0;
				while(j<k) {
					int tmp1 = sc.nextInt();
					int tmp2 = sc.nextInt();
					des=tmp2;
					dfs(tmp1,0,0);
					ans[j]=result;
					result=0;
					j++;
				}
				for(int i=0;i<ans.length;i++) {
					System.out.println(ans[i]);
				}
			}
		}
	}
}
