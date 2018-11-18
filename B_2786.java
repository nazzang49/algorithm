package test_181105;

import java.util.Scanner;

//������ ��Ų ������ ���� ��ü �ݾ��� �ּҰ� ���ϱ�(DFS)
public class B_2786 {
	
	static int min_v = Integer.MAX_VALUE;
	static int sum = 0;
	static int [] answer;
	static int [] first;
	static int [] second;
	static boolean [] visited;
	static int n = 0;
	
	//ù �޴�, ù �޴��� index, �� �迭�� ������ index
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
		//2�� �̻��� �޴��� �� ��, ���� ���� ���� �迭
		visited = new boolean[n];
		int min = 0;
		
		//ó�� ��ų ���� �ƴ� ���� ������ �ٸ�
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
				//1�� �� ��, �ּҰ�
				if(i==0) {
					for(int j=0;j<n;j++) {
						if(first[j]<first[min]) {
							min=j;
						}
					}
					answer[i]=first[min];
				//2�� �̻��� �� ��, �ּҰ�(DFS - ��Ʈ��ŷ Ȱ��)
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
