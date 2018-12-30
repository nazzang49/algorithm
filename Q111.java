package solution1;

import java.util.ArrayList;
import java.util.Scanner;

class Gooseul {
	int start, speed;
	
	public Gooseul(int start, int speed) {
		this.start=start;
		this.speed=speed;
	}
}

//x���� �����ϰ� �޸��� n���� �������� ������ �ӵ��� ������ ��, n+1���� ������ ���� ������ Ȱ���Ͽ� ������ ���� �ӵ� ���ϱ�
public class Q111 {

	static int start = 0;
	static int sub = 0;
	static boolean flag = false;
	static int [][] x;
	static boolean [][] visited;
	static ArrayList<Gooseul> answer;
	
	public static void dfs(int before, int count) {
		//n+1�� �ݺ��ϰ� �Ǹ�(������ ���̰��� ������ ��찡 �ִٸ�)
		if(count==x.length-1) {
			flag = true;
			answer.add(new Gooseul(start, sub));
		}else if(count<x.length-1) {
			count++;
			for(int i=0;i<x.length-1;i++) {
				//���� �ٿ� �湮���� ���� ������ �ִٸ�
				if(!visited[count][i]) {
					visited[count][i]=true;
					//���� ���̰��� ������
					if(x[count][i]-before==sub) {
						dfs(x[count][i], count);
					}
					//��Ʈ��ŷ
					visited[count][i]=false;
				}
			}
		}
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		//������ ����
		int n = sc.nextInt();
		answer = new ArrayList<>();
		
		if(1<=n&&n<=500) {
			//������ ������ n+1
			visited = new boolean[n+1][n];
			x = new int[n+1][n];
			
			//������ ���� �������� x��ǥ �Է�
			for(int i=0;i<n+1;i++) {
				for(int j=0;j<n;j++) {
					x[i][j]=sc.nextInt();
				}
			}
			//Ž�� ����
			int i = 0;
			while(i<n) {
				//���� ����
				start = x[0][i];
				flag = false;
				//ù ��° ����
				for(int j=0;j<n;j++) {
					if(!visited[1][j]) {
						visited[1][j]=true;
						sub=x[1][j]-start;
						dfs(x[1][j], 1);
						if(!flag) {
							visited[1][j]=false;
						}else {
							break;
						}
					}
				}
				i++;
			}
			for(int j=0;j<answer.size();j++) {
				Gooseul g = answer.get(j);
				System.out.println(g.start);
				System.out.println(g.speed);
			}
		}
	}
}
