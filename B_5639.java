package test_190123;

import java.util.Scanner;

class Node {
	Node left;
	Node right;
	Node root;
	int value;
	
	//노드 추가 시 가장 최근에 추가된 노드가 새로운 부모 노드가 됨
	public Node add(Node Parent, int value) {
		//최초 루트 노드가 비어있다면
		if(Parent==null) {
			Node newParent = new Node();
			newParent.value=value;
			return newParent;
		}
		//부모노드보다 값이 작은 경우(왼쪽으로 탐색)
		else if(value<Parent.value) {
			Parent.left=add(Parent.left, value);
			return Parent;
		}
		//부모노드보다 값이 큰 경우(오른쪽으로 탐색)
		else if(value>Parent.value) {
			Parent.right=add(Parent.right, value);
			return Parent;
		}else {
			return Parent;
		}
	}
	
	//후위순회 메소드
	public void postOrder(Node root) {
		if(root!=null) {
			postOrder(root.left);
			postOrder(root.right);
			System.out.println(root.value);
		}
	}
}

//특정 이진 트리의 전위 순회 결과가 입력으로 주어질 때, 후위 순회한 결과 출력하기
public class B_5639 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Node node = new Node();
		
		//입력값이 존재한다면
		while(true) {
			int tmp = sc.nextInt();
			if(tmp==0) {
				break;
			}else {
				node.root = node.add(node.root, tmp);
			}
		}
		//후위순회 실시
		node.postOrder(node.root);
	}
}
