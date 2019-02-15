package test_190215;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

//������ �� n, ���� �� m, �� ������ �ð� �;��ϴ� ���� ��ȣ�� �־��� ��, ���� �Ϸ��� �� �ִ� ���� �ִ� ���� ����ϱ�
public class B_11375 {

	static int n;
	static int m;
	static ArrayList<Integer> [] A;
	static boolean [] visit;
	static int [] d;
	static int result = 0;
	
	//��� ��쿡 ���� �����ϴ� ���
	public static boolean dfs(int cur) {
		for(int i=0;i<A[cur].size();i++) {
			//�ð��� �ϴ� ���� ��ȣ
			int x = A[cur].get(i);
			
			//���� �湮���� Ȯ��(���� �ο��� dfs����)
			//���� �湮�� �ƴ� = ���� �ο��� �ش� ���� ���� ������ ����(cur�� �ش� �ϟ� ���� �� ����)
			if(visit[x]) continue;
			else visit[x]=true;
			
			//���� �������� ���� ���̰ų�, ���������� �ش� �ο��� �ٸ� ���� �� �� �ִٸ�
			if(d[x]==0||dfs(d[x])) {
				//���� �� �ô� ��� ����
				d[x]=cur;
				return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		
		if(n<=1000&&m<=1000) {
			d = new int[m+1];
			A = new ArrayList[n+1];
			visit = new boolean[m+1];
			//�ð��� �ϴ� �� �Է�
			for(int i=1;i<=n;i++) {
				A[i]=new ArrayList<>();
				int tmp = sc.nextInt();
				for(int j=1;j<=tmp;j++) {
					A[i].add(sc.nextInt());
				}
			}
			//DFS Ž�� ����
			for(int i=1;i<=n;i++) {
				Arrays.fill(visit, false);
				//�� ������ ���ϴ� ���� ���� �� �ִ���
				if(dfs(i)) result++;
			}
			System.out.println(result);
		}	
	}
}
