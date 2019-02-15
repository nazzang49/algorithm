package test_190215;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

//�׽�Ʈ ���̽��� ���� ������ �� m, �л� �� n, �л��� �Էµ� a��, b���� �־��� ��, ��Ģ�� ���� å�� �ִ��� ���� ������ �� �ִ� ��� ���ϱ�(�̺и�Ī)
public class B_9576 {

	static int n;
	static int m;
	//å�� ���� �迭
	static int [] d;
	//å ���� ���� ����
	static boolean [] v;
	//�л��� ���ϴ� å�� ��ȣ
	static ArrayList<Integer> [] A;
	//������ �� �ִ� �ִ� å�� �Ǽ�
	static int result = 0;
	
	public static boolean dfs(int cur) {
		//cur �л��� ������ �;��ϴ� å�� ��ȣ x
		for(int i=0;i<A[cur].size();i++) {
			int x = A[cur].get(i);
			
			if(v[x]) continue;
			else v[x]=true;
			
			//������ ���ų�, ���� ������ �����ϸ� = ����
			if(d[x]==0||dfs(d[x])) {
				d[x]=cur;
				return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int [] ans = new int[t];
		
		int k = 0;
		while(k<t) {
			//å�� ��
			n = sc.nextInt();
			//�л� ��
			m = sc.nextInt();
			v = new boolean[n+1];
			d = new int[n+1];
			A = new ArrayList[m+1];
			result = 0;
			
			//�л��� ���ϴ� å�� ��ȣ �Է�
			for(int i=1;i<=m;i++) {
				A[i]=new ArrayList<>();
				int a = sc.nextInt();
				int b = sc.nextInt();
				for(int j=a;j<=b;j++) {
					A[i].add(j);
				}
			}
			
			//DFS Ž��
			for(int i=1;i<=m;i++) {
				Arrays.fill(v, false);
				if(dfs(i)) result++;
			}
			ans[k]=result;
			k++;
		}
		for(int i=0;i<ans.length;i++) {
			System.out.println(ans[i]);
		}
	}
}
