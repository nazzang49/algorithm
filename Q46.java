package solution;

import java.util.Arrays;
import java.util.Scanner;

//���� ���԰� ����ִ� �迭�� �־��� �� �ش� �ߵ��� �������� ������ �� ���� ������ �ּҰ� ���ϱ�
public class Q46 {

	static boolean [] visited;
	static int [] arr;
	static int cnt = 0;
	
	public static void dfs(int start, int sum, int target) {
		//�ߵ��� �κ������� Ÿ�� ���� ���� �����ϸ�
		if(sum==target) {
			cnt++;
		}else if(sum<target) {
			for(int i=start;i<visited.length;i++) {
				if(!visited[i]) {
					visited[i]=true;
					sum+=arr[i];
					dfs(i,sum,target);
					sum-=arr[i];
					visited[i]=false;
				}
			}
		}
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		if(1<=n&&n<=10000) {
			visited = new boolean[n];
			arr = new int[n];
			//�� ���� �Է�
			for(int i=0;i<n;i++) {
				arr[i]=sc.nextInt();
			}
			//����(�������� ����)
			Arrays.sort(arr);
			int i=0;
			int tmp = 0;
			while(i<n) {
				visited[i]=true;
				dfs(i,arr[i],tmp+1);
				//���� ���� �������� ǥ�� ������ ���̸�
				if(cnt!=0) {
					tmp++;
					cnt=0;
					i=0;
					visited[i]=false;
					continue;
				}
				visited[i]=false;
				i++;
			}
			System.out.println(tmp+1);
		}
	}
}
