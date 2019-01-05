package solution;

import java.util.ArrayList;
import java.util.Scanner;

//원을 둘러 앉아 있는 사람들 중 n번째 인원을 반복 제거하는 조세퍼스 순열 구하기
public class Q135 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		if(1<=m&&m<=n&&n<=5000) {
			ArrayList<Integer> list = new ArrayList<>();
			StringBuilder sb = new StringBuilder();
			
			//자연수 입력
			for(int i=1;i<=n;i++) {
				list.add(i);
			}
			
			int idx = 0;
			while(!list.isEmpty()) {
				idx+=m-1;
				//인덱스가 배열 크기 넘어가면(인덱스 조정)
				if(idx>=list.size()) {
					idx%=list.size();
				}
				sb.append(list.remove(idx)+" ");
			}
			System.out.println(sb.toString());
		}
	}
}
