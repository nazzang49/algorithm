package solution;

import java.util.Arrays;
import java.util.Scanner;

//i부터 j idx까지 자르고 정렬하였을 때, k번째 있는 숫자 출력하기
public class Q27 {

	public static int [] result(int [] arr, int [][] commands) {
		int [] answer = new int[commands.length];
		for(int i=0;i<answer.length;i++) {
			int m = commands[i][0];
			int n = commands[i][1];
			int k = commands[i][2];
			int [] tmp = new int[n-m+1];
			for(int j=m-1;j<=n-1;j++) {
				tmp[j+1-m]=arr[j];
			}
			Arrays.sort(tmp);
			answer[i]=tmp[k-1];
		}
		return answer;
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int c = sc.nextInt();
		
		if(1<=n&&n<=100&&1<=c&&c<=50) {
			int [] arr = new int[n];
			int [][] commands = new int[c][3];
			//입력
			for(int i=0;i<arr.length;i++) {
				arr[i]=sc.nextInt();
			}
			for(int i=0;i<commands.length;i++) {
				commands[i][0]=sc.nextInt();
				commands[i][1]=sc.nextInt();
				commands[i][2]=sc.nextInt();
			}
			//실행
			int [] answer = result(arr,commands);
			for(int i=0;i<answer.length;i++) {
				System.out.print(answer[i]+" ");
			}
		}
	}
}
