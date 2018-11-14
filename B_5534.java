package test_181105;

import java.util.ArrayList;
import java.util.Scanner;

//입력된 문자열과 같은 값을 가질 수 있는 간판의 개수 구하기(DFS 활용)
public class B_5534 {

	static int n;
	static boolean [] visited;
	static int answer;
	//간판 이름
	static String str;
	static String tmp_str;
	static char [] arr;
	static int cnt;
	static ArrayList<Integer> list = new ArrayList<>();
	
	public static void dfs(int start, int update, int tmp_len) {
		if(update==tmp_len) {
			boolean flag = false;
			for(int i=0;i<list.size();i++) {
				if(list.get(i)!=list.get(i+1)) {
					flag = true;
					break;
				}
			}
			if(!flag) {
				answer++;
			}
		}else {
			for(int i=1;i<str.length();i++) {
				for(int j=0;j<arr.length;j++) {
					if(!visited[j]&&str.charAt(i)==arr[j]) {
						tmp_str+=arr[j];
						visited[j]=true;
						list.add(cnt);
						cnt=0;
						dfs(j,update+1,tmp_len);
						visited[j]=false;
					}else {
						cnt++;
					}
				}
			}
		}
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		answer = 0;
		
		if(1<=n&&n<=100) {
			String tmp = sc.next();
			str = "";
			if(3<=tmp.length()&&tmp.length()<=25) {
				str=tmp;
			}
			for(int k=0;k<n;k++) {
				tmp = sc.next();
				arr = tmp.toCharArray();
				visited = new boolean[tmp.length()];
				for(int i=0;i<tmp.length();i++) {
					if(tmp.charAt(i)==str.charAt(0)) {
						visited[i]=true;
						cnt=0;
						tmp_str+=str.charAt(0);
						dfs(i,0,tmp.length());
					}
				}
			}
						
			System.out.println(answer);
		}
	}
}
