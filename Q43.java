package solution;

import java.util.Scanner;

//begin word와 target word가 주어질 때 문자열로 이루어진 배열을 활용하여 단어 변환 시 거쳐야하는 가장 최소 단계 구하기
public class Q43 {

	static boolean [] visited;
	static String [] words;
	static String begin;
	static String target;
	//변환에 걸리는 단계 중 가장 최소 단계
	static int min = Integer.MAX_VALUE;
	
	public static void dfs(int start, String now, int cnt) {
		if(now.equals(target)) {
			if(min>=cnt) {
				min=cnt;
			}
		}else {
			for(int i=start;i<words.length;i++) {
				//아직 방문하지 않은 문자열이면
				if(!visited[i]) {
					visited[i]=true;
					//begin과 배열에 담긴 문자열의 같은 문자 개수 조사할 변수
					int tmp = 0;
					for(int j=0;j<words[i].length();j++) {
						if(now.charAt(j)!=words[i].charAt(j)) {
							tmp++;
						}
					}
					//다른 문자 개수가 1개이고(변환 가능)
					if(tmp==1) {
						cnt++;
						dfs(i,words[i],cnt);
						//같은 레벨일 경우 동일한 cnt 값으로 다음 dfs가 진행되어야 하므로 cnt-- 진행 
						cnt--;
					}
					visited[i]=false;
				}
			}
		}
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		//단계별 변환이 가능하도록 주어지는 문자열 배열
		int n = sc.nextInt();
		begin = sc.next();
		target = sc.next();
		
		if(3<=n&&n<=50) {
			words = new String[n];
			visited = new boolean[n];
			//입력
			for(int i=0;i<words.length;i++) {
				String str = sc.next();
				if(3<=str.length()&&str.length()<=10) {
					words[i]=str;
				}else {
					System.out.println("입력 규칙을 확인하세요.");
					System.exit(0);
				}
			}
			//탐색 실행(DFS)
			dfs(0,begin,0);
			if(min==0) {
				System.out.println("변환불가");
				System.exit(0);
			}else {
				System.out.println(min);
			}
		}
	}
}
