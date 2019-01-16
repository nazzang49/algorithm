package test_190116;

import java.util.Scanner;

//카이사르 암호(기존 문자를 +3한 곳의 문자로 바꾸는 패턴)로 변환된 문자열이 입력될 때 기존 문자로 재변환 하는 프로그램 작성하기
public class B_5598 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		
		//입력되는 문자열의 최대길이는 1000
		if(1<=str.length()&&str.length()<=1000) {
			//개별 문자로 분해 후 배열 저장
			char [] arr = str.toCharArray();
			for(int i=0;i<arr.length;i++) {
				//3칸 이동한 자리가 음수이면(알파벳 범위 벗어나면)
				if(arr[i]-'A'-3<0) {
					arr[i]=(char)(arr[i]-3+26);
					continue;
				}
				arr[i]=(char)(arr[i]-3);
			}
			System.out.println(new String(arr));
		}
	}
}
