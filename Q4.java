package solution;

import java.util.Scanner;
import java.util.Stack;

//���̰� �ٸ� �������� �踷��⸦ ��ģ ���·� �������� �������� �߻��� ��(VPS ���ڿ� Ȱ��) �߻��ϴ� �踷��� ���� ���� ���ϱ�
public class Q4 {

	//�踷��� ���� ���� ���ϴ� �޼ҵ�
	public static int vps(String str) {
		int cnt = 0;
		boolean flag = false;
		//���� Ȱ��
		Stack<Character> st = new Stack<>();
		for(int i=0;i<str.length();i++) {
			if(str.charAt(i)=='(') {
				flag = true;
				st.push('(');
			}else {
				st.pop();
				//�����ؼ� ')' ��ȣ�̸�(Ŀ�� �ѹ� �ǽ�+1)
				if(!flag) {
					cnt++;
				}else {
					//Ŀ���� ��
					if(st.size()!=0) {
						cnt+=st.size();
					}	
				}
				flag = false;
			}
		}
		return cnt;
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		//�Ұ�ȣ�� �Է� ����
		String str = sc.next();
		int cnt = vps(str);
		System.out.println(cnt);
	}
}
