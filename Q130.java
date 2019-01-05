package solution;

import java.util.ArrayList;
import java.util.Scanner;

//정수를 저장하는 스택을 구현한 다음, 입력으로 주어지는 명령을 처리하는 프로그램 작성하기
public class Q130 {

	//어레이 리스트 가변배열을 스택으로 간주
	static ArrayList<Integer> st = new ArrayList<>();
	//데이터가 출력되는 곳을 가르키는 포인터 변수
	static int top = 0;
	
	//* top 포인터는 항상 다음 차례에 데이터가 들어갈 위치를 가르킨다는 것 유념
	public static void push(int n) {
		st.add(top, n);
		//하나라도 들어가면 top은 무조건 1이상
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
		//입력 갯수
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
