package test_190211;

import java.util.ArrayList;
import java.util.Scanner;

//입력으로 주어지는 모든 인원의 친구 관계를 고려할 때, 가장 유명한 사람은 누구인지 출력하기
public class B_1058 {

	static int n;
	static boolean [][] line;
	static boolean [] v;
	
	public static int dfs(int num) {
		int cnt = 0;
		//직접 친구인 인원
		ArrayList<Integer> direct = new ArrayList<>();
		for(int i=0;i<n;i++) {
			if(!v[i]&&line[num][i]) {
				cnt++;
				v[i]=true;
				direct.add(i);
			}
		}
		//건너 건너 아는 인원
		for(int i=0;i<direct.size();i++) {
			for(int j=0;j<n;j++) {
				if(!v[j]&&line[direct.get(i)][j]) {
					cnt++;
				}
			}
		}
		return cnt;
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		int max = Integer.MIN_VALUE;
		
		if(n<=50) {
			//A와 B가 친구이면, B와 A도 친구(친구 관계 입력)
			line = new boolean[n][n];
			v = new boolean[n];
			for(int i=0;i<n;i++) {
				String str = sc.next();
				for(int j=0;j<n;j++) {
					//친구이면
					if(str.charAt(j)=='Y') {
						line[i][j]=line[j][i]=true;
					}
				}
			}
			//직접 친구인 인원 저장
			for(int i=0;i<n;i++) {
				v[i]=true;
				int cnt = dfs(i);
				if(cnt>max) {
					max=cnt;
				}
				v=new boolean[n];
			}
			System.out.println(max);
		}
	}
}
