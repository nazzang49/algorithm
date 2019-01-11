package test_190111;

import java.util.ArrayList;
import java.util.Scanner;

//���� ������ ���� ���� ������ �� ���� ���� �̷�� ��Ģ�� �־����ٸ� ���� �̷��� ���ϴ� �л��� �������� ��ȣ ����ϱ�
public class B_9466 {

	static boolean [] visited;
	//�׽�Ʈ ���̽��� ���� �̷��� ���ϴ� �л��� ��
	static int cnt = 0;
	static int n;
	static int [] stu;
	
	public static void dfs(int now, ArrayList<Integer> list) {
		//�ڱ� �ڽ��� ������ ���(ȥ�� �� ����)
		if(now==stu[now]) {
			visited[now]=true;
		}else {
			//���� �ο��� ���� ó�� ������ ������ �ο��� ������ ���(�ϳ��� �� ����)
			if(stu[now]==list.get(0)) {
				for(int i=0;i<list.size();i++) {
					visited[list.get(i)]=true;
				}
			}else {
				//���� �ο����� �ٽ� ȸ��(���ѹݺ�)���� �ʴ� ��쿡��
				if(list.size()==1||stu[now]!=list.get(list.size()-2)) {
					//��� �߰��ϰ� ����Լ� ȣ��
					list.add(stu[now]);
					dfs(stu[now],list);	
				}
			}
		}
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int [] ans = new int[t];
		
		int k = 0;
		while(k<t) {
			n = sc.nextInt();
			stu = new int[n+1];
			visited = new boolean[n+1];
			//�� �л����� ������ �л��� ��ȣ �Է�(1��~n��)
			for(int i=1;i<=n;i++) {
				stu[i]=sc.nextInt();
			}
			ArrayList<Integer> list = new ArrayList<>();
			//Ž�� ����
			for(int i=1;i<=n;i++) {
				if(!visited[i]) {
					list.add(i);
					dfs(i,list);
					list.clear();
				}
			}
			for(int i=1;i<=n;i++) {
				if(!visited[i]) {
					cnt++;
				}
			}
			ans[k]=cnt;
			cnt=0;
			k++;
		}
		for(int i=0;i<ans.length;i++) {
			System.out.println(ans[i]);
		}
	}
}
