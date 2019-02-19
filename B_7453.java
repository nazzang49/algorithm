package test_190219;

import java.util.HashMap;
import java.util.Scanner;

//Nx4 행렬에 자연수가 입력될 때, 각 열에서 하나의 숫자를 뽑아 합한 수가 0이 되는 쌍의 갯수 구하기
public class B_7453 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int ans = 0;
		
		//행의 크기가 최대 4000 -> 선형탐색 시 시간복잡도 비효율 -> 0,1열 / 2,3열로 나누어 고려
		if(n<=4000) {
			long [][] map = new long[n][4];
			//자연수 입력
			for(int i=0;i<n;i++) {
				for(int j=0;j<4;j++) {
					map[i][j]=sc.nextLong();
				}
			}
			HashMap<Long, Long> hs = new HashMap<>();
			//해쉬맵 형성
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					//0열에서 1개, 1열에서 1개 추출하는 경우
					long tmp = map[i][0]+map[j][1];
					//이미 해당하는 수가 포함되어 있으면(value 값 증가 = 값은 같지만 서로 다른 경우의 수)
					if(hs.containsKey(tmp)) {
						hs.replace(tmp, hs.get(tmp)+1);
					}else {
						//1의 자료형 long으로 변경
						hs.put(tmp, 1l);
					}
				}
			}
			//2,3열과 비교
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					//0,1열의 합으로 형성된 수에 부호가 다른 수를 더해야만 0이 되는지 확인할 수 있음
					long tmp = (map[i][2]+map[j][3])*-1;
					if(hs.containsKey(tmp)) {
						ans+=hs.get(tmp);
					}
				}
			}
			System.out.println(ans);
		}
	}
}
