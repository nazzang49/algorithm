package test_190122;

import java.util.ArrayList;
import java.util.Scanner;

//����� ��, ���� ������ ������ ������, �� �佺Ƽ�� ��� ��ǥ ������ Ŭ���� ����
class Node {
	int x, y;
	
	public Node(int x, int y) {
		this.x=x;
		this.y=y;
	}
}

//���� ���� 20���� ������ ���� ���� ����� �� �佺Ƽ���� �̵��� ��, 50m���� ���� �Ѻ��� ���Ŵٸ� �������� �ʰ� ���� �������� �Ǻ��ϴ� ���α׷� �ۼ��ϱ�
public class B_9205 {

	static int n;
	static ArrayList<Node> node;
	static boolean flag;
	
	public static void dfs(int start, int beer) {
		if(beer>=0) {
			//�� �佺Ƽ�� ��ҿ� ������ �����ϴ� ��찡 �ϳ��� �ִٸ�
			if(start==node.size()-1) {
				flag=true;
				return;
			}
			for(int i=start+1;i<node.size();i++) {
				//������ �鸮�� �ٽ� ���� 20�� ä��� ���
				beer=20;
				Node A = node.get(start);
				Node B = node.get(i);
				//�� ��� �� �Ÿ� = ����ư �Ÿ�
				int dis = Math.abs(A.x-B.x)+Math.abs(A.y-B.y);
				beer-=(dis/50);
				dfs(i,beer);
			}
		}
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		String [] ans = new String[t];
		
		if(t<=50) {
			int k = 0;
			while(k<t) {
				n = sc.nextInt();
				node = new ArrayList<>();
				flag = false;
				//�� ��� ��ǥ �Է�
				for(int i=0;i<n+2;i++) {
					node.add(new Node(sc.nextInt(), sc.nextInt()));
				}
				//Ž�� ����
				dfs(0,20);
				if(flag) {
					ans[k]="happy";
				}else {
					ans[k]="sad";
				}
				k++;
			}
			for(int i=0;i<ans.length;i++) {
				System.out.println(ans[i]);
			}
		}
	}
}
