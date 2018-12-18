package solution;

import java.util.Scanner;

//1만 이하의 수 중 대칭수가 되지 못하는 라이크렐 수의 개수 구하기(50번 미만 반복을 통해 대칭수가 되지 않으면 라이크렐 수로 간주)
public class Q56 {

	//두개의 숫자 합연산 진행할 메소드
	public static long sum(long x) {
		String x_str = String.valueOf(x);
		String y_str = "";
		//뒤에서부터 차례대로 숫자 형성
		for(int i=x_str.length()-1;i>=0;i--) {
			y_str+=x_str.charAt(i);
		}
		long y = Long.parseLong(y_str);
		
		return x+y;
	}
	
	//대칭수인지 아닌지 판별하는 메소드
	public static boolean result(long n) {
		String str = String.valueOf(n);
		boolean flag = false;
		for(int i=0;i<str.length()/2;i++) {
			//양쪽 끝에서부터 대칭의 위치에 있는 숫자가 같은 숫자인지 확인
			if(str.charAt(i)!=str.charAt(str.length()-1-i)) {
				flag = true;
				break;
			}
		}
		//대칭수이면 true 반환
		if(!flag) {
			return true;
		}else {
			return false;
		}
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int answer = 0;
		
		for(int i=1;i<10000;i++) {
			//반복 횟수 저장할 변수
			int cnt = 0;
			//대칭수 판별 결과를 저장할 변수
			boolean flag = false;
			//초기값
			long tmp1 = i;
			//최대 반복 횟수는 50회 미만
			while(!flag||cnt<50) {
				tmp1 = sum(tmp1);
				flag = result(tmp1);
				cnt++;
			}
			if(flag) {
				answer++;
			}
		}
		System.out.println(answer);
	}
}
