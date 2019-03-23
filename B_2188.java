package test_190323;

import java.util.Arrays;
import java.util.Scanner;

public class B_2188 {

	static int [] A;
	static int [] B;
	//�̹� ��Ī�� ������ �Ǻ��� �迭
	static boolean [] v;
	//�� �Ұ� ���� ���ϴ� ���(����)
	static boolean [][] connect;
	//�� ������
	static int n;
	//��� ����
	static int m;
	
	public static boolean dfs(int cur) {
		if(v[cur]) return false;
		v[cur]=true;
		for(int i=1;i<=m;i++) {
			//���� �Ұ� ���� ����ϴ� ����̸�
			if(connect[cur][i]) {
				//���� ���� or �����Ǿ����� ����� �����ϸ�
				if(B[i]==0||dfs(B[i])) {
					//���� �� - i��° ��� ��Ī
					A[cur]=i;
					//i��° ��� - ���� �� ��Ī
					B[i]=cur;
					//��Ī�� �Ǿ����� true ��ȯ
					return true;
				}
			}
		}
		return false;
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		
		if(n<=200&&m<=200) {
			A = new int[n+1];
			B = new int[m+1];
			v = new boolean[n+1];
			connect = new boolean[n+1][m+1];
			
			//�� �Ұ� ���� ����ϴ� ��� ��ȣ �Է�
			for(int i=1;i<=n;i++) {
				int tmp = sc.nextInt();
				for(int j=0;j<tmp;j++) {
					connect[i][sc.nextInt()]=true;
				}
			}
			
			int cnt = 0;
			//��Ī ����
			for(int i=1;i<=n;i++) {
				//�� Ž������ ���� ��ġ �ٽ� Ž���ϹǷ� �ʱ�ȭ
				Arrays.fill(v, false);
				if(dfs(i)) cnt++;
			}
			System.out.println(cnt);
		}
	}
}
