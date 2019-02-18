package test_190218;

import java.util.Scanner;

//올림픽에 참가한 n개 나라의 각 금메달, 은메달, 동메달 획득 갯수가 입력될 때 특정 국가의 순위 맞히기
public class B_8979 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		if(n<=1000&&n<=1000) {
			int [] g = new int[n+1];
			int [] s = new int[n+1];
			int [] b = new int[n+1];
		
			//메달 입력
			for(int i=1;i<=n;i++) {
				int tmp = sc.nextInt();
				g[tmp]=sc.nextInt();
				s[tmp]=sc.nextInt();
				b[tmp]=sc.nextInt();
			}
			
			int [] ans = new int[n+1];
			//모두 1등으로 초기화
			for(int i=1;i<=n;i++) {
				ans[i]=1;
			}
			//탐색 실행
			for(int i=1;i<=n;i++) {
				for(int j=1;j<=n&&i!=j;j++) {
					//금메달 수가 적으면
					if(g[i]<g[j]) {
						ans[i]++;
						continue;
					}
					//금메달 수가 같으면(은메달 비교)
					else if(g[i]==g[j]) {
						//은메달 수가 적으면
						if(s[i]<s[j]) {
							ans[i]++;
							continue;
						}
						//은메달 수가 같으면(동메달 비교)
						else if(s[i]==s[j]) {
							//동메달 수가 적으면
							if(b[i]<b[j]) {
								ans[i]++;
								continue;
							}
						}
					}
				}
			}
			System.out.println(ans[k]);
		}else System.out.println("입력 조건을 확인하세요.");
	}
}
