package test_190117;

import java.util.Scanner;

//���ν��� �������� ���� �� ����ϴ� ���ڸ� �����ϱ� ���� l,o,v,e�� �̸��� �����ϴ� Ƚ���� Ȱ���Ͽ� ��Ģ�� ���� ������ �ο��� �� ���� �����ϰ� �Ǵ� ������ �̸� ����ϱ�
public class B_1296 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		//ȣ��Ʈ�� ���ν�
		String host = "OHMINSIK";
		//���� ���� ���� ����
		int max = 0;
		//�������� ����� �̸�
		String ans = "";
		
		if(1<=n&&n<=50) {
			for(int i=0;i<n;i++) {
				//�̸� �Է�
				String str = sc.next();
				int l = 0;
				int o = 0;
				int v = 0;
				int e = 0;
				//���ν��� �̸��� �ִ� love ���ĺ� ���� ����
				for(int j=0;j<host.length();j++) {
					if(host.charAt(j)=='L') {
						l++;
					}else if(host.charAt(j)=='O') {
						o++;
					}else if(host.charAt(j)=='V') {
						v++;
					}else if(host.charAt(j)=='E') {
						e++;
					}
				}
				//���� �Էµ� �������� �̸��� �ִ� love ���ĺ� ���� ����
				for(int j=0;j<str.length();j++) {
					if(str.charAt(j)=='L') {
						l++;
					}else if(str.charAt(j)=='O') {
						o++;
					}else if(str.charAt(j)=='V') {
						v++;
					}else if(str.charAt(j)=='E') {
						e++;
					}
				}
				//�̸��� �Էµ� ������ �ش� �������� ���� ��
				int sum = ((l+o)*(l+v)*(l+e)*(o+v)*(o+e)*(v+e))%100;
				if(max<=sum) {
					if(max==sum&&ans.length()!=0) {
						//���� ���� ���ĺ� ���� ��
						if(ans.length()<=str.length()) {
							for(int j=0;j<ans.length();j++) {
								//���� ��ġ���� ���ĺ� ������ ������
								if(ans.charAt(j)>str.charAt(j)) {
									ans = str;
									break;
								}else if(ans.charAt(j)<str.charAt(j)) {
									break;
								}
							}
						}
					}else {
						max = sum;
						ans = str;
					}
				}
			}
			System.out.println(ans);
		}
	}
}
