package solution1;

import java.util.ArrayList;
import java.util.Scanner;

//입력 문자열의 길이 n, 덧붙일 수 있는 글자 수 k가 주어질 때 확보 가능한 최대 길이의 패턴 문자열 길이 출력하기
public class Q96 {
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		ArrayList<Character> list = new ArrayList<>();
		
		if(1<=n&&n<=100000&&0<=k&&k<=100000) {
			String str = sc.next();
			if(str.length()==n) {
				if(n==k) {
					System.out.println(n);
					System.exit(0);
				}
				//반복패턴의 길이는 모두 같기 때문에 결국 (n+k의 약수)길이들만이 조건에 성립함
				for(int i=(n+k)/2;i>=1;i--) {
					//나누어지는 경우만 체크
					if((n+k)%i==0) {
						//반복패턴 저장
						for(int j=0;j<i;j++) {
							list.add(str.charAt(j));
						}
						int cnt = 1;
						while(cnt<(n+k)/i) {
							if(str.length()-i*cnt<=i) {
								boolean flag = false;
								for(int m=i*cnt;m<str.length();m++) {
									//다른 문자가 있으면(패턴 반복 실패)
									if(list.get(m-i*cnt)!=str.charAt(m)) {
										flag = true;
										break;
									}
								}
								if(!flag) {
									System.out.println(i);
									System.exit(0);
								}else {
									break;
								}
							}else {
								boolean flag = false;
								for(int m=i*cnt;m<i*cnt+i;m++) {
									//다른 문자가 있으면(패턴 반복 실패)
									if(list.get(m-i*cnt)!=str.charAt(m)) {
										flag = true;
										break;
									}
								}
								if(flag) {
									break;
								}
							}
							cnt++;
						}
						list.clear();
					}
				}
				System.out.println(0);
				System.exit(0);
			}
		}
	}
}
