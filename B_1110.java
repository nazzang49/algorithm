package test_190129;

import java.util.Scanner;

//99���� �۰ų� ���� ������ �־��� ��, �� �ڸ��� ���� ���� ���ο� ���� ���� �� ���� ������ ���� ���ƿ��� ����Ŭ Ƚ�� ���ϱ�
public class B_1110 {

	static int n;
	static int cnt = 1;
	
	public static void cycle() {
		int num = n;
		while(true) {
			//A�� num �ǹ�
			String A = "";
			//B�� �� �ڸ� ���� �� �ǹ�
			String B = "";
			//str�� ���Ӱ� ��������� �� �ǹ�
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
