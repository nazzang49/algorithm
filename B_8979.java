package test_190218;

import java.util.Scanner;

//�ø��ȿ� ������ n�� ������ �� �ݸ޴�, ���޴�, ���޴� ȹ�� ������ �Էµ� �� Ư�� ������ ���� ������
public class B_8979 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		if(n<=1000&&n<=1000) {
			int [] g = new int[n+1];
			int [] s = new int[n+1];
			int [] b = new int[n+1];
		
			//�޴� �Է�
			for(int i=1;i<=n;i++) {
				int tmp = sc.nextInt();
				g[tmp]=sc.nextInt();
				s[tmp]=sc.nextInt();
				b[tmp]=sc.nextInt();
			}
			
			int [] ans = new int[n+1];
			//��� 1������ �ʱ�ȭ
			for(int i=1;i<=n;i++) {
				ans[i]=1;
			}
			//Ž�� ����
			for(int i=1;i<=n;i++) {
				for(int j=1;j<=n&&i!=j;j++) {
					//�ݸ޴� ���� ������
					if(g[i]<g[j]) {
						ans[i]++;
						continue;
					}
					//�ݸ޴� ���� ������(���޴� ��)
					else if(g[i]==g[j]) {
						//���޴� ���� ������
						if(s[i]<s[j]) {
							ans[i]++;
							continue;
						}
						//���޴� ���� ������(���޴� ��)
						else if(s[i]==s[j]) {
							//���޴� ���� ������
							if(b[i]<b[j]) {
								ans[i]++;
								continue;
							}
						}
					}
				}
			}
			System.out.println(ans[k]);
		}else System.out.println("�Է� ������ Ȯ���ϼ���.");
	}
}
