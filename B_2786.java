package test_181105;

import java.util.Scanner;

//음식을 시킨 개수에 따라 전체 금액의 최소값 구하기(DFS)
public class B_2786 {
	
	static int min_v = Integer.MAX_VALUE;
	static int sum = 0;
	static int [] answer;
	static int [] first;
	static int [] second;
	static boolean [] visited;
	static int n = 0;
	
	//첫 메뉴, 첫 메뉴의 index, 답 배열에 저장할 index
	public static void dfs(int update, int answer_idx) {
		if(update==answer_idx) {
			if(sum<min_v) {
				min_v=sum;
			}
		}else {
			for(int i=0;i<n;i++) {
				if(!visited[i]) {
					sum+=second[i];
					visited[i]=true;
					dfs(update+1,answer_idx);
					visited[i]=false;
				}
			}	
		}
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		first = new int[n];
		second = new int[n];
		answer = new int[n];
		//2개 이상의 메뉴를 고를 때, 선택 여부 조건 배열
		visited = new boolean[n];
		int min = 0;
		
		//처음 시킬 때와 아닐 때의 가격이 다름
		if(2<=n&&n<=500000) {
			for(int i=0;i<n;i++) {
				int tmp1 = sc.nextInt();
				int tmp2 = sc.nextInt();
				if(1<=tmp1&&tmp1<=1000000000&&1<=tmp2&&tmp2<=1000000000) {
					first[i]=tmp1;
					second[i]=tmp2;
				}
			}
			System.out.println(n);
			for(int i=0;i<n;i++) {
				//1개 고를 때, 최소값
				if(i==0) {
					for(int j=0;j<n;j++) {
						if(first[j]<first[min]) {
							min=j;
						}
					}
					answer[i]=first[min];
				//2개 이상을 고를 때, 최소값(DFS - 백트래킹 활용)
				}else {
					min_v=Integer.MAX_VALUE;
					for(int j=0;j<n;j++) {
						sum=0;
						sum+=first[j];
						visited[j]=true;
						dfs(0,i);
						visited[j]=false;
					}
					answer[i]=min_v;
				}
			}
			for(int i=0;i<answer.length;i++) {
				System.out.println(answer[i]);
			}
		}
	}
}
