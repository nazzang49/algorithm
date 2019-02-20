package test_190220;

import java.util.Scanner;

//KMP ���ڿ� ��Ī �˰���
public class KMP {

	public static int [] makeTable(String pattern) {
		int patternSize = pattern.length();
		int [] table = new int[patternSize];
		int j = 0;
		for(int i=1;i<patternSize;i++) {
			while(j>0&&pattern.charAt(i)!=pattern.charAt(j)) {
				//���� �ε����� ����Ű�� ������ �̵�(�ٽ� �� ����)
				//ex) table[j-1] = 1 -> 0�� �ε��������� �� �Ϸ�(1������ �ٽ� �� ����)
				j=table[j-1];
			}
			//�� ���ڰ� ��ġ�ϸ�(i�� j�� ���� -> ���� �� ������� �̵�)
			if(pattern.charAt(i)==pattern.charAt(j)) {
				table[i]=++j;
			}
		}
		return table;
	}
	
	public static void KMP(String parent, String pattern) {
		int [] table = makeTable(pattern);
		int parentSize = parent.length();
		int patternSize = pattern.length();
		int j = 0;
		for(int i=0;i<parentSize-patternSize;i++) {
			while(j>0&&parent.charAt(i)!=pattern.charAt(j)) {
				j=table[j-1];
			}
			//�� ���ڰ� ��ġ�ϸ�
			if(parent.charAt(i)==pattern.charAt(j)) {
				//������ ���ڱ��� ��� ��ġ�ϸ�
				if(j==patternSize-1) {
					System.out.println(i-patternSize+2+"��°���� ���� ���ڿ��� ���۵˴ϴ�.");
					//���λ� ���̸�ŭ ����(�� �ں��� ���ؼ� �� �ٽ� ���� ���ڿ��� �������� Ȯ��)
					j=table[j];
				}else {
					j++;
				}
			}
		}
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		//�Է� ���ڿ�
		String paretn = sc.next();
		//���� ���ڿ�
		String pattern = sc.next();
	}
}
