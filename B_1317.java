package test_190121;

import java.util.ArrayList;
import java.util.Scanner;

//인접한 인덱스에서 같은 문자가 반복해서 출현하는 그룹 단어를 n개의 조각으로 분해한 경우, 조각난 단어를 보고 최초 문자열 출력하기
public class B_1317 {

	static boolean [] visited;
	static String [] words;
	static ArrayList<String> ans = new ArrayList<>();
	
	public static boolean result(String str) {
		int [] alpha = new int[26];
		alpha[str.charAt(0)-'a']++;
		for(int i=1;i<str.length();i++) {
			//이미 등장한 적이 있는데 이전 문자가 현재 문자와 같지 않다면(그룹단어 X)
			if(alpha[str.charAt(i)-'a']!=0&&str.charAt(i-1)!=str.charAt(i)) {
				return false;
			}
		}
		return true;
	}
	
	//모든 조합의 경우의 수 실행
	public static void dfs(int count, String str) {
		//모든 단어를 조합한 경우
		if(count==words.length) {
			if(!ans.isEmpty()) {
				System.out.println("하나의 답을 출력할 수 없습니다.");
				System.exit(0);
			}
			ans.add(str);
		}else {
			String tmp = str;
			count++;
			for(int i=0;i<words.length;i++) {
				str+=words[i];
				//사용하지 않았고, 계속해서 그룹단어 형태가 유지되는 경우
				if(!visited[i]&&result(str)) {
					visited[i]=true;
					dfs(count,str);
					visited[i]=false;
				}
				//다시 초기화
				str=tmp;
			}
		}
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		if(1<=n&&n<=100) {
			//n개의 조각난 단어 입력
			words = new String[n];
			visited = new boolean[n];
			for(int i=0;i<n;i++) {
				words[i]=sc.next();
			}
			//탐색 실행
			for(int i=0;i<n;i++) {
				visited[i]=true;
				dfs(1, words[i]);
				//백트래킹
				visited[i]=false;
			}
			if(!ans.isEmpty()) {
				System.out.println(ans.get(0));	
			}else {
				System.out.println("조건에 맞는 단어를 조합할 수 없습니다.");
			}
		}
	}
}
