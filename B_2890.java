package test_190117;

import java.util.Scanner;

//9���� ī���� ��¼����� �󸶳� ������ �ִ��� ���ڷ� �־��� ��, �� ���� ��� ����ϱ�
public class B_2890 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		//1������ 9�������� ī���� ��¼��� �󸶳� ��������� ������ �迭
		int [] kayak = new int[10];
		int [] ans = new int[10];
		int max = 0;
	
		if(1<=n&&n<=50&&1<=m&&m<=50) {
			//���� ī����� ��ġ �Է�
			for(int i=0;i<n;i++) {
				String str = sc.next();
				//���ʺ��� .�� ����(�������� ��¼��� ����� ��=��� ����)
				int cnt = 0;
				for(int j=1;j<str.length();j++) {
					if(str.charAt(j)=='.') {
						cnt++;
					}
					//���ڰ� �����ϸ�(ī���� ��ȣ=��� �ε���)
					else {
						if(str.charAt(j)=='F') {
							break;
						}
						kayak[str.charAt(j)-'0']=cnt;
						if(max<=cnt) {
							max=cnt;
						}
						break;
					}
				}
			}
			int rank = 1;
			//���� ��¼��� ����� ī����� ����ο�(���� ���� �ο� ����)
			for(int i=max;i>=0;i--) {
				for(int j=1;j<kayak.length;j++) {
					if(kayak[j]==i) {
						ans[j]=rank;
					}
				}
				rank++;
			}
			//���� ���
			for(int i=1;i<ans.length;i++) {
				System.out.println(ans[i]);
			}
		}
	}
}
