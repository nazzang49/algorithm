package test_190121;

import java.util.Scanner;

//문제의 답과 입력한 답안의 채점 방식 규칙에 따라 책정된 최종 점수 출력하기
public class B_3077 {

	static String [] ans;
	
	public static boolean result(String str1, String str2) {
		int idx1 = -1;
		int idx2 = -1;
		for(int i=0;i<ans.length;i++) {
			if(ans[i].equals(str1)) {
				idx1=i;
			}else if(ans[i].equals(str2)) {
				idx2=i;
			}
		}
		//정답 중 하나이며, 시간 순서가 맞는 경우
		if(idx1<idx2&&idx1!=-1&&idx2!=-1) {
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int cnt = 0;
		
		if(2<=n&&n<=2500) {
			ans = new String[n];
			String [] str = new String[n];
			
			//문제의 정답과 답안 입력
			for(int i=0;i<ans.length;i++) {
				ans[i]=sc.next();
			}
			for(int i=0;i<str.length;i++) {
				str[i]=sc.next();
			}
			//탐색 실행(두 개의 쌍식 발생연도 비교)
			for(int i=0;i<str.length-1;i++) {
				for(int j=i+1;j<str.length;j++) {
					if(result(str[i],str[j])) {
						cnt++;
					}
				}
			}
			System.out.println(cnt+"/"+n*(n-1)/2);
		}
	}
}
