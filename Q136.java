package solution;

import java.util.ArrayList;
import java.util.Scanner;

//정수를 담는 덱(앞뒤로 모두 입출력 가능)을 구현하고, 입력 명령을 처리하는 프로그램 작성하기
public class Q136 {

	static ArrayList<Integer> deque = new ArrayList<>();
	static int back = 0;
	static int front = 0;
	
	//가장 앞쪽에 자연수 추가
	public static void push_front(int n) {
		deque.add(0, n);
		back++;
	}
	
	//가장 뒤쪽에 자연수 추가
	public static void push_back(int n) {
		deque.add(back, n);
		back++;
	}
	
	public static int pop_front() {
		//데크가 비어있다면
		if(empty()==1) {
			return -1;
		}else {
			return deque.get(front);
		}
	}
	
	public static int pop_back() {
		if(empty()==1) {
			return -1;
		}else {
			back--;
			return deque.get(back);
		}
	}
	
	public static int size() {
		return back-front;
	}
	
	public static int empty() {
		if(front==back) {
			front=0;
			back=0;
			return 1;
		}else {
			return 0;
		}
	}
	
	public static int front() {
		if(empty()==1) {
			return -1;
		}else {
			return deque.get(front);
		}
	}
	
	public static int back() {
		if(empty()==1) {
			return -1;
		}else {
			back--;
			return deque.get(back);
		}
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		if(1<=n&&n<=10000) {
			ArrayList<Integer> answer = new ArrayList<>();
			//명령 입력(총 8가지)
			for(int i=0;i<n;i++) {
				String str = sc.next();
				if(str.equals("push_front")) {
					int k = sc.nextInt();
					push_front(k);
				}else if(str.equals("push_back")) {
					int k = sc.nextInt();
					push_back(k);
				}else if(str.equals("pop_front")) {
					int tmp = pop_front();
					answer.add(tmp);
					if(tmp!=-1) {
						front++;
					}
				}else if(str.equals("pop_back")) {
					answer.add(pop_back());
				}else if(str.equals("size")) {
					answer.add(size());
				}else if(str.equals("front")) {
					answer.add(front());
				}else if(str.equals("back")) {
					int tmp = back();
					answer.add(tmp);
					if(tmp!=-1) {
						back++;
					}
				}else {
					answer.add(empty());
				}
			}
			for(int i=0;i<answer.size();i++) {
				System.out.println(answer.get(i));
			}
		}
	}
}
