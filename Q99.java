package solution;

import java.util.Arrays;
import java.util.Scanner;

//n개의 아케인스톤, 아케인스톤을 얻을 때 부여받는 경험치, 동시에 활성화 시킬 수 있는 아케인스톤의 개수가 주어질 때 얻을 수 있는 경험치의 최대값 구하기
//활성화 되어 있는 아케인스톤에만 경험치가 누적된다는 것 유념
public class Q99 {

	//각 스톤별 경험치
	static int [] stone;
	//최대값
	static int max = 0;
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		//전체 아케인스톤 개수
		int n = sc.nextInt();
		//동시 활성 가능한 아케인스톤 개수
		int k = sc.nextInt();
		
		if(1<=k&&k<=n&&n<=3*Math.pow(10, 5)) {
			stone = new int[n];
			//각 스톤을 얻을 때 부여받는 경험치 입력
			for(int i=0;i<n;i++) {
				int tmp = sc.nextInt();
				if(0<=tmp&&tmp<=Math.pow(10, 8)) {
					stone[i]=tmp;
				}
			}
			//오름차순 정렬
			Arrays.sort(stone);
			//탐색 실행
			for(int i=0;i<k;i++) {
				//모든 스톤을 활성화 시킬 수 있다면(=마지막 스톤 경험치도 개별 획득 가능)
				if(i==stone.length-1) {
					max+=stone[i];
					break;
				}
				stone[i]=0;
				for(int j=i+1;j<stone.length;j++) {
					stone[i]+=stone[j];
				}
				max+=stone[i];
			}
			System.out.println(max);
		}
	}
}
