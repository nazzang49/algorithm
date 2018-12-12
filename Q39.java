package solution;

import java.util.Scanner;

//중앙에는 빨간색, 가장자리는 갈색으로 칠해진 직사각형 격자 모양의 카펫에서 두 가지 색이 쓰인 칸수를 보고 전체 카펫 크기 도출하기
public class Q39 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		//빨간색 개수
		int n = sc.nextInt();
		//갈색 개수
		int m = sc.nextInt();
		
		if(1<=n&&n<=5000&&8<=m&&m<=2000000) {
			//가로 및 세로 길이
			int wide = 0;
			int high = 0;
			
			if(n%2==0) {
				//1부터 n까지 약수가 나올때마다 조건 충족 여부 탐색
				for(int i=1;i<=n;i++) {
					if(n%i==0) {
						//빨간색 칸의 가로 길이
						int column = n/i;
						//총 쓰여야 하는 갈색 칸의 수
						int total = (column+2)*2+i*2;
						if(total==m) {
							wide=column+2;
							high=i+2;
							if(wide<=high) {
								int tmp = wide;
								wide=high;
								high=tmp;
							}
							break;
						}
					}
				}
			}else {
				wide=n+2;
				high=3;
			}
			System.out.println(wide);
			System.out.println(high);
		}
	}
}
