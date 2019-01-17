package test_190117;

import java.util.Scanner;

//���ڿ��� 1~nĭ�� �����ų� ������ ���� ��, ���������� ���� ������ ���� �տ� ��ġ �ϴ� ���ڿ� ����ϱ�
public class B_1464 {

	static int n;
	static String ans = "";
	
	//�����ų� ������ �ʴ� �ΰ��� ��� ����
	public static void dfs(int count, String str) {
		if(count==n-1) {
			//ans�� str�� ���ĺ� ���� ��
			for(int i=0;i<ans.length();i++) {
				if(ans.charAt(i)<str.charAt(i)) {
					break;
				}else if(ans.charAt(i)>str.charAt(i)) {
					ans=str;
					break;
				}
			}
		}else {
			count++;
			//������ �ʴ� ���
			dfs(count,str);
			char [] arr = str.toCharArray();
			//�ڸ� �ٲٱ�
			for(int i=0;i<=count/2;i++) {
				char tmp = arr[i];
				arr[i]=arr[count-i];
				arr[count-i]=tmp;
			}
			dfs(count,new String(arr));
		}
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		
		if(str.length()<=10000) {
			n=str.length();
			ans=str;
			dfs(0,str);
			System.out.println(ans);
		}
	}
}
