package solution;

import java.util.Scanner;

//n아래의 자연수 중 각 자리의 숫자를 순환시켜도 소수인 circular prime 구하기
public class Q53 {
	
	//소수인지 판별해줄 메소드
	public static int result(int n) {
		boolean flag = false;
		for(int i=2;i<=n/2;i++) {
			if(n%i==0) {
				flag = true;
				break;
			}
		}
		//소수이면+1
		if(!flag) {
			return 1;
		}
		//소수가 아니면+0
		else {
			return 0;	
		}
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int answer = 0;
		
		if(2<=n&&n<=6) {
			n = (int)Math.pow(10, n);
			for(int i=2;i<=n;i++) {
				if(i%10==0) {
					continue;
				}
				if(2<=i&&i<=9) {
					if(result(i)==1) {
						answer++;
					}
					continue;
				}
				int tmp = i;
				String str = String.valueOf(i);
				char [] arr = str.toCharArray();
				int cnt = 0;
				for(int j=0;j<str.length();j++) {
					cnt += result(tmp);
					char a = ' ';
					for(int k=0;k<arr.length;k++) {
						if(k==0) {
							a=arr[0];
							arr[k]=arr[k+1];
						}else if(k<arr.length-1) {
							arr[k]=arr[k+1];
						}else {
							arr[k]=a;
						}
						tmp = Integer.parseInt(new String(arr));
					}
				}
				//circular prime인 숫자
				if(cnt==str.length()) {
					answer++;
				}
			}
			System.out.println(answer);
		}
	}
}
