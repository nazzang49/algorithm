package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Node {
	//현재 노드에 들어갈 알파벳
	char value;
	//현재 노드의 자식 노드(왼쪽, 오른쪽)
	Node left;
	Node right;
	
	public Node(char value) {
		this.value=value;
		this.left=null;
		this.right=null;
	}
	
	public void add(char left, char right) {
		//자식 노드가 비어 있지 않다면 입력
		if(left!='.') this.left = new Node(left);
		if(right!='.') this.right = new Node(right);
	}
	
	//순회는 기본적으로 재귀함수 활용(자식 => 부모 패턴 반복)
	//전위 순회(루트 - 왼쪽 - 오른쪽)
	public void preorder() {
		System.out.println(value);
		if(left!=null) left.preorder();
		if(right!=null) right.preorder();
	}
	
	//중위 순회(왼쪽 - 루트 - 오른쪽)
	//가장 깊숙한 왼쪽으로 들어간 다음, 그 곳에서부터 탐색 시작(깊숙한 곳부터 먼저 출력)
	public void inorder() {
		if(left!=null) left.inorder();
		System.out.println(value);
		if(right!=null) right.inorder();
	}
		
	//후위 순회(왼쪽 - 오른쪽 - 루트)
	//왼쪽 및 오른쪽으로 함께 들어간 다음, 그 곳에서부터 탐색 시작(깊숙한 곳부터 먼저 출력)
	public void postorder() {
		if(left!=null) left.postorder();
		if(right!=null) right.postorder();
		System.out.println(value);
	}
	
}

//이진 트리를 형성하는 클래스
class BinaryTree {
	Node root;
	
	public void add(char value, char left, char right) {
		//처음 입력 시
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
		//두 번째 입력 부터(왼쪽 및 오른쪽 중 일치하는 부모 노드 탐색)
		else {
			search(root.left, value, left, right);
			search(root.right, value, left, right);
		}
	}
	
	//메소드 내에서 다음 자식 노드가 새로운 루트 노드가 되는 개념
	public void search(Node root, char value, char left, char right) {
		//더 이상 생성할 자식 노드가 없는 경우
		if(root==null) {
			return;
		}
		//현재 루트 노드의 값이 입력하고자 하는 자식노드의 부모노드 값과 일치하는 경우 (자식 노드 입력)
		else if(root.value==value) {
			root.add(left, right);
		}
		//일치하지 않으면 더 깊숙이 탐색
		else {
			search(root.left, value, left, right);
			search(root.right, value, left, right);
		}
	}
	
	//순회 시작
	public void preorder() {
		//노드가 하나라도 있으면
		if(root!=null) root.preorder();
	}
	
	public void inorder() {
		if(root!=null) root.inorder();
	}
	
	public void postorder() {
		if(root!=null) root.postorder();
	}
}

//이진트리가 입력될 때, 전위, 중위, 후위 순회 결과 출력하기
public class Q137 {

	//BufferedReader 입력 사용 시 IOException 필수
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		if(1<=n&&n<=26) {
			BinaryTree tree = new BinaryTree();
			
			//이진트리 구현
			char [] node;
			for(int i=0;i<n;i++) {
				//하나의 문자열로 만든 다음(공백 제거) 다시 각 문자로 분해
				node = br.readLine().replaceAll(" ", "").toCharArray();
				tree.add(node[0],node[1],node[2]);
			}
			//순회 시작
			tree.preorder();
			System.out.println();
			tree.inorder();
			System.out.println();
			tree.postorder();
			System.out.println();
		}
	}
}
