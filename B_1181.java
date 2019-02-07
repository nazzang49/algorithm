package test_190207;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Scanner;

//n개의 단어가 입력될 때, 중복을 배제하고 사전 순, 길이 순으로 단어 정렬하기
public class B_1181 {
		
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		//단어의 최대 갯수 = 20000
		if(n<=20000) {
			//단어 입력
			HashSet<String> hs = new HashSet<>();
			for(int i=0;i<n;i++) {
				hs.add(sc.next());
			}
			String [] words = new String[hs.size()];
			hs.toArray(words);
			//알파벳 기준 정렬
			Arrays.sort(words);
			//길이 기준 정렬
			Arrays.sort(words,new Comparator<String>() {
				//단어 길이의 차가 가장 작은 것부터 큰 순서로 정렬
				@Override
				public int compare(String o1, String o2) {
					return o1.length()-o2.length();
				}
			});
			//정답 출력
			for(int i=0;i<words.length;i++) System.out.println(words[i]);
			sc.close();
		}
	}
}
