package test_190121;

import java.util.Scanner;

//������ ��� �Է��� ����� ä�� ��� ��Ģ�� ���� å���� ���� ���� ����ϱ�
public class B_3077 {

	static String [] ans;
	
	public static boolean result(String str1, String str2) {
		int idx1 = -1;
		int idx2 = -1;
		for(int i=0;i<ans.length;i++) {
			if(ans[i].equals(str1)) {
				idx1=i;
			}else if(ans[i].equals(str2)) {
				idx2=i;
			}
		}
		//���� �� �ϳ��̸�, �ð� ������ �´� ���
		if(idx1<idx2&&idx1!=-1&&idx2!=-1) {
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int cnt = 0;
		
		if(2<=n&&n<=2500) {
			ans = new String[n];
			String [] str = new String[n];
			
			//������ ����� ��� �Է�
			for(int i=0;i<ans.length;i++) {
				ans[i]=sc.next();
			}
			for(int i=0;i<str.length;i++) {
				str[i]=sc.next();
			}
			//Ž�� ����(�� ���� �ֽ� �߻����� ��)
			for(int i=0;i<str.length-1;i++) {
				for(int j=i+1;j<str.length;j++) {
					if(result(str[i],str[j])) {
						cnt++;
					}
				}
			}
			System.out.println(cnt+"/"+n*(n-1)/2);
		}
	}
}
