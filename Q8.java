package solution;

import java.util.ArrayList;
import java.util.Scanner;

//왼쪽과 오른쪽 카드 더미가 주어질 때, 문제 규칙에 따라 얻을 수 있는 합산 점수의 최대값 구하기
public class Q8 {
	
	static int sum = 0;
	static int max = 0;
	static boolean [] visited;

	public static void dfs(ArrayList<Integer> left, ArrayList<Integer> right) {
		if(left.isEmpty()||right.isEmpty()) {
			if(max<=sum) {
				max=sum;
			}
			sum=0;
		}else {
			//왼쪽 제일 위의 카드가 더 큰 경우(오른쪽 out / 점수 추가)
			if(left.get(0)>right.get(0)) {
				sum+=right.get(0);
				int tmp = right.remove(0);
				dfs(left,right);
				right.add(0,tmp);
			}
			//오른쪽 제일 위의 카드가 더 큰 경우(왼쪽 out / 왼쪽, 오른쪽 둘 다 out)
			else {
				for(int i=0;i<2;i++) {
					if(i==0) {
						int tmp = left.remove(0);
						dfs(left,right);
						left.add(0, tmp);
					}else {
						int tmp1 = left.remove(0);
						int tmp2 = right.remove(0);
						dfs(left,right);
						left.add(0, tmp1);
						right.add(0, tmp2);
					}
				}
			}
		}
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		//점수를 얻을 수 있는 경우는 오로지 오른쪽 더미에서만
		if(1<=n&&n<=2000) {
			ArrayList<Integer> left = new ArrayList<>();
			ArrayList<Integer> right = new ArrayList<>();
			visited = new boolean[n];
			
			for(int i=0;i<n;i++) {
				int tmp1 = sc.nextInt();
				int tmp2 = sc.nextInt();
				if(1<=tmp1&&tmp1<=2000&&1<=tmp2&&tmp2<=2000) {
					left.add(tmp1);
					right.add(tmp2);
				}
			}
			dfs(left,right);
			System.out.println(max);
		}
	}
}
