package solution1;

import java.util.Scanner;

//�ѱ����� ���̸� ����ϴ� ����� �� ����, ���� ����, �� ���� ������ ��� ����ϱ�
public class Q110 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		//�������
		int year = sc.nextInt();
		int month = sc.nextInt();
		int day = sc.nextInt();
		
		//���̸� ����ϰ��� �ϴ� ���� ����
		int now_y = sc.nextInt();
		int now_m = sc.nextInt();
		int now_d = sc.nextInt();
		
		//������ ���ʴ�� ������ �迭
		int [] answer = new int[3];
		
		int i = 0;
		while(i<3) {
			//�� ���� ���
			if(i==0) {
				if(now_m>=month) {
					if(now_d>=day) {
						answer[i]=now_y-year;		
					}else {
						if(now_y-year-1<=0) {
							answer[i]=0;
						}else {
							answer[i]=now_y-year-1;
						}
					}
				}else {
					if(now_y-year-1<=0) {
						answer[i]=0;
					}else {
						answer[i]=now_y-year-1;
					}
				}
			}
			//�Ϲ����� ���� ���
			else if(i==1) {
				answer[i]=now_y-year+1;
			}
			//���� ���� ���
			else {
				answer[i]=now_y-year;
			}
			i++;
		}
		
		//���� ���
		for(int j=0;j<answer.length;j++) {
			System.out.println(answer[j]);
		}
	}
}
