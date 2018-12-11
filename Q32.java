package solution;

import java.util.Scanner;
import java.util.Stack;

//남은 밀가루 양, 밀가루 공급 시점, 	공급 가능한 밀가루 양이 배열로 주어질 때 최소한의 공급으로 공장을 운영할 수 있는 횟수 구하기
public class Q32 {

	public static int result(int [] date, int [] supply, int n, int k) {
		int answer = 0;
		//전체 밀가루양(남은 양+새로운 공급)
		int flour = n;
		int time = n;
		int idx = 0;
		Stack<Integer> st = new Stack<>();
		//전체 양 > 버텨야 하는 일수 -> 반복 종료(더 이상 공급 없어도 됨)
		while(flour>k) {
			//모두 소진되면 공급 필요
			if(time==0) {
				flour+=st.peek();
				time+=st.peek();
				st.pop();
				answer++;
			}
			//공급 가능한 시점이 될 경우
			if(idx<date.length&&date[idx]<=flour) {
				st.push(supply[idx]);
				idx++;
			}
			//버틸 수 있는 일수 감소(1일 1톤 소비)
			time--;
		}
		
		
		return answer;
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int m = sc.nextInt();
		
		if(1<=n&&n<=100000&&1<=k&&k<=100000&&1<=m&&m<=20000) {
			//공급 시점 배열
			int [] date = new int[m];
			//각 시점별 공급 가능량
			int [] supply = new int[m];
			//입력
			for(int i=0;i<date.length;i++) {
				int tmp1 = sc.nextInt();
				int tmp2 = sc.nextInt();
				if(1<=tmp1&&tmp1<=k) {
					date[i]=tmp1;
					supply[i]=tmp2;
				}
			}
			//실행
			result(date, supply, n, k);
		}
	}	
}
