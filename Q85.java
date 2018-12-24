package solution;

import java.util.Scanner;

//사칙연산이 숫자1, 연산기호1, 숫자2, 연산기호2, 숫자3 순서로 주어질 때 괄호를 앞쪽, 뒤쪽 두가지 방법으로 씌울 때 얻을 수 있는 연산 결과 출력하기
public class Q85 {
	
	static int num1;
	static int num2;
	static int num3;
	static String o1;
	static String o2;
	
	public static int result(int i) {
		//앞쪽에 괄호를 씌우는 경우
		if(i==0) {
			int tmp = 0;
			if(o1.equals("+")) {
				tmp = num1+num2;
			}else if(o1.equals("-")) {
				tmp = num1-num2;
			}else if(o1.equals("*")) {
				tmp = num1*num2;
			}else {
				tmp = num1/num2;
			}
			if(o2.equals("+")) {
				tmp = tmp+num3;
			}else if(o2.equals("-")) {
				tmp = tmp-num3;
			}else if(o2.equals("*")) {
				tmp = tmp*num3;
			}else {
				tmp = tmp/num3;
			}
			return tmp;
		}
		//뒤쪽에 괄호를 씌우는 경우
		else {
			int tmp = 0;
			if(o2.equals("+")) {
				tmp = num2+num3;
			}else if(o2.equals("-")) {
				tmp = num2-num3;
			}else if(o2.equals("*")) {
				tmp = num2*num3;
			}else {
				tmp = num2/num3;
			}
			if(o1.equals("+")) {
				tmp = num1+tmp;
			}else if(o1.equals("-")) {
				tmp = num1-tmp;
			}else if(o1.equals("*")) {
				tmp = num1*tmp;
			}else {
				tmp = num1/tmp;
			}
			return tmp;
		}
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		num1 = sc.nextInt();
		o1 = sc.next();
		num2 = sc.nextInt();
		o2 = sc.next();
		num3 = sc.nextInt();
		
		int [] answer = new int[2];
		
		int i = 0;
		while(i<2) {
			answer[i]=result(i);
			i++;
		}
		System.out.println(answer[0]);
		System.out.println(answer[1]);
	}
}
