package test_190114;

import java.util.Scanner;

//��ȭ�� ���̾��� ���ڷ� ����ؼ� ������ ��, ��� ���̾��� �����µ� �ɸ��� �ð��� ���� ���ϱ�
public class B_5622 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		
		//���ڿ��� ���̴� 2~15
		if(2<=str.length()&&str.length()<=15) {
			int sum = 0;
			for(int i=0;i<str.length();i++) {
				int tmp = str.charAt(i)-'A';
				//��� ���̾� ��ġ�ϴ��� Ž��
				for(int j=2;j<=9;j++) {
					System.out.println(sum);
					if(j==2||j==3||j==4||j==5||j==6||j==8) {
						tmp-=3;
						if(tmp<=0) {
							sum+=j;
							break;
						}
					}else if(j==7||j==9) {
						tmp-=4;
						if(tmp<=0) {
							sum+=j;
							break;
						}
					}
				}
			}
			sum+=str.length();
			System.out.println(sum);
		}
	}
}
