package test_190220;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

//�Է� ���ڿ��� ã���� �ϴ� ���ڿ��� �־��� ��, �Է� ���ڿ��� ��� �ε������� ã���� �ϴ� ���ڿ��� �����ϴ��� ��� ����ϱ�
public class B_1786 {

	//���� ��� �迭
	static ArrayList<Integer> ans = new ArrayList<>();
	
	public static int [] makeTable(String pattern) {
		int patternSize = pattern.length();
		int [] table = new int[patternSize];
		int j = 0;
		for(int i=1;i<patternSize;i++) {
			while(j>0&&pattern.charAt(i)!=pattern.charAt(j)) {
				j=table[j-1];
			}
			//�� ���ڰ� ��ġ�ϸ�
			if(pattern.charAt(i)==pattern.charAt(j)) {
				table[i]=++j;
			}
		}
		return table;
	}
	
	public static void KMP(String parent, String pattern) {
		int parentSize = parent.length();
		int patternSize = pattern.length();
		int [] table = makeTable(pattern);
		int j = 0;
		for(int i=0;i<parentSize;i++) {
			while(j>0&&parent.charAt(i)!=pattern.charAt(j)) {
				j=table[j-1];
			}
			//�� ���ڰ� ��ġ�ϸ�
			if(parent.charAt(i)==pattern.charAt(j)) {
				if(j==patternSize-1) {
					ans.add(i-patternSize+2);
					//���� ���� �ε����� ����(���λ�� �� ���ص� ��)
					j=table[j];
				}else {
					j++;
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String T = br.readLine();
		String P = br.readLine();
		
		if(T.length()<=1000000&&P.length()<=1000000) {
			KMP(T, P);
			System.out.println(ans.size());
			for(int i=0;i<ans.size();i++) {
				System.out.println(ans.get(i));
			}
		}
	}
}
