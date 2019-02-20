package test_190220;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

//입력 문자열과 찾고자 하는 문자열이 주어질 때, 입력 문자열의 어느 인덱스부터 찾고자 하는 문자열이 존재하는지 모두 출력하기
public class B_1786 {

	//정답 출력 배열
	static ArrayList<Integer> ans = new ArrayList<>();
	
	public static int [] makeTable(String pattern) {
		int patternSize = pattern.length();
		int [] table = new int[patternSize];
		int j = 0;
		for(int i=1;i<patternSize;i++) {
			while(j>0&&pattern.charAt(i)!=pattern.charAt(j)) {
				j=table[j-1];
			}
			//두 문자가 일치하면
			if(pattern.charAt(i)==pattern.charAt(j)) {
				table[i]=++j;
			}
		}
		return table;
	}
	
	public static void KMP(String parent, String pattern) {
		int parentSize = parent.length();
		int patternSize = pattern.length();
		int [] table = makeTable(pattern);
		int j = 0;
		for(int i=0;i<parentSize;i++) {
			while(j>0&&parent.charAt(i)!=pattern.charAt(j)) {
				j=table[j-1];
			}
			//두 문자가 일치하면
			if(parent.charAt(i)==pattern.charAt(j)) {
				if(j==patternSize-1) {
					ans.add(i-patternSize+2);
					//다음 비교할 인덱스로 점프(접두사는 비교 안해도 됨)
					j=table[j];
				}else {
					j++;
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String T = br.readLine();
		String P = br.readLine();
		
		if(T.length()<=1000000&&P.length()<=1000000) {
			KMP(T, P);
			System.out.println(ans.size());
			for(int i=0;i<ans.size();i++) {
				System.out.println(ans.get(i));
			}
		}
	}
}
