package test_181125;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//���� ���� ������ �־��� ��, Ʈ���� �ִ� ���� �� ���ϱ�
public class B_12761 {

	static boolean [] visited = new boolean [100001];
	//�̵� Ƚ�� ������ �迭
	static int [] dp = new int [100001];
	static int a;
	static int b;
	static int n;
	static int m;
	
	public static void bfs(int x, int [] move) {
		Queue<Integer> q = new LinkedList<>();
		q.add(x);
		
		while(!q.isEmpty()) {
			int d = q.poll();
			//���� �����̸�
			if(d==m) {
				System.out.println(dp[m]);
				System.exit(0);
			}
			for(int i=0;i<8;i++) {
				//���� ����
				int s = 0;
				
				if(i>=6) {
					s=d*move[i];
				}else {
					s=d+move[i];
				}
				
				//���� ����� �����̸�
				if(s<0||s>100000) {
					continue;
				}
				
				if(!visited[s]) {
					dp[s]=dp[d]+1;
					visited[s]=true;
					q.add(s);
				}
			}
		}
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		//�ѹ��� ������ �̵� �Ÿ� a,b
		a = sc.nextInt();
		b = sc.nextInt();
		//��� ����
		n = sc.nextInt();
		//���� ����
		m = sc.nextInt();
		
		int [] move = {1,-1,a,b,-a,-b,a,b};
		
		if(2<=a&&a<=30&&2<=b&&b<=30&&0<=n&&n<=100000&&0<=m&&m<=100000) {
			bfs(n,move);
		}else {
			System.out.println("�Է°��� ������ Ȯ���ϼ���.");
			System.exit(0);
		}
	}
}
