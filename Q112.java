package solution1;

import java.util.Scanner;

//요리를 시작하는 시간, 요리하는데 걸리는 시간이 초 단위로 주어질 때 요리가 끝나는 시각 출력하기
public class Q112 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int si = sc.nextInt();
		int boon = sc.nextInt();
		int cho = sc.nextInt();
		int need = sc.nextInt();
		
		if(0<=si&&si<=23&&0<=boon&&boon<=59&&0<=cho&&cho<=59&&0<=need&&need<=500000) {
			int tmp1 = need/60;
			int tmp2 = need%60;
			
			int hour = si;
			int minute = boon;
			int second = cho;
			//분에서 끝나는 경우
			if(tmp1<=59) {
				//1시간이 추가되는 경우
				if(boon+tmp1>59) {
					if(hour==23) {
						hour=0;
					}else {
						hour++;
					}
					minute=tmp1+boon-60;
					//1분이 추가되는 경우
					if(tmp2+cho>59) {
						minute++;
						second=tmp2+cho-60;
					}else {
						second+=tmp2;
					}
				}
				//1시간 추가되지 않는 경우
				else {
					minute+=tmp1;
					//1분이 추가되는 경우
					if(tmp2+cho>59) {
						minute++;
						second=tmp2+cho-60;
					}else {
						second+=tmp2;
					}
				}
			}
			//1시간 이상 걸리는 경우(3600초 이상)
			else {
				//분 추가
				int tmp3 = tmp1%60;
				//시 추가
				tmp1/=60;
				//초 추가
				tmp2=need%60;
				if(hour+tmp1>23) {
					hour=hour+tmp1-24;
				}else {
					hour+=tmp1;
				}
				//1시간이 추가되는 경우
				if(boon+tmp3>59) {
					if(hour==23) {
						hour=0;
					}else {
						hour++;
					}
					minute=tmp3+boon-60;
					//1분이 추가되는 경우
					if(tmp2+cho>59) {
						minute++;
						second=tmp2+cho-60;
					}else {
						second+=tmp2;
					}
				}
				//1시간 추가되지 않는 경우
				else {
					minute+=tmp2;
					//1분이 추가되는 경우
					if(tmp2+cho>59) {
						minute++;
						second=tmp2+cho-60;
					}else {
						second+=tmp2;
					}
				}
			}
			System.out.println(hour);
			System.out.println(minute);
			System.out.println(second);
		}
	}
}
