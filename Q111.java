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

//x축을 평행하게 달리는 n개의 구슬들이 일정한 속도로 전진할 때, n+1개의 사진을 찍은 시점을 활용하여 각각의 구슬 속도 구하기
public class Q111 {

	static int start = 0;
	static int sub = 0;
	static boolean flag = false;
	static int [][] x;
	static boolean [][] visited;
	static ArrayList<Gooseul> answer;
	
	public static void dfs(int before, int count) {
		//n+1번 반복하게 되면(일정한 차이값을 가지는 경우가 있다면)
		if(count==x.length-1) {
			flag = true;
			answer.add(new Gooseul(start, sub));
		}else if(count<x.length-1) {
			count++;
			for(int i=0;i<x.length-1;i++) {
				//다음 줄에 방문하지 않은 지점이 있다면
				if(!visited[count][i]) {
					visited[count][i]=true;
					//이전 차이값과 같으면
					if(x[count][i]-before==sub) {
						dfs(x[count][i], count);
					}
					//백트래킹
					visited[count][i]=false;
				}
			}
		}
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		//구슬의 개수
		int n = sc.nextInt();
		answer = new ArrayList<>();
		
		if(1<=n&&n<=500) {
			//사진의 개수는 n+1
			visited = new boolean[n+1][n];
			x = new int[n+1][n];
			
			//사진에 찍힌 구슬들의 x좌표 입력
			for(int i=0;i<n+1;i++) {
				for(int j=0;j<n;j++) {
					x[i][j]=sc.nextInt();
				}
			}
			//탐색 실행
			int i = 0;
			while(i<n) {
				//시작 지점
				start = x[0][i];
				flag = false;
				//첫 번째 시작
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
