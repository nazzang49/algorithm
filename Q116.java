package solution;

import java.util.Scanner;

//������� ���Ǹ� �̷�� ������ ���� a,b,c�� ���� �� �Ѹ����� �ּҷ� �ϸ� �־��� ���Ǹ� �����ϴ� a,b,c ����ϱ�
public class Q116 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int [] answer = new int[3];
		
		int a = (int)Math.pow(n, 1/3f);
		boolean flag = false;
		for(int i=a;i>=1;i--) {
			//����� �Ǵ��� Ȯ��
			if(n%i==0) {
				flag=true;
				answer[0]=i;
				answer[1]=i;
				answer[2]=(int)(n/Math.pow(i, 2));
			}
			if(flag) {
				break;
			}
		}
		System.out.println(answer[0]);
		System.out.println(answer[1]);
		System.out.println(answer[2]);
	}
}
