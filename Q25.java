package solution;

import java.util.Scanner;

//��ȣ ���ڿ��� ��(���� �ݴ�)���� ǥ���� �� �ִ� �ùٸ� ���ڿ� ���� ���ϱ�
public class Q25 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		//�ԷµǴ� ��ȣ ���� ����
		int n = sc.nextInt();
		
		if(1<=n&&n<=14) {
			int [] answer = new int[n+1];
			answer[1]=1;
			answer[2]=2;
			answer[3]=5;
			for(int i=4;i<=n;i++) {
				//�տ������� ���� ��ȣ�� ������ ����
				for(int j=1;j<i;j++) {
					answer[i]+=j*answer[i-j];
				}
				answer[i]++;
			}
			System.out.println(answer[n]);
		}
	}
}
