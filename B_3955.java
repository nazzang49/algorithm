package test_181115;

import java.util.Scanner;

//�����ο��� �� ���� �ȿ� �� ���� ������ �־��� ��, �����ؾ� �� ���� ���� ���� ���ϱ�
public class B_3955 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		long [] answer = new long[t];
		
		int k=0;
		while(k<t) {
			long n = sc.nextInt();
			long m = sc.nextInt();
			if(1<=n&&n<=Math.pow(10, 9)&&1<=m&&m<=Math.pow(10, 9)
					&&0<t&&t<100) {
				//��Ƽ �ο��� �� ���� �� ������ ��������� ���
				if(n%m==0) {
					System.out.println("���´�");
					answer[k]=0;
					continue;
				}
				//��Ƽ �ο��� �� ���� �� ������ ������谡 �ƴ� ���
				else {
					for(long i=1;i<=Math.pow(10, 9);i++) {
						if((n*i+1)%m==0) {
							long tmp = (n*i+1)/m;
							answer[k]=tmp;
							break;
						}
					}	
				}
			}
			k++;
		}
		for(int i=0;i<answer.length;i++) {
			if(answer[i]==0) {
				System.out.println("IMPOSSIBLE");
			}else {
				System.out.println(answer[i]);	
			}
		}
	}
}
