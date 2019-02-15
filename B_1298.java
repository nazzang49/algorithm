package test_190215;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

//��Ʈ�� ���� �ο� n, ��Ʈ�� ���� ���� m, �� �ο����� �ڽ��� ���̶� �����ϴ� ��Ʈ�� ��ȣ�� �־��� ��, ��Ʈ���� ���ο��� ���ư��� ����� �ִ밪 ���ϱ�
public class B_1298 {

	static int n;
	static int m;
	static ArrayList<Integer> [] A;
	//���� ��Ʈ�� ����
	static int [] d;
	//������ ���� ��Ʈ������ �Ǻ�
	static boolean [] v;
	static int result = 0;
	
	public static boolean dfs(int cur) {
		for(int i=0;i<A[cur].size();i++) {
			//cur ����� �ڽ��� ���̶� �����ϴ� ��Ʈ�� x
			int x = A[cur].get(i);
			
			//cur�� x�� �������� ������ ���(���� Ž��)
			if(v[x]) continue;
			//cur�� ù ������ ���
			else v[x]=true;
			
			//���� ������ ���ų�, ���� ������ �ٸ� ��Ʈ���� ���� �� �ִٸ�(����)
			if(d[x]==0||dfs(d[x])) {
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
		
		if(n<=100&&m<=5000) {
			v = new boolean[m+1];
			d = new int[m+1];
			A = new ArrayList[n+1];
			
			for(int i=1;i<=n;i++) {
				A[i]=new ArrayList<>();
			}
			
			//�ڽ��� ���̶� �����ϴ� ��Ʈ�ϰ� ���� ����
			for(int i=1;i<=m;i++) {
				A[sc.nextInt()].add(sc.nextInt());
			}
			
			//Ž�� ����
			for(int i=1;i<=n;i++) {
				Arrays.fill(v, false);
				if(dfs(i)) result++;
			}
			System.out.println(result);
		}
	}
}
