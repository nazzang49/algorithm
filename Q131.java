package solution;

import java.util.ArrayList;
import java.util.Scanner;

//정수를 저장하는 큐를 구현하고, 입력으로 주어지는 명령을 처리하는 프로그램 작성하기
public class Q131 {

	static ArrayList<Integer> q = new ArrayList<>();
	//가장 앞쪽 포인터(출력할 위치)
	static int front = 0;
	//가장 뒤쪽 포인터(입력할 위치)
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
		//입력 명령의 갯수
		int n = sc.nextInt();
		ArrayList<Integer> answer = new ArrayList<>();		
		
		if(1<=n&&n<=10000) {
			//명령 입력
			for(int i=0;i<n;i++) {
				String str = sc.next();
				if(str.equals("push")) {
					int tmp = sc.nextInt();
					push(tmp);
				}else if(str.equals("pop")) {
					int tmp = pop();
					answer.add(tmp);
					//큐가 비어서 리셋되는 경우가 아닐 때만 다음 출력할 위치로 이동
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
			//정답 출력
			for(int i=0;i<answer.size();i++) {
				System.out.println(answer.get(i));
			}
		}
	}
}
