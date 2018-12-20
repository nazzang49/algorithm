package solution;

import java.util.Scanner;

//����� �갣�� ��, �� ��Ҹ� �մ� ��� �̵� �ð��� �־��� �� ���� �갣���� ���� ���� ���ƿ��� �� ���ϱ�
public class Q71 {

	static int n;
	static String [] start;
	static String [] end;
	static int [] time;
	static int min = Integer.MAX_VALUE;
	static int answer = 0;
	static String answer_str = "";
	
	public static void dfs(int idx, int sum) {
		//���� �������� �갣�̸�
		if(end[idx].equals("Z")) {
			if(sum<=min) {
				min=sum;
				answer_str=start[answer];
			}
		}else {
			for(int i=0;i<n;i++) {
				//�߰� ���� = ���ο� ���� ����
				if(end[idx].equals(start[i])) {
					sum+=time[i];
					dfs(i,sum);
					sum-=time[i];
				}
			}
		}
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		//���� ����
		n = sc.nextInt();
		
		if(1<=n&&n<=10000) {
			start = new String[n];
			end = new String[n];
			time = new int[n];
			//�Է�
			for(int i=0;i<n;i++) {
				String a = sc.next();
				String b = sc.next();
				int tmp = sc.nextInt();
				if(1<=tmp&&tmp<=1000) {
					start[i]=a;
					end[i]=b;
					time[i]=tmp;
				}
			}
			//Ž��
			for(int i=0;i<n;i++) {
				//�빮���� ��쿡�� Ž�� ����(���忡 �ִ� ��)
				if('A'<=start[i].charAt(0)&&start[i].charAt(0)<='Z') {
					answer=i;
					dfs(i,time[i]);
				}
			}
			System.out.println(answer_str);
			System.out.println(min);
		}
	}
}
