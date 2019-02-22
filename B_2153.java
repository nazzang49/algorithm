package test_181113;

import java.util.Scanner;

//입력된 단어의 각 알파벳을 숫자로 변형하여 구한 총합이 소수인지 판별하기
public class B_2153 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		//각 문자별 변환할 숫자 저장할 배열(a-Z)
		int [] arr = new int[52];
		int sum = 0;
		
		//단어의 길이는 20자 이하
		if(str.length()<=20) {
			for(int i=0;i<arr.length;i++) {
				arr[i]=i+1;
			}
			for(int i=0;i<str.length();i++) {
				if('A'<=str.charAt(i)&&str.charAt(i)<='Z') {
					sum+=arr[26+str.charAt(i)-'A'];
				}else {
					sum+=arr[str.charAt(i)-'a'];
				}
			}
			boolean flag = false;
			for(int i=2;i<=sum/2;i++) {
				if(sum%i==0) {
					flag = true;
					break;
				}
			}
			if(!flag) {
				System.out.println("It is a prime word");
			}else {
				System.out.println("It is not a prime word");
			}
		}
	}
}
