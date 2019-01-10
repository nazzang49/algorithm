package solution;

import java.util.ArrayList;
import java.util.Scanner;

//�־����� �׷����� �̺� �׷���(������ ������ 2�� �׷����� �������� �� �κ����� �� �����鳢�� ���� �������� �ʴ�)���� �ƴ��� �Ǻ��ϴ� ���α׷� �ۼ��ϱ�
//(����Ʈ) ��� �ϳ��� ���� �κ��������� ���� �� ���� ��� �̺б׷����� �� �� ����
public class Q150 {

	static boolean [] visited;
	static boolean [][] line;
	static int v;
	static int e;
	
	public static boolean dfs(int now, int count, ArrayList<Integer> list) {
		count++;
		for(int i=1;i<=v;i++) {
			//���� ��ΰ� �ְ�, ���� �湮���� �ʾ����� ���������� �������� ���� ����� ���
			if(!visited[i]&&line[now][i]&&count==2) {
				visited[i]=true;
				list.add(i);
			}
			//�ٷ� ������ ����� ���(��� ȣ�⸸)
			else if(!visited[i]&&line[now][i]&&count==1) {
				dfs(i,count,list);
			}
		}
		if(list.size()>1) {
			//������ �׷� �� ������ ��尡 �ִ��� Ȯ��
			for(int i=0;i<list.size()-1;i++) {
				for(int j=i+1;j<list.size();j++) {
					//�����ϴٸ�
					if(line[list.get(i)][list.get(j)]) {
						return false;
					}
				}
			}	
		}
		return true;
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		if(1<=t&&t<=5) {
			String [] ans = new String[t];
			int k = 0;
			while(k<t) {
				//���� ����
				v = sc.nextInt();
				//���� ����
				e = sc.nextInt();
				line = new boolean[v+1][v+1];
				visited = new boolean[v+1];
				ArrayList<Integer> list = new ArrayList<>();
				//���� ���� �Է�
				for(int i=0;i<e;i++) {
					int tmp1 = sc.nextInt();
					int tmp2 = sc.nextInt();
					//�� ��� ���� ���� O
					line[tmp1][tmp2]=line[tmp2][tmp1]=true;
				}
				boolean flag = false;
				//�� ���(1�� ~ v��) ���� Ž�� ����(�ϳ��� false ��ȯ ��, �̺б׷��� �� �� ����)
				for(int i=1;i<=v;i++) {
					//���� �湮���� ���� ���
					if(!visited[i]) {
						visited[i]=true;
						list.add(i);
						flag = dfs(i,0,list);
						//��Ģ�� �������� ���ϴ� ���
						if(!flag) {
							break;
						}
						list.clear();
					}
				}
				if(!flag) {
					ans[k]="NO";
				}else {
					ans[k]="YES";
				}
				k++;
			}
			for(int i=0;i<ans.length;i++) {
				System.out.println(ans[i]);
			}
		}
	}
}
