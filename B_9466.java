package test_190111;

import java.util.ArrayList;
import java.util.Scanner;

//조별 과제를 위해 팀을 형성할 때 같은 팀을 이루는 규칙이 주어진다면 팀을 이루지 못하는 학생은 누구인지 번호 출력하기
public class B_9466 {

	static boolean [] visited;
	//테스트 케이스별 팀을 이루지 못하는 학생의 수
	static int cnt = 0;
	static int n;
	static int [] stu;
	
	public static void dfs(int now, ArrayList<Integer> list) {
		//자기 자신을 선택한 경우(혼자 팀 형성)
		if(now==stu[now]) {
			visited[now]=true;
		}else {
			//현재 인원이 가장 처음 지목을 시작한 인원을 선택한 경우(하나의 팀 형성)
			if(stu[now]==list.get(0)) {
				for(int i=0;i<list.size();i++) {
					visited[list.get(i)]=true;
				}
			}else {
				//이전 인원으로 다시 회귀(무한반복)하지 않는 경우에만
				if(list.size()==1||stu[now]!=list.get(list.size()-2)) {
					//명단 추가하고 재귀함수 호출
					list.add(stu[now]);
					dfs(stu[now],list);	
				}
			}
		}
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int [] ans = new int[t];
		
		int k = 0;
		while(k<t) {
			n = sc.nextInt();
			stu = new int[n+1];
			visited = new boolean[n+1];
			//각 학생마다 선택한 학생의 번호 입력(1번~n번)
			for(int i=1;i<=n;i++) {
				stu[i]=sc.nextInt();
			}
			ArrayList<Integer> list = new ArrayList<>();
			//탐색 실행
			for(int i=1;i<=n;i++) {
				if(!visited[i]) {
					list.add(i);
					dfs(i,list);
					list.clear();
				}
			}
			for(int i=1;i<=n;i++) {
				if(!visited[i]) {
					cnt++;
				}
			}
			ans[k]=cnt;
			cnt=0;
			k++;
		}
		for(int i=0;i<ans.length;i++) {
			System.out.println(ans[i]);
		}
	}
}
