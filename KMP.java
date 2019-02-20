package test_190220;

import java.util.Scanner;

//KMP 문자열 매칭 알고리즘
public class KMP {

	public static int [] makeTable(String pattern) {
		int patternSize = pattern.length();
		int [] table = new int[patternSize];
		int j = 0;
		for(int i=1;i<patternSize;i++) {
			while(j>0&&pattern.charAt(i)!=pattern.charAt(j)) {
				//이전 인덱스가 가르키는 곳으로 이동(다시 비교 시작)
				//ex) table[j-1] = 1 -> 0번 인덱스까지는 비교 완료(1번부터 다시 비교 시작)
				j=table[j-1];
			}
			//두 문자가 일치하면(i와 j값 증가 -> 다음 비교 대상으로 이동)
			if(pattern.charAt(i)==pattern.charAt(j)) {
				table[i]=++j;
			}
		}
		return table;
	}
	
	public static void KMP(String parent, String pattern) {
		int [] table = makeTable(pattern);
		int parentSize = parent.length();
		int patternSize = pattern.length();
		int j = 0;
		for(int i=0;i<parentSize-patternSize;i++) {
			while(j>0&&parent.charAt(i)!=pattern.charAt(j)) {
				j=table[j-1];
			}
			//두 문자가 일치하면
			if(parent.charAt(i)==pattern.charAt(j)) {
				//마지막 문자까지 모두 일치하면
				if(j==patternSize-1) {
					System.out.println(i-patternSize+2+"번째에서 패턴 문자열이 시작됩니다.");
					//접두사 길이만큼 점프(그 뒤부터 비교해서 또 다시 패턴 문자열이 나오는지 확인)
					j=table[j];
				}else {
					j++;
				}
			}
		}
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		//입력 문자열
		String paretn = sc.next();
		//패턴 문자열
		String pattern = sc.next();
	}
}
