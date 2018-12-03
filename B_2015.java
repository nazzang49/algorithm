package test_181203;

import java.util.Scanner;

//��� ���� �迭���� �κ����� �Էµ� ������ �������� ����� �� ���ϱ�
public class B_2015 {

	static boolean [] visited;
	static int [] arr;
	//k�� �������� �κ��� ī��Ʈ ����
	static int cnt = 0;
	//�κ��� ������ ����
	static int sum = 0;
	
	//DFS Ž��
	public static void dfs(int m, int k) {
		//������ �κ����� �Է°��� �������� cnt+1
		if(sum==k) {
			cnt++;
		}else {
			for(int i=m;i<arr.length;i++) {
				if(!visited[i]) {
					visited[i]=true;
					sum+=arr[i];
					System.out.println(sum);
					dfs(i,k);
					visited[i]=false;
				}
			}	
		}
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		if(1<=n&&n<=200000&&Math.abs(k)<=2000000000) {
			arr = new int[n];
			visited = new boolean[n];
			for(int i=0;i<arr.length;i++) {
				int tmp = sc.nextInt();
				if(Math.abs(tmp)<=10000) {
					arr[i]=tmp;
				}
			}
			for(int i=0;i<n;i++) {
				if(!visited[i]) {
					visited[i]=true;
					sum+=arr[i];
					dfs(i,k);
					sum=0;
				}
			}
			System.out.println(cnt);
		}
	}
}
