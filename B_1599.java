package test_190118;

import java.util.Scanner;

//���ĺ��� ������ �νľ�� ������ �ܾ n�� �־��� ��, �������� �����ϱ�(k�� ng�� ����)
public class B_1599 {

	//len���� �� ��� ��� ���ڰ� �Ȱ��� ���
	static boolean flag = false;
	
	//�� �ܾ��� ���� ��
	public static boolean result(String str1, String str2) {
		int len = Math.min(str1.length(), str2.length());
		
		for(int i=0;i<len;i++) {
			if(str1.charAt(i)=='k') {
				if(str2.charAt(i)!='k') {
					if(str2.charAt(i)>99) {
						return true;
					}else if(str2.charAt(i)<99) {
						return false;
					}
				}
			}else if(i+2<=len&&str1.substring(i, i+2).equals("ng")) {
				if(i+2<=len&&!str2.substring(i, i+2).equals("ng")) {
					if((float)str2.charAt(i)>100.5) {
						return true;
					}else if((float)str2.charAt(i)<100.5) {
						return false;
					}
				}else {
					i=i+1;
				}
			}else if(str2.charAt(i)=='k') {
				if(str1.charAt(i)!='k') {
					if(str1.charAt(i)>99) {
						return false;
					}else if(str1.charAt(i)<99) {
						return true;
					}
				}
			}else if(i+2<=len&&str2.substring(i, i+2).equals("ng")) {
				if(i+2<=len&&!str1.substring(i, i+2).equals("ng")) {
					if((float)str1.charAt(i)>100.5) {
						return false;
					}else if((float)str1.charAt(i)<100.5) {
						return true;
					}
				}else {
					i=i+1;
				}
			}else {
				if(str1.charAt(i)>str2.charAt(i)) {
					return false;
				}else if(str1.charAt(i)<str2.charAt(i)) {
					return true;
				}
			}
		}
		flag=true;
		return false;
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		if(1<=n&&n<=1000) {
			String [] words = new String[n];
			//�νľ�� �� �ܾ� �Է�
			for(int i=0;i<words.length;i++) {
				words[i]=sc.next();
			}
			//Ž��
			for(int i=0;i<words.length-1;i++) {
				for(int j=i+1;j<words.length;j++) {
					if(!result(words[i],words[j])) {
						if(flag) {
							//len���� ��� ���ڰ� ���� ��� ���� ��
							if(words[i].length()>words[j].length()) {
								String tmp = words[i];
								words[i]=words[j];
								words[j]=tmp;
							}
						}else{
							String tmp = words[i];
							words[i]=words[j];
							words[j]=tmp;
						}
					}
				}
			}
			//���� ���
			for(int i=0;i<words.length;i++) {
				System.out.println(words[i]);
			}
		}
	}
}
