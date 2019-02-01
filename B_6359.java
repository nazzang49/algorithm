package test_190201;

import java.util.Scanner;

//�Ϸķ� �þ n���� �������� ��Ģ�� ���� ���� ����� Ż���� �� �ִ��� ����ϱ�
public class B_6359 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		if(t<=1000) {
			int k = 0;
			int [] ans = new int[t];
			while(k<t) {
				//�� ������ ����
				int n = sc.nextInt();
				boolean [] visited = new boolean[n+1];
				//�������� = false, �������� = true
				for(int i=2;i<=n;i++) {
					for(int j=1;j*i<=n;j++) {
						if(!visited[i*j]) visited[i*j]=true;
						else visited[i*j]=false;
					}
				}
				//1������ ������ ���� �����Ƿ�
				int cnt = 1;
				for(int i=2;i<=n;i++) {
					if(!visited[i]) {
						cnt++;
					}
				}
				ans[k]=cnt;
				k++;
			}
			for(int i=0;i<ans.length;i++) {
				System.out.println(ans[i]);
			}
		}
	}
}
