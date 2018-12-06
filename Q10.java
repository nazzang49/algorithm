package solution;

import java.util.Scanner;

//n행 4열로 주어진 2차원 배열에서 이미 밟은 idx를 제외하고 특정 칸에 적힌 점수를 합산할 때 마지막 행 도달 후 얻을 수 있는 최대값 구하기
public class Q10 {
	
	static int [][] map;
	static int max = 0;
	static int n;
	
	//DFS+백트래킹
	public static void dfs(int x, int y, int sum) {
		//마지막 행 도착 시(최대값 비교)
		if(x==n) {
			if(max<=sum) {
				max=sum;
			}
		}else {
			sum+=map[x][y];
			for(int j=0;j<4;j++) {
				//그 전에 선택한 열이랑 같으면(경우의 수 제외)
				if(j==y) {
					continue;
				}else {
					dfs(x+1,j,sum);	
				}
			}
		}
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		
		if(1<=n&&n<=100000) {
			map = new int[n][4];
			//입력
			for(int i=0;i<map.length;i++) {
				for(int j=0;j<map[i].length;j++) {
					map[i][j]=sc.nextInt();
				}
			}
			//탐색
			for(int j=0;j<4;j++) {
				dfs(0,j,0);
			}
			System.out.println(max);
		}
	}
}
