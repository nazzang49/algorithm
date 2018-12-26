package solution;

import java.util.Arrays;
import java.util.Scanner;

//스네이크버드는 자신보다 작거나 같은 높이의 열매를 먹고 길이를 1 증가시키는데, 초기 길이와 열매의 높이들이 배열로 주어질 때 최종 스네이크버드 길이 출력하기
public class Q89 {

	public static int result(int [] height, int k) {
		//열매 높이 오름차순 정렬
		Arrays.sort(height);
		for(int i=0;i<height.length;i++) {
			if(k>=height[i]) {
				k++;
			}
		}
		return k;
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		//열매 갯수
		int n = sc.nextInt();
		//스네이크버드의 초기 길이
		int k = sc.nextInt();
		
		if(1<=n&&n<=1000&&1<=k&&k<=10000) {
			int [] height = new int[n];
			//열매 높이 입력
			for(int i=0;i<n;i++) {
				int tmp = sc.nextInt();
				if(1<=tmp&&tmp<=10000) {
					height[i]=tmp;
				}
			}
			//탐색
			int answer = result(height, k);
			System.out.println(answer);
		}
	}
}
