package solution;

import java.util.Scanner;

//nxn 체스판 위에 n개의 퀸을 놓을 때 서로 공격할 수 없도록 놓는 경우의 수 출력하기(퀸의 이동방향은 상하좌우, 대각선)
public class Q145 {

	static int path[] = new int[16];
	static int n;
	static int ans;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		
		for(int i=0;i<n;i++){
			path[0]=i;
			nQueen(i,0);
		}
		System.out.println(ans);
	}
	
	//재귀함수
	private static void nQueen(int x, int y) {
		for(int i=0;i<y;i++){
	        if(path[i]==x||Math.abs(x-path[i])==y-i) return;
	    }
		//마지막 행이면
	    if(y==n-1){
	        ans++;
	        return;
	    }
	    for(int i=0;i<n;i++){
	        path[y+1]=i;
	        nQueen(i,y+1);
	    }
	}
}
