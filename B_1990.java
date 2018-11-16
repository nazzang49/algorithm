package test_181116;

import java.util.ArrayList;
import java.util.Scanner;

//주어진 입력값의 범위 내에서 소수임과 동시에 팰린드롬인 자연수 출력
public class B_1990 {

	public static void main(String[] args) {

		//int의 범위는 2,147,483,647 (10의 9승 자리)
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		ArrayList<Integer> list = new ArrayList<>();
		
		//1)소수 판별
		//2)팰린드롬 판별
		if(5<=a&&a<b&&b<=100000000) {
			for(int i=a;i<=b;i++) {
				boolean flag = false;
				for(int j=2;j<=i/2;j++) {
					if(i%j==0) {
						flag=true;
						break;
					}
				}
				//소수인 경우
				if(!flag) {
					String str = String.valueOf(i);
					for(int j=0;j<str.length()/2;j++) {
						//팰린드롬 아닌 경우
						if(str.charAt(j)!=str.charAt(str.length()-1-j)) {
							flag=true;
							break;
						}
					}
					//소수이면서 팰린드롬인 경우
					if(!flag) {
						list.add(i);
					}
				}
			}
			for(int i=0;i<list.size();i++) {
				System.out.println(list.get(i));
			}
			System.out.println(-1);
		}
	}
}
