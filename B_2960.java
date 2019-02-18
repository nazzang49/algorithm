package test_190218;

import java.util.Scanner;

//n보다 작거나 같은 수 중 모든 소수 찾기
public class B_2960 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		if(n<=1000&&k<=n) {
			int [] arr = new int[n+1];
			for(int i=2;i<=n;i++) {
				//이미 지운 수이면 건너뛰기 or 지우지 않았다면(삭제)
				if(arr[i]==-1) continue;
				else {
					k--;
					arr[i]=-1;
					if(k==0) {
						System.out.println(i);
						System.exit(0);
					}
				}
				for(int j=2;i*j<=n;j++) {
					//이미 지운 수이면 건너뛰기 or 지우지 않았다면(삭제)
					if(arr[i*j]==-1) continue;
					else {
						k--;
						arr[i*j]=-1;
						if(k==0) {
							System.out.println(i*j);
							System.exit(0);
						}
					}
				}
			}
		}
	}
}
