package solution;

import java.util.ArrayList;
import java.util.Scanner;

//개발팀에서 배포해야 할 작업의 진도 상황과 배포 순서가 주어질 때, 어떠한 형태로 배포가 완료되는지 출력하기
public class Q19 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		ArrayList<Integer> answer = new ArrayList<>();
		
		//배포는 하루에 한번만 가능(100% 초과면 배포되는 날)
		if(1<=n&&n<=100) {
			int [] task = new int[n];
			int [] speed = new int[n];
			//작업이 완성되는데 걸리는 시간
			int [] finish = new int[n];
			
			//입력
			for(int i=0;i<task.length;i++) {
				int tmp = sc.nextInt();
				if(1<=tmp&&tmp<=100) {
					task[i]=tmp;
				}
			}
			for(int i=0;i<task.length;i++) {
				int tmp = sc.nextInt();
				if(1<=tmp&&tmp<=100) {
					speed[i]=tmp;
					if((100-task[i])/speed[i]==0) {
						finish[i]=(100-task[i])/speed[i];
					}else {
						finish[i]=(100-task[i])/speed[i]+1;
					}
				}
			}
			//탐색
			for(int i=0;i<finish.length-1;i++) {
				int cnt = 1;
				for(int j=i+1;j<finish.length;j++) {
					if(finish[i]>=finish[j]) {
						cnt++;
						//마지막까지 한번에 배포된다면
						if(j==finish.length-1) {
							answer.add(cnt);
							i=finish.length;
						}
					}else {
						answer.add(cnt);
						//다음 비교값이 될 지점부터 다시 탐색 시작
						i=j-1;
						//다음 비교값이 마지막 idx면
						if(j==finish.length-1) {
							answer.add(1);
						}
						break;
					}
				}
			}
			for(int i=0;i<answer.size();i++) {
				System.out.println(answer.get(i));
			}
		}
	}
}
