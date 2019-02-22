package test_190129;

import java.util.Scanner;

//99보다 작거나 같은 정수가 주어질 때, 각 자리의 수를 더해 새로운 수를 만들 시 가장 최초의 수로 돌아오는 사이클 횟수 구하기
public class B_1110 {

	static int n;
	static int cnt = 1;
	
	public static void cycle() {
		int num = n;
		while(true) {
			//A는 num 의미
			String A = "";
			//B는 각 자리 수의 합 의미
			String B = "";
			//str는 새롭게 만들어지는 수 의미
			String str = "";
			int sum = 0;
			A=String.valueOf(num);
			if(num<10) {
				A='0'+A;
			}
			for(int i=0;i<A.length();i++) {
				B+=A.charAt(i);
				sum+=Integer.parseInt(B);
				B="";
			}
			B=String.valueOf(sum);
			if(sum<10) {
				B='0'+B;
			}
			str=""+A.charAt(1)+B.charAt(1);
			num=Integer.parseInt(str);
			if(num==n) {
				break;
			}
			cnt++;
		}
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		if(t<=1000) {
			int [] ans = new int[t];
			int k = 0;
			while(k<t) {
				n = sc.nextInt();
				cycle();
				ans[k]=cnt;
				cnt=0;
				k++;
			}
			for(int i=0;i<ans.length;i++) {
				System.out.println(ans[i]);
			}
		}
	}
}
