package test_181114;

import java.util.Arrays;
import java.util.Scanner;

//등차수열을 이루는 정수 4개 중 1개를 까먹었을 때 나머지 세개의 수를 보고 까먹은 정수 구하기
public class B_2997 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int k = sc.nextInt();
		int [] arr = new int[4];
		
		if(-100<=n&&n<=100&&-100<=m&&m<=100&&-100<=k&&k<=100) {
			arr[0]=n;
			arr[1]=m;
			arr[2]=k;
			Arrays.sort(arr);

			//등차수열의 사잇값
			int tmp = arr[2]-arr[1];
			arr[0] = arr[1]-tmp;
			
			System.out.println(arr[0]);
		}
	}
}
