package test_181109;

import java.util.Scanner;

//�߾� �̵� �˰��� ���� ���ο� ����Ʈ�� ������ ��, �ߺ��� �����ϰ� ���� ���� ���� ���� ���ϱ�
//������ ��Ģ�� ã�� ����
public class B_2903 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		//Ư�� �ܰ�
		int n = sc.nextInt();
		int [] point = new int[n+1];
		
		if(1<=n&&n<=15) {
			//Ư�� �ܰ迡���� ��� ����Ʈ ���� = ���� ���� ����Ʈ ����+���� �ܰ��� ����Ʈ ����
			point[0]=4;
			
			for(int i=1;i<=n;i++) {
				point[i]=(int)Math.pow(Math.pow(2, i)+1,2);
			}
			System.out.println(point[n]);
		}
		
	}

}
