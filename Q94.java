package solution1;

import java.util.Scanner;

//염소와 양이 하루동안 먹는 사료의 양이 a,b이며 주인이 확인한 염소와 양의 수 합산이 n, 하루동안 소비된 사료의 양이 w일 때 염소와 양의 마리수 출력하기
public class Q94 {

	//가능한 경우의 수 저장할 변수
	static int count = 0;
	//염소와 양의 마릿수
	static int yeomso = 0;
	static int yang = 0;
	static int w;
	static int a;
	static int b;
	static int n;
	
	//a는 염소, b는 양
	public static void dfs(int y1, int y2) {
		if(y1*a+y2*b==w&&y1+y2==n) {
			//최소 1마리씩은 존재해야함(이미 나온 경우의 수라면 중복되지 않도록 조치)
			if(!(y1==0||y2==0)&&!(yeomso==y1&&yang==y2)) {
				count++;
				yeomso = y1;
				yang = y2;
				//2가지 이상 가능한 경우가 있으면
				if(count>=2) {
					System.out.println(-1);
					System.exit(0);
				}
			}
		}else if(y1+y2<n) {
			for(int i=0;i<2;i++) {
				if(i==0) {
					y1++;
					dfs(y1,y2);
					y1--;
				}else {
					y2++;
					dfs(y1,y2);
					y2--;
				}
			}
		}
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		a = sc.nextInt();
		b = sc.nextInt();
		n = sc.nextInt();
		w = sc.nextInt();
		
		if(1<=a&&a<=1000&&1<=b&&b<=1000&&2<=n&&n<=1000&&2<=w&&w<=1000000) {
			dfs(0,0);
			if(yeomso==0&&yang==0) {
				System.out.println(-1);
				System.exit(0);
			}
			System.out.println(yeomso);
			System.out.println(yang);
		}
	}
}
