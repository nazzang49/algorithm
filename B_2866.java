package test_190121;

import java.util.ArrayList;
import java.util.Scanner;

//���ڿ��� 2���� �迭�� �־��� ��, �� ������ 0��~������ ����� �������� ���ڸ� �̾� ������ �ܾ���� ���� �ߺ����� ������ ī��Ʈ �� +1 ������Ű�� 
public class B_2866 {

	public static boolean result(ArrayList<String> list) {
		for(int i=0;i<list.size()-1;i++) {
			for(int j=i+1;j<list.size();j++) {
				//������ �ܾ �ߺ��Ǵ� ���
				if(list.get(i).equals(list.get(j))) {
					return false;
				}
			}
		}
		return true;
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int r = sc.nextInt();
		int c=  sc.nextInt();
		int cnt = 0;
		
		if(2<=r&&r<=1000&&2<=c&&c<=1000) {
			String [] words = new String[r];
			//�ܾ� �Է�
			for(int i=0;i<r;i++) {
				words[i]=sc.next();
			}
			ArrayList<String> list = new ArrayList<>();
			//Ž�� ����
			for(int i=1;i<words.length;i++) {
				int idx = 0;
				while(idx<c) {
					String tmp = "";
					int count = i;
					while(count<words.length) {
						tmp+=words[count].charAt(idx);
						count++;
					}
					//������ �ܾ� ����
					list.add(tmp);
					//���� ���� �̵�
					idx++;
				}
				//�ߺ����� �ʴ� ���
				if(result(list)) {
					cnt++;
				}
				list.clear();
			}
			System.out.println(cnt);
		}
	}
}
