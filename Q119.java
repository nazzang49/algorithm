package solution;

import java.util.Scanner;

//�ֱ� ������ �ּ� �ֱⰪ ����ϱ�
public class Q119 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n1 = sc.nextInt();
		int n2 = sc.nextInt();
		int n3 = sc.nextInt();
		int n4 = sc.nextInt();
		
		int min = Integer.MAX_VALUE;
		
		if(1<=n1&&n1<=100&&2<=n2&&n2<=100&&2<=n3&&n3<=100&&5<=n4&&n4<=100&&n1<n4) {
			int [] S = new int[1001];
			S[0]=n1;
			//�Է�
			for(int i=1;i<S.length;i++) {
				S[i]=(n2*S[i-1]+n3)%n4;
			}
			//Ž��
			for(int i=0;i<S.length-1;i++) {
				int cnt = 1;
				for(int j=i+1;j<S.length;j++) {
					//���� ���ڰ� ������ �ϳ��� �ֱ� ����
					if(S[i]==S[j]) {
						break;
					}
					cnt++;
				}
				if(min>cnt) {
					min=cnt;
				}
				//���ο� �ֱⰪ = ���� �ֱⰪ (���� ��� �ݺ��ȴٴ� �ǹ�)
				else if(min==cnt) {
					break;
				}
			}
			System.out.println(min);
		}
	}
}
