package test_190215;

import java.util.Arrays;
import java.util.Scanner;

//유저의 수 n, 친구 관계의 수 m, 친구 관계 정보가 주어질 때, 규칙에 따라 구한 케빈 베이컨의 수 최소값 구하기(플로이드 와샬)
public class B_1389 {

	static int n;
	static int m;
	//친구 관계 여부
	static int [][] f;
	static int ans = 0;
	static int [] kevin;
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		
		if(n<=100&&m<=100) {
			f = new int[n+1][n+1];
			kevin = new int[n+1];
			
			//무한값으로 초기화
			for(int i=1;i<=n;i++) {
				Arrays.fill(f[i], 100001);
				//자기 자신이 친구인 경우 = 0
				f[i][i]=0;
			}
			
			//친구 관계 입력
			for(int i=1;i<=m;i++) {
				int tmp1 = sc.nextInt();
				int tmp2 = sc.nextInt();
				f[tmp1][tmp2]=f[tmp2][tmp1]=1;
			}
			
			//플로이드 와샬 실행(i에서 j로 바로 가는 경우 = 직접 친구, i에서 k를 거쳐 j로 가는 경우 = 간접 친구)
			for(int k=1;k<=n;k++) {
				for(int i=1;i<=n;i++) {
					for(int j=1;j<=n;j++) {
						//최단 거리 갱신
						if(f[i][k]+f[k][j]<f[i][j]) {
							f[i][j]=f[i][k]+f[k][j];
						}
					}
				}
			}
			
			//결과를 kevin 배열에 저장
			for(int i=1;i<=n;i++) {
				for(int j=1;j<=n;j++) {
					kevin[i]+=f[i][j];
				}
			}
			
			int min = Integer.MAX_VALUE;
			for(int i=1;i<=n;i++) {
				if(min>kevin[i]) {
					min=kevin[i];
					ans=i;
				}
			}
			System.out.println(ans);
		}
	}
}
