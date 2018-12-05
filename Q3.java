package solution;

import java.util.Scanner;

//다리 길이와 다리가 견딜 수 있는 무게가 주어질 때, 모든 트럭들이 통과하는데 걸리는 최소 시간 구하기(트럭은 1초에 1만큼 움직임)
public class Q3 {

	//모든 트럭들이 순서대로 다리를 건너는데 걸리는 시간 반환
	public static int min(int length, int weight, int [] truck) {
		//시간 변수
		int cnt = 0;
		//트럭 무게의 합
		int sum = 0;
		//함께 이동 가능한 트럭 대수
		int pack = 0;
		for(int i=0;i<truck.length;i++) {
			sum+=truck[i];
			if(sum<=weight) {
				pack++;
				if(i==truck.length-1) {
					cnt+=(length+pack);
				}
			}else {
				//함께 이동 가능한 트럭 대수가 다리 길이보다 짧으면
				if(pack<=length) {
					i--;
					cnt+=(length+pack-1);
				}
				//함께 이동 가능한 트럭 대수가 다리 길이보다 길면
				else {
					cnt+=(2*length-1);
					i-=(pack-length+1);
				}
				sum=0;
				pack=0;
			}
		}
		
		return cnt;
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		//트럭 대수 입력
		int n = sc.nextInt();
		int length = sc.nextInt();
		int weight = sc.nextInt();
		int [] truck = new int[n];
		if(1<=n&&n<=10000) {
			for(int i=0;i<truck.length;i++) {
				int tmp = sc.nextInt();
				//모든 트럭의 무게는 다리가 견딜 수 있는 무게 이하
				if(1<=tmp&&tmp<=weight) {
					truck[i]=tmp;
				}
			}	
		}else {
			System.out.println("입력값 규칙을 확인하세요.");
			System.exit(0);
		}
		if(1<=length&&length<=10000&&1<=weight&&weight<=10000) {
			System.out.println(min(length, weight, truck));	
		}
	}
}
