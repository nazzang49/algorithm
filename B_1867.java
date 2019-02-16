package test_190216;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

///NxN ��Ŀ� �������� ��ġ�� �Էµ� ��, ���� �������� �̵��ϸ� �����ϴ� ���� 1ȸ��� �� �� �ּ� Ƚ���� ��� �����̸� �����ϴ� ���α׷� �ۼ��ϱ�(�̺и�Ī)
public class B_1867 {

	//��� ũ��
	static int n;
	//������ ����(1��~n��)
	static int m;
	static ArrayList<Integer> [] A;
	static boolean [] v;
	static int [] aMatch;
	static int [] bMatch;
	static int result = 0;
	
	public static boolean dfs(int cur) {
		for(int i=0;i<A[cur].size();i++) {
			int x = A[cur].get(i);
			
			if(v[x]) continue;
			else v[x]=true;
			
			if(bMatch[x]==0||dfs(bMatch[x])) {
				aMatch[cur]=x;
				bMatch[x]=cur;
				return true;
			}
		}
		return false;
	}
	
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		
		if(n<=500&&m<=10000) {
			aMatch = new int[n+1];
			bMatch = new int[n+1];
			A = new ArrayList[n+1];
			v = new boolean[m+1];
			
			for(int i=1;i<=n;i++) {
				A[i]=new ArrayList<>();
			}
			
			//������ ��ġ �Է�
			for(int i=1;i<=m;i++) {
				A[sc.nextInt()].add(sc.nextInt());
			}
			
			//Ž�� ����
			for(int i=1;i<=n;i++) {
				if(aMatch[i]==0) {
					Arrays.fill(v, false);
					if(dfs(i)) result++;
				}
			}
			System.out.println(result);
		}
	}
}
