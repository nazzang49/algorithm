package test_190114;

import java.util.Scanner;

//전화기 다이얼을 문자로 기억해서 선택할 때, 모든 다이얼을 누르는데 걸리는 시간의 총합 구하기
public class B_5622 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		
		//문자열의 길이는 2~15
		if(2<=str.length()&&str.length()<=15) {
			int sum = 0;
			for(int i=0;i<str.length();i++) {
				int tmp = str.charAt(i)-'A';
				//몇번 다이얼에 위치하는지 탐색
				for(int j=2;j<=9;j++) {
					System.out.println(sum);
					if(j==2||j==3||j==4||j==5||j==6||j==8) {
						tmp-=3;
						if(tmp<=0) {
							sum+=j;
							break;
						}
					}else if(j==7||j==9) {
						tmp-=4;
						if(tmp<=0) {
							sum+=j;
							break;
						}
					}
				}
			}
			sum+=str.length();
			System.out.println(sum);
		}
	}
}
