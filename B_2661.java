package test_190325;

import java.util.Scanner;

//1,2,3으로만 이루어진 길이가 N인 숫자 중 임의 길이 인접한 두개 부분 수열이 동일하지 않은 것 중 가장 작은 수 구하기
public class B_2661 {

	static int n;
	
	//좋은 수열인지 판별한 메소드
	public static boolean flag(String str) {
		//임의 길이의 부분 수열 비교
		for(int i=1;i<=str.length()/2;i++) {
			int j = 0;
			while(j+i+i<=str.length()) {
				//인접한 부분 수열이 같으면
				if(str.substring(j, j+i).equals(str.substring(j+i, j+i+i))) {
					return false;
				}
				j++;
			}
		}
		return true;
	}
	
	public static void dfs(String str) {
		if(str.length()==n) {
			//출력
			System.out.println(str);
			System.exit(0);
		}
		String tmp = str;
		//1~3의 숫자만 사용 가능
		for(int i=1;i<=3;i++) {
			tmp+=i;
			//좋은 수열인 경우에만 계속해서 반복
			if(flag(tmp)) {
				dfs(tmp);
			}
			tmp = str;
		}
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		
		//최대 80자리
		if(n<=80) {
			dfs("1");
		}	
	}
}
