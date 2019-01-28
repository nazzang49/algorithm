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

//각 테스트 케이스별 그래프에 대한 간선 정보가 주어질 때, 해당 그래프가 트리인지 아닌지 판별하는 프로그램 작성하기
public class B_6416 {

	static ArrayList<Node> list = new ArrayList<>();
	static ArrayList<Boolean> visited = new ArrayList<>();
	static int root = 0;
	static boolean chk3 = false;
	
	//유일 간선 판별
	public static boolean chk1() {
		for(int i=0;i<list.size()-1;i++) {
			for(int j=i+1;j<list.size();j++) {
				//이중 간선이 있으면
				if(list.get(i).v==list.get(j).v) {
					return false;
				}
			}
		}
		return true;
	}
	
	//루트 노드 존재 판별(출발에 있고, 도착에 없는 노드)
	public static boolean chk2() {
		for(int i=0;i<list.size();i++) {
			boolean flag = false;
			for(int j=0;j<list.size();j++) {
				if(list.get(i).u==list.get(j).v) {
					flag=true;
					break;
				}
			}
			//루트 노드가 있으면
			if(!flag) {
				root=list.get(i).u;
				return true;
			}
		}
		return false;
	}
	
	//유일 경로 판별(DFS 탐색)
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
		//모두 방문했다면
		if(!flag) {
			chk3=true;
			return;
		}
		for(int i=0;i<list.size();i++) {
			//현재 노드와 연결되어 있고, 아직 방문하지 않은 경우(v)
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
		//출력 배열
		ArrayList<String> ans = new ArrayList<>();
		while(true) {
			//간선의 출발
			int u = sc.nextInt();
			//간선의 도착
			int v = sc.nextInt();
			//현재 테스트 케이스 종료
			if(u==0&&v==0) {
				boolean flag = result();
				if(flag) ans.add("Case "+k+" is a tree");
				else ans.add("Case "+k+" is not a tree");
				//배열 초기화
				list.clear();
				chk3=false;
				k++;
				continue;
			}
			//정답 출력 및 종료
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
