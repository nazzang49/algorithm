package solution;

import java.util.Scanner;

//0~9까지의 숫자가 임의로 저장되어 있는 배열에서 연속적으로 나타나는 수가 있을 때 하나만 남기고 삭제할 시 최종 배열의 형태 구하기
public class Q17 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		if(1<=n&&n<=1000000) {
			int [] arr = new int[n];
			boolean [] visited = new boolean[10];
			for(int i=0;i<arr.length;i++) {
				int tmp = sc.nextInt();
				if(0<=tmp&&tmp<=9) {
					arr[i]=tmp;
				}
			}
			for(int i=0;i<arr.length;i++) {
				//연속으로 등장하면 10으로 변경
				if(visited[arr[i]]) {
					//그 다음 숫자가 달라질 때(visited 초기화)
					if(i!=arr.length-1) {
						if(arr[i]!=arr[i+1]) {
							visited[arr[i]]=false;
						}
					}
					arr[i]=10;
				}else {
					visited[arr[i]]=true;
				}
			}
			//남아있는 수 출력
			for(int i=0;i<arr.length;i++) {
				if(arr[i]!=10) {
					System.out.print(arr[i]+" ");
				}
			}
		}
	}
}
