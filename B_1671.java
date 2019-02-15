package test_190215;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

//����� �� n, �� ����� ũ��, �ӵ�, ������ �־��� ��, ��Ģ�� ���� ���������� ��Ƴ��� �� �ִ� ����� ������ �ּҰ� ����ϱ�(�ִ� �θ��� ��� ����)
public class B_1671 {

	static int n;
	static int min = 0;
	static boolean [] visit;
	//d�� �ε��� = ��ƸԴ� ���, d�� �� = ��Ƹ����� ���
	static int [] d;
	//Ư�� ���� ��Ƹ��� �� �ִ� �� �������� ����
	static ArrayList<Integer> [] A;
	//ũ��, �ӵ�, ���� �Է��� �迭
	static int [][] arr;
	
	public static boolean dfs(int cur) {
		if(visit[cur]) return false;
		visit[cur]=true;
		for(int i=0;i<A[cur].size();i++) {
			//cur �� ��� ���� �� �ִ� ��� = x
			int x = A[cur].get(i);
			if(d[x]==0||dfs(d[x])) {
				d[x]=cur;
				return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		
		if(n<=50) {
			A = new ArrayList[n+1];
			visit = new boolean[n+1];
			d = new int[n+1];
			arr = new int[n+1][3];
			
			for(int i=1;i<=n;i++) {
				A[i]=new ArrayList<>();
			}
			
			//��� ���� �Է�
			for(int i=1;i<=n;i++) {
				arr[i][0]=sc.nextInt();
				arr[i][1]=sc.nextInt();
				arr[i][2]=sc.nextInt();
			}
			
			//�� ������ ���� ��(��ƸԴ� �� - ��, ��Ƹ����� �� - ��)
			for(int i=1;i<=n;i++) {
				for(int j=i+1;j<=n;j++) {
					if(arr[i][0]>=arr[j][0]&&arr[i][1]>=arr[j][1]&&arr[i][2]>=arr[j][2]) {
						A[i].add(j);
					}else if(arr[j][0]>=arr[i][0]&&arr[j][1]>=arr[i][1]&&arr[j][2]>=arr[i][2]) {
						A[j].add(i);
					}
				}
			}
			
			//DFS Ž�� ����(�̺и�Ī - Ž�� �ι� ���� = �θ������� ���� �� �ֱ� ����)
			for(int i=1;i<=n;i++) {
				Arrays.fill(visit, false);
				//��� ���� �� �ִ� �� ������(�״� ��� ��+1)
				if(dfs(i)) min++;
				Arrays.fill(visit, false);
				if(dfs(i)) min++;
			}
			System.out.println(n-min);
		}
	}
}
