package solution;

import java.util.Scanner;

//입력받은 문자열의 가운데 문자 반환하기(길이가 짝수이면 두글자 반환)
public class Q2 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		if(1<=t&&t<=1000) {
			String [] answer = new String[t];
			int k = 0;
			while(k<t) {
				String str = sc.next();
				if(1<=str.length()&&str.length()<=100) {
					String tmp = "";
					//길이가 짝수이면
					if(str.length()%2==0) {
						tmp=str.substring(str.length()/2-1, str.length()/2+1);
					}
					//길이가 홀수이면
					else {
						tmp+=str.charAt(str.length()/2);
					}
					answer[k]=tmp;
				}else {
					System.out.println("입력 규칙을 확인해주세요.");
					System.exit(0);
				}
				k++;
			}
			for(int i=0;i<answer.length;i++) {
				System.out.println(answer[i]);
			}
		}
	}
}
