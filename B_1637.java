package test_190114;

import java.util.ArrayList;
import java.util.Scanner;

//규칙에 맞게 입력되는 정수더미가 주어질 때, 그 속에서 홀수개 존재하는 정수와 그 갯수 출력하기
public class B_1637 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		//정수더미 담을 가변배열
		ArrayList<Integer> list = new ArrayList<>();
		
		if(1<=n&&n<=20000) {
			int k = 0;
			while(k<n) {
				int tmp1 = sc.nextInt();
				int tmp2 = sc.nextInt();
				int tmp3 = sc.nextInt();
				list.add(tmp1);
				//정수더미 입력
				for(int i=1;tmp1+tmp3*i<=tmp2;i++) {
					list.add(tmp1+tmp3*i);
				}
				k++;
			}
			//존재하는 같은 정수의 갯수
			int cnt = 0;
			for(int i=0;i<list.size()-1;i++) {
				cnt++;
				for(int j=i+1;j<list.size();j++) {
					if(list.get(i)==list.get(j)) {
						cnt++;
					}
				}
				if(cnt%2==1) {
					System.out.println(list.get(i));
					System.out.println(cnt);
					break;
				}
				cnt=0;
			}
		}
	}
}
