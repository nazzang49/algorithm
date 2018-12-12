package solution;

import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.plaf.synth.SynthSeparatorUI;

//한 사람이 입을 수 있는 옷의 이름과 종류가 2차원 배열로 주어질 때, 종류의 중복 없이 착장 가능한 조합의 수 구하기
public class Q38 {

	//모든 조합의 수
	static int cnt = 0;
	static boolean [] visited;
	static String [][] clothes;
	
	public static void dfs(int start, int count, ArrayList<String> list) {
		//마지막 가능한 조합까지 끝난 경우
		for(int i=start;i<clothes.length;i++) {
			if(!visited[i]) {
				boolean flag = false;
				visited[i]=true;
				for(int j=0;j<list.size();j++) {
					//중복되는 경우가 발생하면
					if(clothes[i][1].equals(list.get(j))) {
						flag = true;
						break;
					}
				}
				//중복되지 않는 새로운 종류이면(조합 가능+1, list에 추가)
				if(!flag) {
					list.add(clothes[i][1]);	
					cnt++;
					dfs(i,count+1,list);
					list.remove(list.size()-1);
				}
				visited[i]=false;
			}
		}
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		if(1<=n&&n<=30) {
			clothes = new String[n][2];
			visited = new boolean[n];
			ArrayList<String> list = new ArrayList<>();
			//입력
			for(int i=0;i<n;i++) {
				String tmp1 = sc.next();
				String tmp2 = sc.next();
				if(1<=tmp1.length()&&tmp1.length()<=20&&1<=tmp2.length()&&tmp2.length()<=20) {
					clothes[i][0]=tmp1;
					clothes[i][1]=tmp2;
				}
			}
			//탐색
			for(int i=0;i<clothes.length;i++) {
				if(!visited[i]) {
					visited[i]=true;
					//한가지 종류의 옷만 입는 경우
					cnt++;
					list.add(clothes[i][1]);
					dfs(i,1,list);
					list.clear();
					visited[i]=false;
				}
			}
			System.out.println(cnt);
		}
	}
}
