package test_190116;

import java.util.Scanner;

//ī�̻縣 ��ȣ(���� ���ڸ� +3�� ���� ���ڷ� �ٲٴ� ����)�� ��ȯ�� ���ڿ��� �Էµ� �� ���� ���ڷ� �纯ȯ �ϴ� ���α׷� �ۼ��ϱ�
public class B_5598 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		
		//�ԷµǴ� ���ڿ��� �ִ���̴� 1000
		if(1<=str.length()&&str.length()<=1000) {
			//���� ���ڷ� ���� �� �迭 ����
			char [] arr = str.toCharArray();
			for(int i=0;i<arr.length;i++) {
				//3ĭ �̵��� �ڸ��� �����̸�(���ĺ� ���� �����)
				if(arr[i]-'A'-3<0) {
					arr[i]=(char)(arr[i]-3+26);
					continue;
				}
				arr[i]=(char)(arr[i]-3);
			}
			System.out.println(new String(arr));
		}
	}
}
