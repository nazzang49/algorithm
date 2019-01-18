package test_190118;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

//���� ���� �������� �̷���� � ���� �־��� ��, �� �ۿ��� ���� ���� ���� ���ĺ� ����ϱ�
public class B_1371 {

	public static void main(String[] args) throws IOException{

		//���ĺ� �ҹ���, ������ ������ ������ ���پ� �Է�
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//������ ���ĺ����� ���� Ƚ�� ����
		int [] alpha = new int[26];
		ArrayList<Character> ans = new ArrayList<>();
		
		int len = 0;
		//��ü ���� ���̰� 5000�� ����
		while(len<=5000) {
			String str = br.readLine();
			len+=str.length();
			
			if(str.equals("")) {
				int max = 0;
				for(int i=0;i<alpha.length;i++) {
					//���� �ڸ��� ��ġ�� ���ĺ����� �� ���� ���� ���
					if(alpha[i]>max) {
						max = alpha[i];
					}
				}
				//���� ���� ������ ���ĺ��� �������� ��� ��� ����
				for(int i=0;i<alpha.length;i++) {
					if(alpha[i]==max) {
						ans.add((char)(97+i));
					}
				}
				//���� ���
				for(int i=0;i<ans.size();i++) {
					System.out.println(ans.get(i));
				}
				System.exit(0);
			}
			
			for(int i=0;i<str.length();i++) {
				//������ �ƴ϶��(=���ĺ��̶��)
				if(str.charAt(i)!=' ') {
					alpha[str.charAt(i)-'a']++;
				}
			}
		}
	}
}
