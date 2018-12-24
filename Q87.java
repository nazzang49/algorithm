package solution;

import java.util.Scanner;

//2:2 �״Ͻ� ���� ���� ¥�� �������� �� ȸ���� ���� �Ƿ� ������ �־��� �� ������ ������ ���Ѽ��� �ش�ȭ �ϴ� ��� ���ϱ�
public class Q87 {

	//8�� ȸ���� �Ƿ� ����
	static int [] score = new int[8];
	//������ ���� ���Ѱ��� �ִ�ġ(�Ҽ��� ��°�ڸ����� ��� = �ּ� 0, �ִ� 1)
	static float max = Integer.MIN_VALUE;
	static boolean [] visited = new boolean[8];
	
	public static void dfs(int [] avg, int num) {
		//��� ���� �ϼ��Ǹ�(������ ���� ����)
		if(num==8) {
			float min = Integer.MAX_VALUE;
			float avg1 = 0;
			float avg2 = 0;
			for(int i=0;i<8;i++) {
				if(i%4==0||i%4==1) {
					avg1+=avg[i];
					if(i%4==1) {
						avg1/=2;	
					}
				}else if(i%4==2||i%4==3) {
					avg2+=avg[i];
					if(i%4==3) {
						avg2/=2;	
					}
				}
				//�� ��Ⱑ ����Ǹ�
				if(i%4==3) {
					//�ش� ����� ������ ����
					min = Math.min(1-Math.abs(avg1-avg2)/10, min);
					//���� �ʱ�ȭ
					avg1 = 0;
					avg2 = 0;
				}
			}
			//���� ��ġ�������� ���Ѱ��� ���� ���̽��� ���� 
			if(max<=min) {
				max=min;
			}
		}else {
			num++;
			for(int i=0;i<visited.length;i++) {
				if(!visited[i]) {
					visited[i]=true;
					avg[num-1]=score[i];
					dfs(avg,num);
					visited[i]=false;
				}
			}
		}
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		//�Է�
		for(int i=0;i<8;i++) {
			int tmp = sc.nextInt();
			//�Ƿ� ������ 0�̻� 10���� ����
			if(0<=tmp&&tmp<=10) {
				score[i]=tmp;
			}
		}
		
		int [] avg = new int[8];
		//Ž�� ����(2�� 1��)
		for(int i=0;i<8;i++) {
			visited[i]=true;
			avg[0]=score[i];
			dfs(avg,1);
			visited[i]=false;
		}
		System.out.println(max);
	}
}
