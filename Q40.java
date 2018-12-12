package solution;

import java.util.Scanner;

//문자열로 이루어진 숫자에서 특정 개수만큼 숫자를 제거할 때 얻을 수 있는 수 중 최대값 구하기
public class Q40 {

	static String str;
	static int max = Integer.MIN_VALUE;
	
	public static void dfs(int start, int [] idx, int cnt) {
		if(cnt==idx.length) {
			String tmp = "";
			int chk = 0;
			for(int i=0;i<str.length();i++) {
				if(chk<idx.length&&i==idx[chk]) {
					chk++;
					continue;
				}
				tmp+=str.charAt(i);
			}
			int num = Integer.parseInt(tmp);
			if(max<=num) {
				max=num;
			}
		}else {
			cnt++;
			for(int i=start+1;i<str.length();i++) {
				idx[cnt-1]=i;
				dfs(i,idx,cnt);
			}
		}
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		str = sc.next();
		int k = sc.nextInt();
		
		if(1<=str.length()&&str.length()<=1000000&&1<=k&&k<str.length()) {
			//제거할 숫자의 인덱스가 담긴 배열
			int [] idx = new int[k];
			for(int i=0;i<str.length();i++) {
				idx[0]=i;
				dfs(i,idx,1);
			}
			System.out.println(max);
		}
	}
}
