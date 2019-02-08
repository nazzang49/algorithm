package test_190208;

import java.util.Scanner;

class Node {
	int value, parent, childCnt;
	int [] child = new int[50];
	
	//특정 부모의 자식이 생기면(자식 수 추가, 신규 자식 노드 설정)
	public void setChild(int c) {
		childCnt++;
		child[c]=1;
	}
}

public class B_1068_1 {

	static Node [] tree;
	static int [] delList;
	static int n;
	
	public static int getLeaf() {
		//리프 노드 갯수
		int cnt = 0;
		for(int i=0;i<n;i++) {
			//루트 노드 X, 자식 0개, 삭제되지 않은 노드 = 최종 리프 노드
			if(tree[i]!=null&&tree[i].parent!=-1&&tree[i].childCnt==0) {
				cnt++;
			}
		}
		return cnt;
	}
	
	public static void delete(int num) {
		//삭제할 노드 명단 설정
		makeList(num);
		int k, pa;
		for(int i=0;i<n;i++) {
			k = tree[i].value;
			//삭제 명단에 포함되어 있으면(삭제 진행)
			if(delList[k]==1) {
				pa=tree[k].parent;
				tree[k]=null;
				
				//부모 입장에서 현재 자식 노드 제거
				if(pa!=-1&&tree[pa]!=null) {
					tree[pa].child[k]=0;
					tree[pa].childCnt--;
				}
			}
		}
	}
	
	public static void makeList(int num) {
		delList[num]=1;
		//이하 모든 자식 노드 삭제
		for(int i=0;i<n;i++) {
			//삭제 하고자 하는 노드의 자식이면
			if(tree[num].child[i]==1) {
				makeList(i);
			}
		}
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		
		if(n<=50) {
			tree = new Node[n];
			delList = new int[n];
			//부모 자식 관계 설정
			for(int i=0;i<n;i++) {
				//인스턴스 생성
				int pa = sc.nextInt();
				tree[i]=new Node();
				tree[i].value=i;
				tree[i].parent=pa;
				
				//루트 노드가 아니면(부모 설정)
				if(pa!=-1) {
					tree[pa].setChild(i);
				}
			}
			//삭제할 노드 입력
			int k = sc.nextInt();
			delete(k);
			System.out.println(getLeaf());
			
			sc.close();
		}
	}
}
