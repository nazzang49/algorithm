package solution;

import java.util.ArrayList;
import java.util.Scanner;

//어떠한 두 이진수 코드 간에 해밍 경로가 존재할 때 가장 최소 길이의 해밍 경로 구하기(경로에 포함되는 각 코드 번호 출력)
public class Q67 {

	//최소 길이의 해밍 경로에 포함되는 코드 번호 저장
	static ArrayList<Integer> answer = new ArrayList<>();
	static boolean [] visited;
	static String [] str;
	static boolean chk = false;
	static int count = 0;
	
	//해밍 경로인지 확인해주는 메소드
	public static boolean hamming(int idx1, int idx2) {
		int cnt = 0;
		for(int i=0;i<str[0].length();i++) {
			if(str[idx1].charAt(i)==str[idx2].charAt(i)) {
				cnt++;
			}
		}
		//1개 문자만 다른 경우(해밍 경로)
		if(cnt==str[0].length()-1) {
			return true;
		}
		return false;
	}
	
	public static void dfs(int start, int end, ArrayList<Integer> list) {
		if(start==end) {
			chk=true;
			count++;
			if(count==1) {
				for(int i=0;i<list.size();i++) {
					answer.add(list.get(i));
				}
			}else {
				if(list.size()<=answer.size()) {
					answer.clear();
					for(int i=0;i<list.size();i++) {
						answer.add(list.get(i));
					}
				}
			}
		}else {
			for(int i=0;i<str.length;i++) {
				boolean flag = false;
				if(!visited[i]) {
					visited[i]=true;
					flag = hamming(start, i);
					//해밍 경로인 경우
					if(flag) {
						list.add(i);
						dfs(i,end,list);
						list.remove(list.size()-1);
					}
					visited[i]=false;
				}
			}
		}
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		if(3<=n&&n<=1000&&2<=k&&k<=30) {
			str = new String[n];
			visited = new boolean[n];
			//각 케이스별 임시 저장되는 코드 번호
			ArrayList<Integer> list = new ArrayList<>();
			//코드 입력
			for(int i=0;i<n;i++) {
				String tmp = sc.next();
				if(tmp.length()==k) {
					str[i]=tmp;
				}
			}
			//탐색 시작
			int start = sc.nextInt();
			int end = sc.nextInt();
			//출발 지점은 방문한 것으로 간주
			visited[start-1]=true;
			list.add(start-1);
			dfs(start-1,end-1, list);
			
			//경우의 수가 존재하면
			if(chk) {
				for(int i=0;i<answer.size();i++) {
					System.out.println(answer.get(i)+1);
				}
			}else {
				System.out.println(-1);
			}
		}
	}
}
