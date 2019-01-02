package solution;

import java.util.Scanner;

//자릿수 정렬 알고리즘(각 자릿수의 합을 오름차순 기준으로 정렬) 작성하기
public class Q120 {
	
	public static int result(int n) {
		String str = String.valueOf(n);
		String tmp = "";
		int sum = 0;
		
		for(int i=0;i<str.length();i++) {
			tmp+=str.charAt(i);
			sum+=Integer.parseInt(tmp);
			tmp="";
		}
		
		return sum;
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		if(1<=n&&n<=1000) {
			int [] arr = new int[n];
			int [] answer = new int[n];
			
			//정수 입력
			for(int i=0;i<n;i++) {
				int tmp = sc.nextInt();
				if(1<=tmp&&tmp<=1000) {
					arr[i]=tmp;
					answer[i]=result(arr[i]);
				}
			}
			
			//오름차순 정렬(by 버블)
			for(int i=0;i<n;i++) {
				for(int j=0;j<n-1;j++) {
					if(answer[j]>answer[j+1]) {
						int tmp1 = answer[j];
						answer[j]=answer[j+1];
						answer[j+1]=tmp1;
						
						int tmp2 = arr[j];
						arr[j]=arr[j+1];
						arr[j+1]=tmp2;
					}
				}
			}
			
			for(int i=0;i<n;i++) {
				System.out.println(arr[i]);
			}
		}
	}
}
