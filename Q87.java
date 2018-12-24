package solution;

import java.util.Scanner;

//2:2 테니스 복식 조를 짜는 과정에서 각 회원의 개별 실력 점수가 주어질 때 만족도 점수의 하한선을 극대화 하는 방법 구하기
public class Q87 {

	//8명 회원의 실력 점수
	static int [] score = new int[8];
	//만족도 점수 하한값의 최대치(소수점 둘째자리까지 출력 = 최소 0, 최대 1)
	static float max = Integer.MIN_VALUE;
	static boolean [] visited = new boolean[8];
	
	public static void dfs(int [] avg, int num) {
		//모든 조가 완성되면(만족도 점수 조사)
		if(num==8) {
			float min = Integer.MAX_VALUE;
			float avg1 = 0;
			float avg2 = 0;
			for(int i=0;i<8;i++) {
				if(i%4==0||i%4==1) {
					avg1+=avg[i];
					if(i%4==1) {
						avg1/=2;	
					}
				}else if(i%4==2||i%4==3) {
					avg2+=avg[i];
					if(i%4==3) {
						avg2/=2;	
					}
				}
				//한 경기가 성사되면
				if(i%4==3) {
					//해당 경기의 만족도 점수
					min = Math.min(1-Math.abs(avg1-avg2)/10, min);
					//변수 초기화
					avg1 = 0;
					avg2 = 0;
				}
			}
			//현재 매치업에서의 하한값이 이전 케이스에 비해 
			if(max<=min) {
				max=min;
			}
		}else {
			num++;
			for(int i=0;i<visited.length;i++) {
				if(!visited[i]) {
					visited[i]=true;
					avg[num-1]=score[i];
					dfs(avg,num);
					visited[i]=false;
				}
			}
		}
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		//입력
		for(int i=0;i<8;i++) {
			int tmp = sc.nextInt();
			//실력 점수는 0이상 10이하 점수
			if(0<=tmp&&tmp<=10) {
				score[i]=tmp;
			}
		}
		
		int [] avg = new int[8];
		//탐색 실행(2인 1조)
		for(int i=0;i<8;i++) {
			visited[i]=true;
			avg[0]=score[i];
			dfs(avg,1);
			visited[i]=false;
		}
		System.out.println(max);
	}
}
