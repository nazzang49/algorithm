package solution1;

import java.util.Scanner;

//�丮�� �����ϴ� �ð�, �丮�ϴµ� �ɸ��� �ð��� �� ������ �־��� �� �丮�� ������ �ð� ����ϱ�
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
			//�п��� ������ ���
			if(tmp1<=59) {
				//1�ð��� �߰��Ǵ� ���
				if(boon+tmp1>59) {
					if(hour==23) {
						hour=0;
					}else {
						hour++;
					}
					minute=tmp1+boon-60;
					//1���� �߰��Ǵ� ���
					if(tmp2+cho>59) {
						minute++;
						second=tmp2+cho-60;
					}else {
						second+=tmp2;
					}
				}
				//1�ð� �߰����� �ʴ� ���
				else {
					minute+=tmp1;
					//1���� �߰��Ǵ� ���
					if(tmp2+cho>59) {
						minute++;
						second=tmp2+cho-60;
					}else {
						second+=tmp2;
					}
				}
			}
			//1�ð� �̻� �ɸ��� ���(3600�� �̻�)
			else {
				//�� �߰�
				int tmp3 = tmp1%60;
				//�� �߰�
				tmp1/=60;
				//�� �߰�
				tmp2=need%60;
				if(hour+tmp1>23) {
					hour=hour+tmp1-24;
				}else {
					hour+=tmp1;
				}
				//1�ð��� �߰��Ǵ� ���
				if(boon+tmp3>59) {
					if(hour==23) {
						hour=0;
					}else {
						hour++;
					}
					minute=tmp3+boon-60;
					//1���� �߰��Ǵ� ���
					if(tmp2+cho>59) {
						minute++;
						second=tmp2+cho-60;
					}else {
						second+=tmp2;
					}
				}
				//1�ð� �߰����� �ʴ� ���
				else {
					minute+=tmp2;
					//1���� �߰��Ǵ� ���
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
