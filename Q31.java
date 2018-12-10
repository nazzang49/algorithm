package solution;

import java.util.Arrays;
import java.util.Scanner;

//구명보트의 무게 용량, 무인도에 갇힌 사람들의 몸무게 배열이 주어질 때 필요한 구명보트 개수의 최소값 구하기
public class Q31 {

	public static int result(int [] weight, int limit) {
		int cnt = 0;
		int sum = 0;
		//오름차순 정렬
		Arrays.sort(weight);
		for(int i=0;i<weight.length;i++) {
			sum+=weight[i];
			if(sum>limit) {
				cnt++;
				sum=0;
				if(i==weight.length-1) {
					cnt++;
					break;
				}
				i--;
			}
			if(i==weight.length-1) {
				cnt++;
				break;
			}
		}
		return cnt;
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		if(1<=n&&n<=50000&&40<=k&&k<=240) {
			int [] weight = new int[n];
			//입력
			for(int i=0;i<weight.length;i++) {
				int tmp = sc.nextInt();
				if(40<=tmp&&tmp<=240) {
					weight[i]=tmp;
				}
			}
			//실행
			System.out.println(result(weight,k));
		}
	}
}
