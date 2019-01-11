package test_190111;

import java.util.ArrayList;
import java.util.Scanner;

//1������ n������ n������ ������ ����ų ��, ���Ƿ� ���� Ư�� ��ȣ�� ���հ� �� ������ ���� ����Ű�� ������ ������ ��Ȯ�� ��ġ�ϴ� �ִ� ���� ���ϱ�
public class B_2668 {

	static int n;
	static int [] num;
	static boolean [] visited;
	static ArrayList<Integer> ans = new ArrayList<>();
	
	public static void dfs(int now, ArrayList<Integer> list) {
		//ȸ���ϴ� ���(�ϳ��� �κ����� ����)
		if(num[now]==list.get(0)) {
			for(int i=0;i<list.size();i++) {
				visited[list.get(i)]=true;
				ans.add(list.get(i));
			}
		}else {
			//�ڱ� �ڽ� ����Ű�� ���(�ߺ� ����)
			if(num[now]==now&&!visited[now]) {
				visited[now]=true;
				ans.add(now);
			}
			//�ٸ� ���� ����Ű�� ���
			else {
				//�ش� ������° �湮���� ���� ���
				if(!visited[num[now]]) {
					list.add(num[now]);
					dfs(num[now],list);
				}
			}
		}
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		
		if(1<=n&&n<=100) {
			num = new int[n+1];
			visited = new boolean[n+1];
			ArrayList<Integer> list = new ArrayList<>();
			//���� �Է�
			for(int i=1;i<=n;i++) {
				num[i]=sc.nextInt();
			}
			//Ž�� ����(�� ��ȣ���� ���� Ž��)
			for(int i=1;i<=n;i++) {
				if(!visited[i]) {
					list.add(i);
					dfs(i,list);
					list.clear();
				}
			}
			System.out.println(ans.size());
			//���� �迭 �������� ����
			for(int i=0;i<ans.size()-1;i++) {
				for(int j=i+1;j<ans.size();j++) {
					if(ans.get(i)>=ans.get(j)) {
						int tmp = ans.get(i);
						ans.set(i, ans.get(j));
						ans.set(j, tmp);
					}
				}
			}
			for(int i=0;i<ans.size();i++) {
				System.out.println(ans.get(i));
			}
		}
	}
}
