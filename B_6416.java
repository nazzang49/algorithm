package test_190128;

import java.util.ArrayList;
import java.util.Scanner;

class Node {
	int u,v;
	boolean visit;
	
	public Node(int u, int v, boolean visit) {
		this.u=u;
		this.v=v;
		this.visit=visit;
	}
}

//�� �׽�Ʈ ���̽��� �׷����� ���� ���� ������ �־��� ��, �ش� �׷����� Ʈ������ �ƴ��� �Ǻ��ϴ� ���α׷� �ۼ��ϱ�
public class B_6416 {

	static ArrayList<Node> list = new ArrayList<>();
	static ArrayList<Boolean> visited = new ArrayList<>();
	static int root = 0;
	static boolean chk3 = false;
	
	//���� ���� �Ǻ�
	public static boolean chk1() {
		for(int i=0;i<list.size()-1;i++) {
			for(int j=i+1;j<list.size();j++) {
				//���� ������ ������
				if(list.get(i).v==list.get(j).v) {
					return false;
				}
			}
		}
		return true;
	}
	
	//��Ʈ ��� ���� �Ǻ�(��߿� �ְ�, ������ ���� ���)
	public static boolean chk2() {
		for(int i=0;i<list.size();i++) {
			boolean flag = false;
			for(int j=0;j<list.size();j++) {
				if(list.get(i).u==list.get(j).v) {
					flag=true;
					break;
				}
			}
			//��Ʈ ��尡 ������
			if(!flag) {
				root=list.get(i).u;
				return true;
			}
		}
		return false;
	}
	
	//���� ��� �Ǻ�(DFS Ž��)
	public static void chk3(int now) {
		boolean flag = false;
		for(int i=0;i<list.size();i++) {
			if(!list.get(i).visit) {
				if(list.get(i).u<=0) {
					return;
				}
				flag=true;
				break;
			}
		}
		//��� �湮�ߴٸ�
		if(!flag) {
			chk3=true;
			return;
		}
		for(int i=0;i<list.size();i++) {
			//���� ���� ����Ǿ� �ְ�, ���� �湮���� ���� ���(v)
			if(list.get(i).u==now&&!list.get(i).visit) {
				list.get(i).visit=true;
				chk3(list.get(i).v);			
			}
		}
	}
	
	public static boolean result() {
		if(chk1()&&chk2()) {
			chk3(root);
			if(chk3) {
				return true;	
			}
		}
		return false;
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int k = 1;
		//��� �迭
		ArrayList<String> ans = new ArrayList<>();
		while(true) {
			//������ ���
			int u = sc.nextInt();
			//������ ����
			int v = sc.nextInt();
			//���� �׽�Ʈ ���̽� ����
			if(u==0&&v==0) {
				boolean flag = result();
				if(flag) ans.add("Case "+k+" is a tree");
				else ans.add("Case "+k+" is not a tree");
				//�迭 �ʱ�ȭ
				list.clear();
				chk3=false;
				k++;
				continue;
			}
			//���� ��� �� ����
			if(u==-1&&v==-1) {
				for(int i=0;i<ans.size();i++) {
					System.out.println(ans.get(i));
				}
				break;
			}
			list.add(new Node(u, v, false));
		}
	}
}
