package solution;

import java.util.Scanner;

//n��Ҹ� ��� ����ϰ� ���ƿ��� �˹��� ��� ��, �̵� ����� �ּ�ȭ�Ͽ� �����̴� ����� ��� ���ϱ�
public class Q64 {

	//������ ����
	static int n;
	//��� ���� �湮 ���� ������ �迭
	static boolean [] visited;
	static int [][] cost;
	//�ִ밪���� �ʱ�ȭ
	static int min = Integer.MAX_VALUE;
	
	public static void dfs(int start, int sum, int count) {
		if(count==n-1) {
			//�������� ������� �̵�
			sum+=cost[start][0];
			if(min>=sum) {
				min=sum;
			}
		}else {
			count++;
			for(int i=1;i<cost[start].length;i++) {
				if(!visited[i]) {
					visited[i]=true;
					sum+=cost[start][i];
					dfs(i,sum, count);
					sum-=cost[start][i];
					visited[i]=false;
				}
			}
		}
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		
		//�ִ� ���� �� �湮 ����(1������ ���� �� ����)
		if(1<=n&&n<=12) {
			visited = new boolean[n];
			cost = new int[n][n];
			//��� �Է�
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					int tmp = sc.nextInt();
					if(0<=tmp&&tmp<=100) {
						cost[i][j]=tmp;
					}
				}
			}
			//Ž��(0���� 1�� ���� �ͺ��� ����)
			for(int i=1;i<n;i++) {
				if(!visited[i]) {
					visited[i]=true;
					dfs(i,cost[0][i],1);
					visited[i]=false;
				}
			}
			System.out.println(min);
		}
	}
}
