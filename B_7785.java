package test_190123;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

//�α׿� ��ϵ� ���� ����� �� n���� �־��� ��, ���� ȸ�翡 ���� �ִ� �ο��� ���� ������ ����ϱ�
public class B_7785 {

	public static boolean result(String str1, String str2) {
		int len = Math.min(str1.length(), str2.length());
		for(int i=0;i<len;i++) {
			//���ʿ� �ִ� ������� ���� ������ �� �տ� �ִٸ� 
			if(str1.charAt(i)<str2.charAt(i)) {
				return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		if(2<=n&&n<=Math.pow(10, 6)) {
			//�α� ��Ͽ� ���� ���� �ִ� ��� ������ ���� �迭
			ArrayList<String> list = new ArrayList<>();
			for(int i=0;i<n;i++) {
				//�� n���� �α� ��� �Է�
				String [] str = br.readLine().split(" ");
				if(str[1].equals("enter")) {
					list.add(str[0]);
				}else {
					//��ܿ� �ִ� ����� �̸� ��
					for(int j=0;j<list.size();j++) {
						if(list.get(j).equals(str[0])) {
							list.remove(j);
							break;
						}
					}
				}
			}
			//���� ������ �̸� ��迭
			for(int i=0;i<list.size()-1;i++) {
				for(int j=i+1;j<list.size();j++) {
					if(result(list.get(i),list.get(j))) {
						String tmp = list.get(i);
						list.set(i, list.get(j));
						list.set(j, tmp);
					}
				}
			}
			//���� ���
			for(int i=0;i<list.size();i++) {
				System.out.println(list.get(i));
			}
		}
	}
}
