package test_190114;

import java.util.Scanner;

//I�� O�� ����� �ݺ��ؼ� ������ ���ڿ��� Pn�̶�� �� ��, Ư�� ���ڿ� �� Pn�� ��� ���ԵǾ� �ִ��� ���ϴ� ���α׷� �ۼ��ϱ�
public class B_5525 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		//O�� ����(I�� ���� = n+1)
		int n = sc.nextInt();
		int m = sc.nextInt();
		//���� ���� ����
		int cnt = 0;
		
		if(1<=n&&n<=1000000&&2*n+1<=m&&m<=1000000) {
			String str = sc.next();
			//Ž�� ����
			for(int i=0;i<m-1;i++) {
				if(str.charAt(i)=='I') {
					int tmp = n+n;
					//i�� ¦���̸�(Ȧ����° �ε����� O�� ��ġ)
					if(i%2==0) {
						for(int j=i+1;j<m;j++) {
							//������ �ε����� �־���� ���ڰ� ���� ���(Pn�� �������� ���ϴ� ���)
							if((j%2==1&&str.charAt(j)!='O')
									||(j%2==0&&str.charAt(j)!='I')) {
								break;
							}
							tmp--;
							//Pn�� �����Ǵ� ���
							if(tmp==0) {
								cnt++;
								break;
							}
						}
					}
					//i�� Ȧ���̸�(¦����° �ε����� O�� ��ġ)
					else {
						for(int j=i+1;j<m;j++) {
							//������ �ε����� �־���� ���ڰ� ���� ���(Pn�� �������� ���ϴ� ���)
							if((j%2==0&&str.charAt(j)!='O')
									||(j%2==1&&str.charAt(j)!='I')) {
								break;
							}
							tmp--;
							//Pn�� �����Ǵ� ���
							if(tmp==0) {
								cnt++;
								break;
							}
						}
					}
				}
			}
			System.out.println(cnt);
		}
	}
}
