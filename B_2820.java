package test_190114;

import java.util.ArrayList;
import java.util.Scanner;

//�������� �� n, ���� ��ȭ ������ �� m, ���� ��ȭ�� ��ɾ� p �Ǵ� u�� �־��� �� ���� ��ȭ ����� ����ϱ�
public class B_2820 {

	static int [] payment;
	static boolean [] visited;
	static boolean [][] line;
	static ArrayList<Integer> ans = new ArrayList<>();
	
	public static void dfs(int num, int pay) {
		for(int i=1;i<payment.length;i++) {
			//���� ���� �ø��� ���� �����̰�, ���������̸�(���� ����)
			if(!visited[i]&&line[num][i]) {
				visited[i]=true;
				//num�� ���������� ���, ���� ����
				payment[i]+=pay;
				dfs(i,pay);
				//��Ʈ��ŷ
				visited[i]=false;
			}
		}
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		if(1<=n&&n<=500000&&1<=m&&m<=500000) {
			//�������� �ʱ� ���� ���� �迭
			payment = new int[n+1];
			//���� ���� ���� ���� ������ �迭
			line = new boolean[n+1][n+1];
			visited = new boolean[n+1];
			//�ʱ� ���� �� ���ϰ��� �Է�(����̴� ȸ�� ��ǥ�̹Ƿ�, �ʱ� ���޸� �Է�)
			payment[1]=sc.nextInt();
			for(int i=2;i<=n;i++) {
				int tmp1 = sc.nextInt();
				int tmp2 = sc.nextInt();
				payment[i]=tmp1;
				line[tmp2][i]=true;
			}
			//���� ��ȭ ���� ��ɾ� �Է�
			int k = 0;
			while(k<m) {
				String query = sc.next();
				//tmp1�� ��� �������� ���� tmp2��ŭ ����
				if(query.equals("p")) {
					int tmp1 = sc.nextInt();
					int tmp2 = sc.nextInt();
					dfs(tmp1, tmp2);
				}
				//tmp1�� ���� ���
				else {
					int tmp1 = sc.nextInt();
					ans.add(payment[tmp1]);
				}
				k++;
			}
			for(int i=0;i<ans.size();i++) {
				System.out.println(ans.get(i));
			}
		}
	}
}
