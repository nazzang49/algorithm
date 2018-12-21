package solution;

import java.util.ArrayList;
import java.util.Scanner;

//Ư�� ���ڿ��� �־��� ��, ���ξ�� ���̾ ���ÿ� �����ϴ� �κ� ���ڿ��� ���̸� ���ʴ�� ����ϱ�
public class Q73 {

	//������ �Ǵ� ���ڿ��� ���� ���ʴ�� ������ ���� �迭
	static ArrayList<Integer> answer = new ArrayList<>();
	
	//���ξ� = ���̾� �Ǻ��� �޼ҵ�
	public static void result(String str) {
		String front = "";
		String rear = "";
		for(int i=0;i<str.length();i++) {
			front+=str.charAt(i);
			rear=str.charAt(str.length()-1-i)+rear;
			if(front.equals(rear)) {
				answer.add(i+1);
			}
		}
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		
		if(1<=str.length()&&str.length()<=400000) {
			result(str);
			for(int i=0;i<answer.size();i++) {
				System.out.print(answer.get(i)+" ");
			}
		}
	}
}
