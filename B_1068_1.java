package test_190208;

import java.util.Scanner;

class Node {
	int value, parent, childCnt;
	int [] child = new int[50];
	
	//Ư�� �θ��� �ڽ��� �����(�ڽ� �� �߰�, �ű� �ڽ� ��� ����)
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
		//���� ��� ����
		int cnt = 0;
		for(int i=0;i<n;i++) {
			//��Ʈ ��� X, �ڽ� 0��, �������� ���� ��� = ���� ���� ���
			if(tree[i]!=null&&tree[i].parent!=-1&&tree[i].childCnt==0) {
				cnt++;
			}
		}
		return cnt;
	}
	
	public static void delete(int num) {
		//������ ��� ��� ����
		makeList(num);
		int k, pa;
		for(int i=0;i<n;i++) {
			k = tree[i].value;
			//���� ��ܿ� ���ԵǾ� ������(���� ����)
			if(delList[k]==1) {
				pa=tree[k].parent;
				tree[k]=null;
				
				//�θ� ���忡�� ���� �ڽ� ��� ����
				if(pa!=-1&&tree[pa]!=null) {
					tree[pa].child[k]=0;
					tree[pa].childCnt--;
				}
			}
		}
	}
	
	public static void makeList(int num) {
		delList[num]=1;
		//���� ��� �ڽ� ��� ����
		for(int i=0;i<n;i++) {
			//���� �ϰ��� �ϴ� ����� �ڽ��̸�
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
			//�θ� �ڽ� ���� ����
			for(int i=0;i<n;i++) {
				//�ν��Ͻ� ����
				int pa = sc.nextInt();
				tree[i]=new Node();
				tree[i].value=i;
				tree[i].parent=pa;
				
				//��Ʈ ��尡 �ƴϸ�(�θ� ����)
				if(pa!=-1) {
					tree[pa].setChild(i);
				}
			}
			//������ ��� �Է�
			int k = sc.nextInt();
			delete(k);
			System.out.println(getLeaf());
			
			sc.close();
		}
	}
}
