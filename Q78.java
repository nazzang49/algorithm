package solution;

import java.util.Scanner;

//������ Ư�� ���ڰ� ���� ī�带 �̾��� ��, �� ������ ���� ���� ���� ī����� �κ������� �ش� ���ڸ� ǥ���� �� �ִ��� ���ϱ�
public class Q78 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		//�׽�Ʈ ���̽� ����
		int t = sc.nextInt();
		
		if(1<=t&&t<=Math.pow(10, 3)) {
			//�� ���̽��� ���� ���� �迭
			String [] answer = new String[t];
			for(int k=0;k<t;k++) {
				int n = sc.nextInt();
				if(2<=n&&n<=Math.pow(10, 9)) {
					//Ȧ���� ������ ����
					if(n%2==1) {
						answer[k]="GAZUA";
						continue;
					}
					//¦���� Ž�� ����
					else {
						boolean flag = false;
						//�߰������� ���ҽ�Ű�鼭 Ž��
						for(int i=n/2;i>=2;i--) {
							int sum = 0;
							sum+=i;
							for(int j=i-1;j>=1;j--) {
								sum+=j;
								if(sum==n) {
									flag=true;
									answer[k]="GAZUA";
									break;
								}
								//�ʰ��ϸ� Ž�� ����
								if(sum>n) {
									break;
								}
							}
							if(flag) {
								break;
							}	
						}
						if(!flag) {
							answer[k]="GOHANGANG";
						}
					}
				}
			}
			for(int i=0;i<answer.length;i++) {
				System.out.println(answer[i]);
			}
		}
	}
}
