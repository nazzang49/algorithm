package test_190201;

import java.util.ArrayList;
import java.util.Scanner;

//1���� n������ ���� ���Ƿ� �迭�� ����� ���� n!�̰�, ���� �ε������� ���� ���� ���� ä������ ��, Ư�� ������ ������ ����ϰų� �Էµ� ������ ���°���� ����ϱ�
public class B_1722 {

	static int n;
	static int m;
	static int cnt = 0;
	static boolean [] visited;
	static int [] arr;
	
	public static void dfs(ArrayList<Integer> list) {
		if(list.size()==n) {
			m--;
			if(m==0) {
				for(int i=0;i<list.size();i++) {
					System.out.println(list.get(i));
				}
				return;
			}
		}else {
			for(int i=1;i<=n;i++) {
				if(!visited[i]) {
					visited[i]=true;
					list.add(i);
					dfs(list);
					list.remove(list.size()-1);
					visited[i]=false;
				}
			}
		}
	}
	
	public static void find(ArrayList<Integer> list) {
		if(list.size()==n) {
			cnt++;
			boolean flag = false;
			for(int i=0;i<list.size();i++) {
				if(list.get(i)!=arr[i]) {
					flag=true;
					break;
				}
			}
			if(!flag) {
				System.out.println(cnt);
				return;
			}
		}else {
			for(int i=1;i<=n;i++) {
				if(!visited[i]) {
					visited[i]=true;
					list.add(i);
					find(list);
					list.remove(list.size()-1);
					visited[i]=false;
				}
			}
		}
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		
		if(n<=20) {
			visited = new boolean[n+1];
			int k = sc.nextInt();
			//k��° ������ �ش��ϴ� ���� ����ϱ�
			if(k==1) {
				//���� ���° �������� ����� ����
				m = sc.nextInt();
				ArrayList<Integer> list = new ArrayList<>();
				for(int i=1;i<=n;i++) {
					list.add(i);
					visited[i]=true;
					dfs(list);
					visited[i]=false;
					list.clear();
				}
			}
			//������ �Է��ϰ� ���°���� ����ϱ�
			else {
				ArrayList<Integer> list = new ArrayList<>();
				//����Ʈ�� ���� �Էµ� ����
				arr = new int[n];
				for(int i=0;i<arr.length;i++) {
					arr[i]=sc.nextInt();
				}
				for(int i=1;i<=n;i++) {
					list.add(i);
					visited[i]=true;
					find(list);
					visited[i]=false;
					list.clear();
				}
			}
		}
	}
}
