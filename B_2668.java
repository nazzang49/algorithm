package test_190111;

import java.util.ArrayList;
import java.util.Scanner;

//1번부터 n번까지 n이하의 정수를 가르킬 때, 임의로 뽑은 특정 번호의 집합과 그 집합이 각각 가르키는 정수의 집합이 정확히 일치하는 최대 집합 구하기
public class B_2668 {

	static int n;
	static int [] num;
	static boolean [] visited;
	static ArrayList<Integer> ans = new ArrayList<>();
	
	public static void dfs(int now, ArrayList<Integer> list) {
		//회귀하는 경우(하나의 부분집합 형성)
		if(num[now]==list.get(0)) {
			for(int i=0;i<list.size();i++) {
				visited[list.get(i)]=true;
				ans.add(list.get(i));
			}
		}else {
			//자기 자신 가르키는 경우(중복 배제)
			if(num[now]==now&&!visited[now]) {
				visited[now]=true;
				ans.add(now);
			}
			//다른 정수 가르키는 경우
			else {
				//해당 정수번째 방문하지 않은 경우
				if(!visited[num[now]]) {
					list.add(num[now]);
					dfs(num[now],list);
				}
			}
		}
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		
		if(1<=n&&n<=100) {
			num = new int[n+1];
			visited = new boolean[n+1];
			ArrayList<Integer> list = new ArrayList<>();
			//정수 입력
			for(int i=1;i<=n;i++) {
				num[i]=sc.nextInt();
			}
			//탐색 실행(각 번호마다 별도 탐색)
			for(int i=1;i<=n;i++) {
				if(!visited[i]) {
					list.add(i);
					dfs(i,list);
					list.clear();
				}
			}
			System.out.println(ans.size());
			//정답 배열 오름차순 정렬
			for(int i=0;i<ans.size()-1;i++) {
				for(int j=i+1;j<ans.size();j++) {
					if(ans.get(i)>=ans.get(j)) {
						int tmp = ans.get(i);
						ans.set(i, ans.get(j));
						ans.set(j, tmp);
					}
				}
			}
			for(int i=0;i<ans.size();i++) {
				System.out.println(ans.get(i));
			}
		}
	}
}
