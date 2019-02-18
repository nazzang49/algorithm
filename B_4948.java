package test_190218;

import java.util.ArrayList;
import java.util.Scanner;

//베르트랑 공준(n보다 크고, 2n보다 작거나 같은 수 중 반드시 하나의 소수가 존재한다는 법칙)에 의거, 해당 범위 내 소수의 개수 구하기
public class B_4948 {

	//에라토스테네스의 체 활용(1~2n까지의 수 중 소수가 아닌 것은 0으로 변경)
	public static int result(int n) {
		int cnt = 0;
		int [] d = new int[n+1];
		//자기 자신으로 초기화
		for(int i=1;i<=n;i++) {
			d[i]=i;
		}
		//2부터 탐색 시작
		for(int i=2;i<=n;i++) {
			//이미 삭제된 것은 건너뛰기
			if(d[i]==0) continue;
			//i의 배수가 되는 자리의 숫자를 0으로 변경
			for(int j=2;i*j<=n;j++) {
				d[i*j]=0;
			}
		}
		//소수 갯수 추출
		for(int i=n/2+1;i<=n;i++) {
			if(d[i]!=0) cnt++;
		}
		return cnt;
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> ans = new ArrayList<>();
		
		while(true) {
			int n = sc.nextInt();
			if(n==0) {
				break;
			}
			ans.add(result(2*n));
		}
		//정답 출력
		for(int i=0;i<ans.size();i++) {
			System.out.println(ans.get(i));
		}
	}
}
