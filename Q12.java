package solution;

import java.util.Scanner;

//입국심사를 받는데 걸리는 심사관별 시간, 대기자 수가 주어질 때 모든 사람들이 입국심사를 마무리 짓는데 걸리는 최소 시간 구하기
//이분탐색(특정 시점에 지나갈 수 있는 인원 수를 반복적으로 고려하며 low값과 high 값을 조절)
public class Q12 {
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] T = new int[N]; 
		int max = 0;
		for(int i=0;i<N;i++){
			T[i] = sc.nextInt();
			if(max < T[i])
				max = T[i];
		}
		long lo = 0;
		long hi = (long)max * M;
		
		while(lo < hi){
			long mid = (lo+hi)/2;
			long total = 0;
			for(int i=0;i<N;i++){
				total += mid/T[i];
			}
			if(total >= M){
				hi = mid;
			} else {
				lo = mid +1;
			}
		}
		System.out.println(lo);
	}
}
