package test_181203;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

//��ȣ�� �迭�� �־��� �� �ش� �迭�� ������ �Ǵ� �� ����ȭ Ƚ�� ���ϴ� ���α׷� �����
public class B_4889 {

	//����ȭ Ƚ��
	static int cnt = 0;
	static ArrayList<Integer> answer;
	
	//��ȣ �迭 ������ ���� �Ǵ� �޼ҵ�
	public static void VPS(Stack<Character> vps, String str) {
		//ù ���ڴ� ������ ����
		vps.push(str.charAt(0));
		for(int i=1;i<str.length();i++) {
			if(str.charAt(i)=='{') {
				vps.push('{');
			}else if(str.charAt(i)=='}') {
				vps.pop();
			}
		}
		int left = 0;
		int right = 0;
		//������ ��� ���� �ʴٸ�
		if(!vps.isEmpty()) {
			for(int i=0;i<vps.size();i++) {
				if(vps.get(i)=='}') {
					left++;
				}else {
					right++;
				}
			}
		}
		cnt=left*2+right/2;
		answer.add(cnt);
		cnt=0;
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		answer = new ArrayList<>();
		
		while(true) {
			String str = sc.next();
			//������ �Է� �� �װ��� �׽�Ʈ ���̽��� ���� ��� �� ����
			if(str.charAt(0)=='-') {
				for(int i=0;i<answer.size();i++) {
					System.out.println(answer.get(i));
				}
				System.exit(0);
			}
			//���ڿ��� ���̴� 2000�����̸� �׻� ¦��
			if(str.length()<=2000&&str.length()%2==0) {
				Stack<Character> vps = new Stack<>();
				VPS(vps, str);
			}else {
				System.out.println("�Է� ������ Ȯ���ϼ���.");
				System.exit(0);
			}
		}
	}
}
