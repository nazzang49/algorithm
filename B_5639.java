package test_190219;

import java.util.Scanner;

class Node {
	
	int value;
	Node root;
	Node left;
	Node right;
	
	public Node add(Node parent, int value) {
		if(parent==null) {
			Node newParent = new Node();
			newParent.value=value;
			return newParent;
		}
		//왼쪽으로 입장(루트 노드 그대로 반환)
		else if(parent.value>value) {
			parent.left = add(parent.left, value);
			return parent;
		}
		//오른쪽으로 입장(루트 노드 그대로 반환)
		else if(parent.value<value) {
			parent.right = add(parent.right, value);
			return parent;
		}
		//그 외
		else {
			return parent;
		}
	}
	
	//후위순회
	public void postOrder(Node now) {
		if(now!=null) {
			postOrder(now.left);
			postOrder(now.right);
			System.out.println(now.value);
		}
	}
}

public class B_5639 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		//노드의 최대 크기는 1000
		Node node = new Node();
		
		
		while(true) {
			int tmp = sc.nextInt();
			if(tmp==0) {
				break;
			}
			node.root=node.add(node.root, tmp);
		}
		
		//후위순회 실시
		node.postOrder(node.root);
	}
}
