package solution;

import java.util.ArrayList;
import java.util.Scanner;

//������ �����ϴ� ������ ������ ����, �Է����� �־����� ����� ó���ϴ� ���α׷� �ۼ��ϱ�
public class Q130 {

	//��� ����Ʈ �����迭�� �������� ����
	static ArrayList<Integer> st = new ArrayList<>();
	//�����Ͱ� ��µǴ� ���� ����Ű�� ������ ����
	static int top = 0;
	
	//* top �����ʹ� �׻� ���� ���ʿ� �����Ͱ� �� ��ġ�� ����Ų�ٴ� �� ����
	public static void push(int n) {
		st.add(top, n);
		//�ϳ��� ���� top�� ������ 1�̻�
		top++;
	}
	
	public static int pop() {
		if(top<=0) {
			top=0;
			return -1;
		}else {
			top--;
			return st.remove(top);
		}
	}
	
	public static int size() {
		return top;
	}
	
	public static int empty() {
		if(top==0) {
			return 1;
		}else {
			return 0;
		}
	}
	
	public static int top() {
		if(top<=0) {
			top=0;
			return -1;
		}else {
			top--;
			return st.get(top);
		}
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		//�Է� ����
		int n = sc.nextInt();
		ArrayList<Integer> answer = new ArrayList<>();
		
		if(1<=n&&n<=10000) {
			for(int i=0;i<n;i++) {
				String str = sc.next();
				if(str.equals("push")) {
					int tmp = sc.nextInt();
					push(tmp);
				}else if(str.equals("pop")) {
					answer.add(pop());
				}else if(str.equals("size")) {
					answer.add(size());
				}else if(str.equals("empty")) {
					answer.add(empty());
				}else {
					int tmp = top();
					answer.add(tmp);
					if(tmp!=-1) {
						top++;
					}
				}
			}
			for(int i=0;i<answer.size();i++) {
				System.out.println(answer.get(i));
			}
		}
	}
}
