package test_190114;

import java.util.ArrayList;
import java.util.Scanner;

//�Է����� �־����� ���ڿ��� ���� ���ڿ��� �־��� ��, ��� ������ ������ �����ִ� ���ڿ� ����ϱ�
public class B_9935 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		String exp = sc.next();
		ArrayList<Character> list = new ArrayList<>();
		
		if(1<=str.length()&&str.length()<=1000000&&1<=exp.length()&&exp.length()<=36) {
			//�����迭�� �Է� ���ڿ� ����
			for(int i=0;i<str.length();i++) {
				list.add(str.charAt(i));
			}
			while(true) {
				int cnt = 0;
				//Ž�� ����
				for(int i=0;i<list.size()-1;i++) {
					//���ڿ��� Ư�� ���ڿ� ���� ���ڿ��� ù���ڰ� ���ٸ�
					if(list.get(i)==exp.charAt(0)) {
						boolean flag = false;
						for(int j=1;j<exp.length();j++) {
							//�� ���ڶ� �ٸ��� ���� �Ͼ�� ����
							if(list.get(i+j)!=exp.charAt(j)) {
								flag=true;
								break;
							}
						}
						//�����ϴ� ���
						if(!flag) {
							cnt++;
							for(int j=0;j<exp.length();j++) {
								list.remove(i);
							}
						}
					}
				}
				//�����ϴ� ���ڰ� �ϳ��� ������(�ݺ� ����)
				if(cnt==0) {
					break;
				}
			}
			for(int i=0;i<list.size();i++) {
				System.out.print(list.get(i));
			}
		}
	}
}
