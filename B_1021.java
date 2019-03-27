package test_190327;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.Scanner;

//양방향 큐에서 원하는 위치에 있는 데이터를 최소 연산으로 뽑는 경우의 수 구하기
public class B_1021 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		if(n<=50&&m<=n) {
			//양방향 큐 = 데크
			Deque<Integer> dq = new ArrayDeque<>();
			//정수 입력
			for(int i=1;i<=n;i++) {
				//단순 add는 앞에서부터 차례로 데이터 입력하는 방식
				dq.add(i);
			}
			
			int cnt = 0;
			//찾고자 하는 정수 입력 및 탐색
			for(int i=0;i<m;i++) {
				int tmp = sc.nextInt();
				while(true) {
					int idx = 0;
					Iterator<Integer> it = dq.iterator();
					while(it.hasNext()) {
						if(it.next()==tmp) break;
						idx++;
					}
					//찾고자 하는 정수가 가장 앞에 위치해 있으면 = 바로 출력(그 외의 경우, 왼쪽과 오른쪽 중 어디서 더 가까운지 고려)
					if(idx==0) {
						dq.pollFirst();
						break;
					}
					//왼쪽 기준
					else if(dq.size()/2>=idx) {
						dq.addLast(dq.pollFirst());
						cnt++;
					}
					//오른쪽 기준
					else {
						dq.addFirst(dq.pollLast());
						cnt++;
					}
				}
			}
			System.out.println(cnt);
		}	
	}
}
