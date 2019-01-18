package test_190118;

import java.util.Scanner;

//알파벳이 변형된 민식어로 구성된 단어가 n개 주어질 때, 오름차순 정렬하기(k와 ng만 주의)
public class B_1599 {

	//len까지 비교 결과 모든 문자가 똑같은 경우
	static boolean flag = false;
	
	//두 단어의 순서 비교
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
			//민식어로 된 단어 입력
			for(int i=0;i<words.length;i++) {
				words[i]=sc.next();
			}
			//탐색
			for(int i=0;i<words.length-1;i++) {
				for(int j=i+1;j<words.length;j++) {
					if(!result(words[i],words[j])) {
						if(flag) {
							//len까지 모든 문자가 같은 경우 길이 비교
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
			//정답 출력
			for(int i=0;i<words.length;i++) {
				System.out.println(words[i]);
			}
		}
	}
}
