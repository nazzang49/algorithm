package solution;

import java.util.Scanner;

//nxn ���簢�� ����� ü���� ������ ���� ������ �� �ִ� ��ΰ� �����¿�, �밢���� �� ���� ��ġ�� �ʴ� ��� �� n���� ���� ���� ����� �� ���ϱ�
public class Q63 {

	//1~n���� ���� ��ġ�ϰ� �ִ��� ���� Ȯ���� �迭
	static boolean [] visited;
	static int cnt = 0;
	static int n;
	
	public static void dfs(int start, int count) {
		//��� ���� ���� �� �ִ� ���(����+1)
		if(count==n) {
			cnt++;
		}else {
			for(int i=0;i<visited.length;i++) {
				//�湮���� ���� ���
				if(!visited[i]) {
					visited[i]=true;
					//������ ����� ��ġ���� ������� �밢�� ��ο� ��ġ�� �ʴ� idx�� ���
					if(!(i==start-1||i==start+1)) {
						count++;
						dfs(i,count);
						count--;
					}
					visited[i]=false;
				}
			}
		}
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		
		if(1<=n&&n<=13) {
			visited = new boolean[n];
			for(int i=0;i<n;i++) {
				if(!visited[i]) {
					visited[i]=true;
					dfs(i,1);
					visited[i]=false;
				}
			}
			System.out.println(cnt);
		}
	}
}
