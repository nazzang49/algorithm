package test_190201;

import java.util.ArrayList;
import java.util.Scanner;

//1부터 n까지의 수를 임의로 배열한 경우의 수는 n!이고, 앞쪽 인덱스부터 작은 수를 먼저 채워나갈 때, 특정 순서의 순열을 출력하거나 입력된 순열이 몇번째인지 출력하기
public class B_1722 {

	static int n;
	static int m;
	static int cnt = 0;
	static boolean [] visited;
	static int [] arr;
	
	public static void dfs(ArrayList<Integer> list) {
		if(list.size()==n) {
			m--;
			if(m==0) {
				for(int i=0;i<list.size();i++) {
					System.out.println(list.get(i));
				}
				return;
			}
		}else {
			for(int i=1;i<=n;i++) {
				if(!visited[i]) {
					visited[i]=true;
					list.add(i);
					dfs(list);
					list.remove(list.size()-1);
					visited[i]=false;
				}
			}
		}
	}
	
	public static void find(ArrayList<Integer> list) {
		if(list.size()==n) {
			cnt++;
			boolean flag = false;
			for(int i=0;i<list.size();i++) {
				if(list.get(i)!=arr[i]) {
					flag=true;
					break;
				}
			}
			if(!flag) {
				System.out.println(cnt);
				return;
			}
		}else {
			for(int i=1;i<=n;i++) {
				if(!visited[i]) {
					visited[i]=true;
					list.add(i);
					find(list);
					list.remove(list.size()-1);
					visited[i]=false;
				}
			}
		}
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		
		if(n<=20) {
			visited = new boolean[n+1];
			int k = sc.nextInt();
			//k번째 순서에 해당하는 순열 출력하기
			if(k==1) {
				//현재 몇번째 차례인지 출력할 변수
				m = sc.nextInt();
				ArrayList<Integer> list = new ArrayList<>();
				for(int i=1;i<=n;i++) {
					list.add(i);
					visited[i]=true;
					dfs(list);
					visited[i]=false;
					list.clear();
				}
			}
			//순열을 입력하고 몇번째인지 출력하기
			else {
				ArrayList<Integer> list = new ArrayList<>();
				//리스트와 비교할 입력된 순열
				arr = new int[n];
				for(int i=0;i<arr.length;i++) {
					arr[i]=sc.nextInt();
				}
				for(int i=1;i<=n;i++) {
					list.add(i);
					visited[i]=true;
					find(list);
					visited[i]=false;
					list.clear();
				}
			}
		}
	}
}
