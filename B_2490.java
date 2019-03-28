package test_190328;

import java.util.Scanner;

//윷을 던져서 나온 결과를 알파벳으로 출력하기
public class B_2490 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		char [] ans = new char[3];
		for(int i=0;i<3;i++) {
			int deung = 0;
			for(int j=0;j<4;j++) {
				if(sc.nextInt()==1) deung++;
			}
			if(deung==0) ans[i]='D';
			else if(deung==1) ans[i]='C';
			else if(deung==2) ans[i]='B';
			else if(deung==3) ans[i]='A';
			else ans[i]='E';
		}
		//정답 출력
		for(int i=0;i<ans.length;i++) System.out.println(ans[i]);
	}
}
