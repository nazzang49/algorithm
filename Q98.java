package solution;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//1������ n���� ���� ���� n��, ���� ���Ῡ�θ� ��Ÿ���� ���� m��, �̹� ������ ���� ��ȣ�� ��Ÿ���� k�� �Է�, �ݸ��� �� �̿��� �׷� �� ������ ���� t�� �̻��̸� ��ü�� �����Ǵ� ������ ������ �� 1������ n�������� ���� �ϳ��� �ݸ��� �� �������� �ʴ� ���� ���� ����ϱ�
//BFS Ž�� ����
public class Q98 {

	static int n;
	static int m;
	static int k;
	static int t;
	//�� �� ���� ����
	static boolean [][] line;
	//�湮 ����
	static boolean [] visited;
	//���� ����
	static boolean [] infected;
	//������ ���� ����
	static int cnt = 0;
	//���� ���� �迭
	static int [] answer;
	
	//1������ Ž��
	public static void bfs(int node) {
		Queue<Integer> q = new LinkedList<>();
		q.add(node);
		
		//�׷캰 ������ ���� ����
		int cnt_group = 0;
		if(infected[node]) {
			cnt_group = 1;
		}
		while(!q.isEmpty()) {
			int now = q.poll();
			for(int i=1;i<=n;i++) {
				//����Ǿ� �ְ� �湮���� ���� ���̸�
				if(line[now][i]&&!visited[i]) {
					visited[i]=true;
					q.add(i);
					if(infected[now]) {
						cnt_group++;
						infected[i]=true;
					}
				}
			}
		}
		//�� �̻� Ž���� ��尡 ���� ��(=�ϳ��� �׷��� �����Ǹ�) �׷� ��ü ���� ���� �Ǻ�
		if(cnt_group>=t) {
			cnt+=(cnt_group-1);
		}
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		k = sc.nextInt();
		t = sc.nextInt();
		
		line = new boolean[n+1][n+1];
		visited = new boolean[n+1];
		infected = new boolean[n+1];
		answer = new int[n+1];
		
		//���� ���� �Է�
		for(int i=0;i<m;i++) {
			int tmp1 = sc.nextInt();
			int tmp2 = sc.nextInt();
			if(1<=tmp1&&tmp1<=n&&1<=tmp2&&tmp2<=n) {
				//����Ǿ� �ִٸ� ��� �� ��忡���� ���� �̵� ����
				line[tmp1][tmp2]=line[tmp2][tmp1]=true;
			}
		}
		
		int [] infected_idx = new int[k];
		
		//�̹� ������ ���� ��ȣ �Է�
		for(int i=0;i<k;i++) {
			infected_idx[i] = sc.nextInt();
			infected[infected_idx[i]]=true;
		}
		
		//Ž�� ����(1~n�������� ���� �ϳ��� �ݸ� ��ų �� = n���� ����� ���� ��� ����)
		int i = 1;
		while(i<=n) {
			//���� ����(�ݸ�)
			for(int j=1;j<=n;j++) {
				line[i][j]=line[j][i]=false;
			}
			//i��° ���� �ݸ��� ��Ȳ���� �� �׷캰 �湮
			for(int j=1;j<=n;j++) {
				if(!visited[j]) {
					visited[j]=true;
					if(infected[j]) {
						cnt++;
					}
					bfs(j);
				}
			}
			answer[i]=cnt;
			//���� �ʱ�ȭ
			cnt=0;
			infected = new boolean[n+1];
			for(int j=0;j<infected_idx.length;j++) {
				infected[infected_idx[j]]=true;
			}
			visited = new boolean[n+1];
			//���� ��Ȱ(��Ʈ��ŷ)
			for(int j=1;j<=n;j++) {
				line[i][j]=line[j][i]=true;
			}
			i++;
		}
		
		//��ü �������� ���� ���� ����(��ü �� - ������ ���� ����)
		for(int j=1;j<answer.length;j++) {
			System.out.println(n-answer[j]);
		}
	}
}
