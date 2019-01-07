package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Node {
	//���� ��忡 �� ���ĺ�
	char value;
	//���� ����� �ڽ� ���(����, ������)
	Node left;
	Node right;
	
	public Node(char value) {
		this.value=value;
		this.left=null;
		this.right=null;
	}
	
	public void add(char left, char right) {
		//�ڽ� ��尡 ��� ���� �ʴٸ� �Է�
		if(left!='.') this.left = new Node(left);
		if(right!='.') this.right = new Node(right);
	}
	
	//��ȸ�� �⺻������ ����Լ� Ȱ��(�ڽ� => �θ� ���� �ݺ�)
	//���� ��ȸ(��Ʈ - ���� - ������)
	public void preorder() {
		System.out.println(value);
		if(left!=null) left.preorder();
		if(right!=null) right.preorder();
	}
	
	//���� ��ȸ(���� - ��Ʈ - ������)
	//���� ����� �������� �� ����, �� ���������� Ž�� ����(����� ������ ���� ���)
	public void inorder() {
		if(left!=null) left.inorder();
		System.out.println(value);
		if(right!=null) right.inorder();
	}
		
	//���� ��ȸ(���� - ������ - ��Ʈ)
	//���� �� ���������� �Բ� �� ����, �� ���������� Ž�� ����(����� ������ ���� ���)
	public void postorder() {
		if(left!=null) left.postorder();
		if(right!=null) right.postorder();
		System.out.println(value);
	}
	
}

//���� Ʈ���� �����ϴ� Ŭ����
class BinaryTree {
	Node root;
	
	public void add(char value, char left, char right) {
		//ó�� �Է� ��
		if(root==null) {
			if(value!='.') {
				root = new Node(value);
			}
			if(left!='.') {
				root.left = new Node(left);
			}
			if(right!='.') {
				root.right = new Node(right);
			}
		}
		//�� ��° �Է� ����(���� �� ������ �� ��ġ�ϴ� �θ� ��� Ž��)
		else {
			search(root.left, value, left, right);
			search(root.right, value, left, right);
		}
	}
	
	//�޼ҵ� ������ ���� �ڽ� ��尡 ���ο� ��Ʈ ��尡 �Ǵ� ����
	public void search(Node root, char value, char left, char right) {
		//�� �̻� ������ �ڽ� ��尡 ���� ���
		if(root==null) {
			return;
		}
		//���� ��Ʈ ����� ���� �Է��ϰ��� �ϴ� �ڽĳ���� �θ��� ���� ��ġ�ϴ� ��� (�ڽ� ��� �Է�)
		else if(root.value==value) {
			root.add(left, right);
		}
		//��ġ���� ������ �� ����� Ž��
		else {
			search(root.left, value, left, right);
			search(root.right, value, left, right);
		}
	}
	
	//��ȸ ����
	public void preorder() {
		//��尡 �ϳ��� ������
		if(root!=null) root.preorder();
	}
	
	public void inorder() {
		if(root!=null) root.inorder();
	}
	
	public void postorder() {
		if(root!=null) root.postorder();
	}
}

//����Ʈ���� �Էµ� ��, ����, ����, ���� ��ȸ ��� ����ϱ�
public class Q137 {

	//BufferedReader �Է� ��� �� IOException �ʼ�
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		if(1<=n&&n<=26) {
			BinaryTree tree = new BinaryTree();
			
			//����Ʈ�� ����
			char [] node;
			for(int i=0;i<n;i++) {
				//�ϳ��� ���ڿ��� ���� ����(���� ����) �ٽ� �� ���ڷ� ����
				node = br.readLine().replaceAll(" ", "").toCharArray();
				tree.add(node[0],node[1],node[2]);
			}
			//��ȸ ����
			tree.preorder();
			System.out.println();
			tree.inorder();
			System.out.println();
			tree.postorder();
			System.out.println();
		}
	}
}
