package solution;

import java.util.ArrayList;
import java.util.Scanner;

//������ �����ϴ� ť�� �����ϰ�, �Է����� �־����� ����� ó���ϴ� ���α׷� �ۼ��ϱ�
public class Q131 {

	static ArrayList<Integer> q = new ArrayList<>();
	//���� ���� ������(����� ��ġ)
	static int front = 0;
	//���� ���� ������(�Է��� ��ġ)
	static int back = 0;
	
	public static void push(int n) {
		q.add(back, n);
		back++;
	}
	
	public static int pop() {
		if(front==back) {
			front=0;
			back=0;
			return -1;
		}else {
			return q.get(front);
		}
	}
	
	public static int size() {
		return back-front;
	}
	
	public static int empty() {
		if(front==back) {
			return 1;
		}else {
			return 0;
		}
	}
	
	public static int front() {
		if(empty()!=1) {
			return q.get(front);
		}else {
			return -1;
		}
	}

	public static int back() {
		if(empty()!=1) {
			back--;
			return q.get(back);
		}else {
			return -1;
		}
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		//�Է� ����� ����
		int n = sc.nextInt();
		ArrayList<Integer> answer = new ArrayList<>();		
		
		if(1<=n&&n<=10000) {
			//��� �Է�
			for(int i=0;i<n;i++) {
				String str = sc.next();
				if(str.equals("push")) {
					int tmp = sc.nextInt();
					push(tmp);
				}else if(str.equals("pop")) {
					int tmp = pop();
					answer.add(tmp);
					//ť�� �� ���µǴ� ��찡 �ƴ� ���� ���� ����� ��ġ�� �̵�
					if(tmp!=-1) {
						front++;
					}
				}else if(str.equals("size")) {
					answer.add(size());
				}else if(str.equals("empty")) {
					answer.add(empty());
				}else if(str.equals("front")) {
					answer.add(front());
				}else {
					int tmp = back();
					answer.add(tmp);
					if(tmp!=-1) {
						back++;
					}
				}
			}
			//���� ���
			for(int i=0;i<answer.size();i++) {
				System.out.println(answer.get(i));
			}
		}
	}
}
