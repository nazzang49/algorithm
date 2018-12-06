package solution;

import java.util.Scanner;

//입력값과 규칙이 주어질 때, 야근 피로도의 최소값 구하기
public class Q11 {

	static int min = Integer.MAX_VALUE;
	static int [] left;
	static int n;
	
	public static void dfs(int hour) {
		if(hour==0) {
			int sum = 0;
			for(int i=0;i<left.length;i++) {
				sum+=Math.pow(left[i], 2);
			}
			if(min>=sum) {
				min=sum;
			}
		}else {
			for(int i=0;i<left.length;i++) {
				left[i]--;
				dfs(hour-1);
				left[i]++;
			}
		}
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		
		if(1<=n&&n<=20000) {
			left = new int[n];
			for(int i=0;i<n;i++) {
				int tmp = sc.nextInt();
				if(1<=tmp&&tmp<=50000) {
					left[i]=tmp;
				}
			}
			int hour = sc.nextInt();
			if(1<=hour&&hour<=1000000) {
				dfs(hour);
			}
			System.out.println(min);
		}
	}
}
