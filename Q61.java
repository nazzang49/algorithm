package solution;

import java.util.ArrayList;
import java.util.Scanner;

//각 회의의 시작시간과 종료시간이 주어질 때, 최대한 많은 회의를 개최하도록 하는 방법의 회의 번호를 순서대로 출력하기
public class Q61 {

	//정답이 되는 회의 번호 담을 배열
	static ArrayList<Integer> answer = new ArrayList<>();
	static boolean [] visited;
	static int [] start;
	static int [] end;
	
	public static void dfs(int num, ArrayList<Integer> tmp) {
		//직전에 회의가 끝나는 시간
		int end_bfo = end[num];
		for(int i=1;i<start.length;i++) {
			//방문하지 않았고, 시작 시간이 직전 종료 시간보다 크거나 같은 경우(=회의 가능)
			if(!visited[i]&&start[i]>=end_bfo) {
				visited[i]=true;
				tmp.add(i);
				dfs(i, tmp);
				tmp.remove(tmp.size()-1);
				visited[i]=false;
			}
		}
		
		//케이스별 가능한 모든 회의 저장이 끝난 경우
		if(tmp.size()>=answer.size()) {
			answer.clear();
			for(int i=0;i<tmp.size();i++) {
				answer.add(tmp.get(i));
			}
		}
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		//회의 개수
		int n = sc.nextInt();
		
		if(5<=n&&n<=500) {
			start = new int[n+1];
			end = new int[n+1];
			visited = new boolean[n+1];
			//각 케이스별 회의 번호 담을 배열
			ArrayList<Integer> tmp = new ArrayList<>();
			
			//입력
			for(int i=1;i<start.length;i++) {
				int tmp1 = sc.nextInt();
				int tmp2 = sc.nextInt();
				if(tmp1<=500&&tmp2<=500) {
					start[i]=tmp1;
					end[i]=tmp2;
				}
			}
			//실행
			for(int i=1;i<start.length;i++) {
				if(!visited[i]) {
					visited[i]=true;
					tmp.add(i);
					dfs(i,tmp);
					tmp.clear();
					visited[i]=false;
				}
			}
			System.out.println(answer.size());
			for(int i=0;i<answer.size();i++) {
				System.out.println(answer.get(i));
			}
		}
	}
}
