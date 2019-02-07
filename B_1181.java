package test_190207;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Scanner;

//n���� �ܾ �Էµ� ��, �ߺ��� �����ϰ� ���� ��, ���� ������ �ܾ� �����ϱ�
public class B_1181 {
		
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		//�ܾ��� �ִ� ���� = 20000
		if(n<=20000) {
			//�ܾ� �Է�
			HashSet<String> hs = new HashSet<>();
			for(int i=0;i<n;i++) {
				hs.add(sc.next());
			}
			String [] words = new String[hs.size()];
			hs.toArray(words);
			//���ĺ� ���� ����
			Arrays.sort(words);
			//���� ���� ����
			Arrays.sort(words,new Comparator<String>() {
				//�ܾ� ������ ���� ���� ���� �ͺ��� ū ������ ����
				@Override
				public int compare(String o1, String o2) {
					return o1.length()-o2.length();
				}
			});
			//���� ���
			for(int i=0;i<words.length;i++) System.out.println(words[i]);
			sc.close();
		}
	}
}
