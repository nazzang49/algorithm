package solution;

import java.util.Arrays;
import java.util.Scanner;

//주언이와 사장님에게 각각 n(홀수)장의 임의 숫자가 적힌 카드가 주어지고, 총 n라운드를 통해 임의로 뽑은 카드의 숫자를 비교하며 점수를 얻는게임을 할 때 주언이가 이길 수 있는 경우가 있다면 yes, 없다면 no 출력하기 
public class Q77 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		if(1<=n&&n<=100000) {
			//주언
			int [] person1 = new int[n];
			//사장님
			int [] person2 = new int[n];
			//사용한 카드 체크
			boolean [] visited = new boolean[n];
			//카드 입력
			for(int i=0;i<person1.length;i++) {
				int tmp = sc.nextInt();
				if(0<=tmp&&tmp<=100000) {
					person1[i]=tmp;
				}
			}
			for(int i=0;i<person2.length;i++) {
				int tmp = sc.nextInt();
				if(0<=tmp&&tmp<=100000) {
					person2[i]=tmp;
				}
			}
			//탐색
			//1) 오름차순 정렬
			Arrays.sort(person1);
			Arrays.sort(person2);
			int cnt = 0;
			
			for(int i=0;i<person1.length;i++) {
				for(int j=0;j<person2.length;j++) {
					if(person1[i]<person2[j]&&!visited[j]) {
						visited[j]=true;
						cnt++;
					}
				}
			}
			//승리에 필요한 최소 점수 이상을 획득하면(우승할 수 있는 경우)
			if(cnt>=(n+1)/2) {
				System.out.println("YES");
				System.exit(0);
			}
			System.out.println("NO");
		}
	}
}
