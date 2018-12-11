package solution;

import java.util.Arrays;
import java.util.Scanner;

//어느 과학자의 논문별 인용 횟수가 배열로 주어질 때, h-index 값 구하기
public class Q33 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		if(1<=n&&n<=1000) {
			int [] docu = new int[n];
			//입력
			for(int i=0;i<docu.length;i++) {
				int tmp = sc.nextInt();
				if(0<=tmp&&tmp<=10000) {
					docu[i]=tmp;
				}
			}
			//실행
			//오름차순 정렬
			Arrays.sort(docu);
			//이분 탐색
			int low = docu[0];
			int high = docu[docu.length-1];
			int mid = 0;
			int answer = 0;
			while(low<high) {
				mid = (low+high)/2;
				int cnt = 0;
				for(int i=docu.length-1;i>=0;i--) {
					if(mid<=docu[i]) {
						cnt++;
					}else {
						break;
					}
				}
				//빈도 수 = 현재 값(조건 만족하는 최대 수)
				if(cnt==mid) {
					answer = mid;
					break;
				}
				//개수가 적음(현재 값보다 작은 값)
				else if(cnt<mid) {
					high=mid;
				}
				//개수가 많음(현재 값보다 큰 값)
				else {
					low=mid+1;
				}
			}
			System.out.println(answer);
		}
	}
}
