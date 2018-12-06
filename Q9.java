package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

//���ڿ�, �о �Ÿ��� �־��� �� ����� ��µǴ� ���� ��ȣ ���ϱ�
public class Q9 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<String> answer = new ArrayList<>();
		
		while(true) {
			//�о�� �Ÿ�
			int n = Integer.parseInt(br.readLine());
			String str = br.readLine();
			//quit �Է� �� ���̽��� ���� ��� �� ����
			if(str.equals("quit")) {
				for(int i=0;i<answer.size();i++) {
					System.out.println(answer.get(i));
					System.exit(0);
				}
			}
			String tmp = "";
			for(int i=0;i<str.length();i++) {
				//�����̸� �״�� ���� ����
				if(str.charAt(i)==' ') {
					tmp+=' ';
				}
				//������ �ƴ� ���ڸ�
				else {
					tmp+=(char)(str.charAt(i)+n);
				}
			}
			answer.add(tmp);
		}
	}
}
