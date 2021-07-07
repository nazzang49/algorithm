package test_190218;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//�����̰� ������ ���ٲ����� �ϴµ� �� ���� ���� ��ǥ�� �־��� ��, ��Ģ�� ���� �̵��ϸ� ������ ã�� �� �ִܽð� ���ϱ�
public class B_1697 {

	static int n;
	static int k;
	//����Ǵ� �ð� ������ �迭
	static int [] dp;
	static boolean [] v;
	
	//BFS + DP Ž��
	public static void bfs(int x) {
		Queue<Integer> q = new LinkedList<>();
		q.add(x);
		
		while(!q.isEmpty()) {
			int now = q.poll();
			//���ϰ��� �ϴ� ������ ����������
			if(now==k) break;
			for(int i=0;i<3;i++) {
				int nx = now;
				if(i==0) nx++;
				else if(i==1) nx--;
				else nx*=2;
				
				//���� ���� = ���� ��
				if(nx>100000||nx<0) continue;
				
				//���� ���� = ���� ��
				if(!v[nx]) {
					v[nx]=true;
					dp[nx]=dp[now]+1;
					q.add(nx);
				}
			}
		}
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		k = sc.nextInt();
		
		if(n<=100000&&k<=100000) {
			dp = new int[100001];
			v = new boolean[100001];
			
			//Ž�� ����
			bfs(n);
			System.out.println(dp[k]);
		}	
	}
}
