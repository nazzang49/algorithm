package test_190325;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

//l개의 문자가 주어질 때, c개의 문자를 골라 조합 가능한 모든 암호 출력하기(최소 1개 모음 포함)
public class B_1759 {

	static int c;
	static int l;
	static boolean [] v;
	static char [] arr;
	
	public static void dfs(int cur, ArrayList<Character> list) {
		if(list.size()==c) {
			boolean flag = false;
			for(int i=0;i<list.size();i++) {
				char tmp = list.get(i);
				if(tmp=='a'||tmp=='i'||tmp=='o'||tmp=='u'||tmp=='e') {
					flag=true;
					break;
				}
			}
			//모음 한개 이상일때만 출력
			if(flag) {
				//출력
				for(int i=0;i<list.size();i++) {
					System.out.print(list.get(i));
				}
				System.out.println("");
			}
			return;
		}
		for(int i=cur+1;i<l;i++) {
			if(!v[i]) {
				v[i]=true;
				list.add(arr[i]);
				dfs(i,list);
				//백트래킹
				list.remove(list.size()-1);
				v[i]=false;
			}
		}
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		c = sc.nextInt();
		l = sc.nextInt();
		
		if(3<=c&&c<=l&&l<=15) {
			//문자 입력
			String tmp = "";
			for(int i=0;i<l;i++) {
				tmp+=sc.next();
			}
			v = new boolean[l];
			ArrayList<Character> list = new ArrayList<>();
			arr = tmp.toCharArray();
			//사전순으로 정렬
			Arrays.sort(arr);
			//DFS 탐색
			for(int i=0;i<arr.length;i++) {
				v[i]=true;
				list.add(arr[i]);
				dfs(i,list);
				list.remove(list.size()-1);
				v[i]=false;
			}
		}	
	}
}
