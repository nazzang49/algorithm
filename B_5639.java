package test_190123;

import java.util.Scanner;

class Node {
	Node left;
	Node right;
	Node root;
	int value;
	
	//��� �߰� �� ���� �ֱٿ� �߰��� ��尡 ���ο� �θ� ��尡 ��
	public Node add(Node Parent, int value) {
		//���� ��Ʈ ��尡 ����ִٸ�
		if(Parent==null) {
			Node newParent = new Node();
			newParent.value=value;
			return newParent;
		}
		//�θ��庸�� ���� ���� ���(�������� Ž��)
		else if(value<Parent.value) {
			Parent.left=add(Parent.left, value);
			return Parent;
		}
		//�θ��庸�� ���� ū ���(���������� Ž��)
		else if(value>Parent.value) {
			Parent.right=add(Parent.right, value);
			return Parent;
		}else {
			return Parent;
		}
	}
	
	//������ȸ �޼ҵ�
	public void postOrder(Node root) {
		if(root!=null) {
			postOrder(root.left);
			postOrder(root.right);
			System.out.println(root.value);
		}
	}
}

//Ư�� ���� Ʈ���� ���� ��ȸ ����� �Է����� �־��� ��, ���� ��ȸ�� ��� ����ϱ�
public class B_5639 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Node node = new Node();
		
		//�Է°��� �����Ѵٸ�
		while(true) {
			int tmp = sc.nextInt();
			if(tmp==0) {
				break;
			}else {
				node.root = node.add(node.root, tmp);
			}
		}
		//������ȸ �ǽ�
		node.postOrder(node.root);
	}
}
