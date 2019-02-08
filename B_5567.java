package test_190208;

import java.util.ArrayList;
import java.util.Scanner;

//��ȥ�Ŀ� ģ��, �ش� ģ���� ģ������ �ʴ��Ϸ��� �� ��, �Էµ� ģ�� ������ �������� ���� �ʴ��ϴ� �ο��� ���ϱ�
public class B_5567 {

	static int n;
	static int m;
	static boolean [][] friend;
	static boolean [] visited;
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		
		//������� ���� ģ��
		ArrayList<Integer> close = new ArrayList<>();
		if(n<=500&&m<=10000) {
			friend = new boolean[n+1][n+1];
			visited = new boolean[n+1];
			int cnt = 0;
			
			//ģ�� ���� ����
			for(int i=1;i<=m;i++) {
				int tmp1 = sc.nextInt();
				int tmp2 = sc.nextInt();
				
				if(tmp1==1) {
					cnt++;
					visited[tmp2]=true;
					close.add(tmp2);
				}
				friend[tmp1][tmp2]=friend[tmp2][tmp1]=true;
			}
			
			//Ž�� ����
			for(int i=0;i<close.size();i++) {
				for(int j=2;j<=n;j++) {
					if(friend[close.get(i)][j]&&!visited[j]) {
						visited[j]=true;
						cnt++;
					}
				}
			}
			System.out.println(cnt);
		}
	}
}
