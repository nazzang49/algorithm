package solution;

import java.util.Scanner;

//��ʸ�Ʈ ��ȸ���� Ư�� ��ȣ�� �ο��޴� �� ���� �����ڰ� �� ���忡�� ������ �Ǵ��� ���ϱ�
public class Q41 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int k = sc.nextInt();
		
		if(n%2==0&&Math.pow(2, 1)<=n&&n<=Math.pow(2, 20)&&m<=n&&k<=n) {
			int cnt=1;
			while(true) {
				if(Math.abs(m-k)==1) {
					break;
				}
				cnt++;
				if(m<=2) {
					m=1;
				}else {
					if(m%2==0) {
						m=m/2;
					}else {
						m=m/2+1;
					}
				}
				if(k<=2) {
					k=1;
				}else {
					if(k%2==0) {
						k=k/2;
					}else {
						k=k/2+1;
					}	
				}
			}
			System.out.println(cnt);
		}
	}
}
