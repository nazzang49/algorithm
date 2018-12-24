package solution;

import java.util.Scanner;

//a,b,c 세 사람이 각각 숫자가 적힌 임의의 카드 세트를 받았을 때, 그 중 하나씩을 골라 <최대값 - 최소값 = 벌점>을 체크할 시 얻을 수 있는 벌점의 최소값 구하기
public class Q88 {

	static int [] a_card;
	static int [] b_card;
	static int [] c_card;
	static int answer = Integer.MAX_VALUE;
	
	public static void dfs(int [] arr, int cnt) {
		//3장의 카드를 모두 고른 경우
		if(cnt==3) {
			int max = Math.max(Math.max(arr[0], arr[1]), arr[2]);
			int min = Math.min(Math.min(arr[0], arr[1]), arr[2]);
			int penalty = Math.abs(max-min);
			//이전 케이스들과 결과 비교
			if(penalty<=answer) {
				answer=penalty;
			}
		}else {
			//b가 고를 차례
			if(cnt==1) {
				cnt++;
				for(int i=0;i<b_card.length;i++) {
					arr[cnt-1]=b_card[i];
					dfs(arr,cnt);
				}
			}
			//c가 고를 차례
			else {
				cnt++;
				for(int i=0;i<c_card.length;i++) {
					arr[cnt-1]=c_card[i];
					dfs(arr,cnt);
				}
			}
		}
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		
		//세명이 받을 수 있는 카드의 개수
		if(1<=a&&a<=1000&&1<=b&&b<=1000&&1<=c&&c<=1000) {
			a_card = new int[a];
			b_card = new int[b];
			c_card = new int[c];
			int [] arr = new int[3];
			
			//입력
			for(int i=0;i<a;i++) {
				int tmp = sc.nextInt();
				if(tmp<=Math.abs(Math.pow(10, 9))) {
					a_card[i]=tmp;
				}
			}
			for(int i=0;i<b;i++) {
				int tmp = sc.nextInt();
				if(tmp<=Math.abs(Math.pow(10, 9))) {
					b_card[i]=tmp;
				}
			}
			for(int i=0;i<c;i++) {
				int tmp = sc.nextInt();
				if(tmp<=Math.abs(Math.pow(10, 9))) {
					c_card[i]=tmp;
				}
			}
			//탐색 실행
			for(int i=0;i<a;i++) {
				arr[0]=a_card[i];
				dfs(arr,1);
			}
			System.out.println(answer);
		}
	}
}
