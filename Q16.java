package solution;

import java.util.Scanner;

//�ٷ� �� ��ȣ Ȥ�� �� ��ȣ�� �л����Ը� ü������ ������ �� ���� ��, ��ü �л� �� ü�� ������ ���� �� �ִ� �л� �� ���ϱ�
public class Q16 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		//��ü �л� ��
		int n = sc.nextInt();
		//ü���� ���� �л� ��
		int k = sc.nextInt();
		//ü���� ���� �ִ� �л� ��
		int m = sc.nextInt();
		
		if(2<=n&&n<=30&&2<=k&&k<=n&&1<=m&&m<=n) {
			int [] chk = new int[n+1];
			for(int i=1;i<=k;i++) {
				//ü���� ����
				chk[sc.nextInt()]=1;
			}
			for(int i=1;i<=m;i++) {
				//���� �ִ�
				chk[sc.nextInt()]=2;
			}
			for(int i=1;i<chk.length;i++) {
				if(i==1) {
					if(chk[i]==2&&chk[i+1]==1) {
						chk[i+1]=0;
					}
				}else if(i==chk.length-1) {
					if(chk[i]==2&&chk[i-1]==1) {
						chk[i-1]=0;
					}
				}else {
					if(chk[i]==2&&chk[i-1]==1) {
						chk[i-1]=0;
					}else if(chk[i]==2&&chk[i+1]==1) {
						chk[i+1]=0;
					}
				}
			}
			int sum = 0;
			for(int i=1;i<chk.length;i++) {
				if(chk[i]==0||chk[i]==2) {
					sum++;
				}
			}
			System.out.println(sum);
		}
	}
}
