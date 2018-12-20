package solution;

import java.util.Scanner;

//보석의 종류와 값어치가 주어질 때, 배낭의 용량을 초과하지 않으면서 가장 최대의 값어치를 얻을 수 있는 방법 구하기
public class Q69 {

	//최대값 갱신할 변수
	static int max = Integer.MIN_VALUE;
	static int weight_final;
	static int [] weight;
	static int [] value;
	
	public static void dfs(int start, int total, int sum) {
		//누적 무게가 배낭의 용량보다 작은 경우
		if(total<=weight_final) {
			for(int i=start+1;i<weight.length;i++) {
				total+=weight[i];
				sum+=value[i];
				if(total>weight_final) {
					sum-=value[i];
					if(sum>=max) {
						max=sum;
					}
				}else {
					if(i==weight.length-1) {
						if(sum>=max) {
							max=sum;
						}	
					}else {
						dfs(i,total,sum);
						total-=weight[i];
						sum-=value[i];	
					}
				}
			}
		}
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		weight_final = sc.nextInt();
		
		if(1<=n&&n<=1000&&1<=weight_final&&weight_final<=10000) {
			weight = new int[n];
			value = new int[n];
			//입력
			for(int i=0;i<n;i++) {
				int tmp1 = sc.nextInt();
				int tmp2 = sc.nextInt();
				if(1<=tmp1&&tmp1<=weight_final) {
					weight[i]=tmp1;
					value[i]=tmp2;
				}
			}
			//탐색
			for(int i=0;i<n;i++) {
				dfs(i, weight[i], value[i]);
			}
			System.out.println(max);
		}
	}
}
