package test_190126;

import java.util.Scanner;

//�����ΰ� ���Ѽ��� ��ʸ�Ʈ ���� ���� ��ġ�� �־��� ��, �� ���忡�� ���� ������ �Ǵ��� ����ϱ�(��� �¸��Ѵٴ� ���� ��)
public class B_1057 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		//��ʸ�Ʈ �ο� ��(Ȧ¦ ��� ����)
		int n = sc.nextInt();
		//�������� ������ġ
		int k = sc.nextInt();
		//���Ѽ��� ������ġ
		int l = sc.nextInt();
		int r = 1;
		
		if(1<=n&&n<=100000&&k<=n&&l<=n&&k!=l) {
			//���� ��ġ ���� = 1(������ ����)
			while(Math.abs(l/2-k/2)!=1) {
				if(l==1) {
					l=1;
				}else if(l%2==0) {
					l/=2;
				}else {
					l=l/2+1;
				}
				
				if(k==1) {
					k=1;
				}else if(k%2==0) {
					k/=2;
				}else {
					k=k/2+1;
				}
				r++;
			}
			System.out.println(r);
		}
	}
}
