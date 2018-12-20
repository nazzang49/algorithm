package solution;

import java.util.Scanner;

//목장과 헛간의 수, 각 장소를 잇는 길과 이동 시간이 주어질 때 최종 헛간으로 가장 빨리 돌아오는 소 구하기
public class Q71 {

	static int n;
	static String [] start;
	static String [] end;
	static int [] time;
	static int min = Integer.MAX_VALUE;
	static int answer = 0;
	static String answer_str = "";
	
	public static void dfs(int idx, int sum) {
		//최종 도착지인 헛간이면
		if(end[idx].equals("Z")) {
			if(sum<=min) {
				min=sum;
				answer_str=start[answer];
			}
		}else {
			for(int i=0;i<n;i++) {
				//중간 지점 = 새로운 시작 지점
				if(end[idx].equals(start[i])) {
					sum+=time[i];
					dfs(i,sum);
					sum-=time[i];
				}
			}
		}
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		//길의 개수
		n = sc.nextInt();
		
		if(1<=n&&n<=10000) {
			start = new String[n];
			end = new String[n];
			time = new int[n];
			//입력
			for(int i=0;i<n;i++) {
				String a = sc.next();
				String b = sc.next();
				int tmp = sc.nextInt();
				if(1<=tmp&&tmp<=1000) {
					start[i]=a;
					end[i]=b;
					time[i]=tmp;
				}
			}
			//탐색
			for(int i=0;i<n;i++) {
				//대문자인 경우에만 탐색 실행(목장에 있는 소)
				if('A'<=start[i].charAt(0)&&start[i].charAt(0)<='Z') {
					answer=i;
					dfs(i,time[i]);
				}
			}
			System.out.println(answer_str);
			System.out.println(min);
		}
	}
}
