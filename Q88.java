package solution;

import java.util.Scanner;

//a,b,c �� ����� ���� ���ڰ� ���� ������ ī�� ��Ʈ�� �޾��� ��, �� �� �ϳ����� ��� <�ִ밪 - �ּҰ� = ����>�� üũ�� �� ���� �� �ִ� ������ �ּҰ� ���ϱ�
public class Q88 {

	static int [] a_card;
	static int [] b_card;
	static int [] c_card;
	static int answer = Integer.MAX_VALUE;
	
	public static void dfs(int [] arr, int cnt) {
		//3���� ī�带 ��� �� ���
		if(cnt==3) {
			int max = Math.max(Math.max(arr[0], arr[1]), arr[2]);
			int min = Math.min(Math.min(arr[0], arr[1]), arr[2]);
			int penalty = Math.abs(max-min);
			//���� ���̽���� ��� ��
			if(penalty<=answer) {
				answer=penalty;
			}
		}else {
			//b�� �� ����
			if(cnt==1) {
				cnt++;
				for(int i=0;i<b_card.length;i++) {
					arr[cnt-1]=b_card[i];
					dfs(arr,cnt);
				}
			}
			//c�� �� ����
			else {
				cnt++;
				for(int i=0;i<c_card.length;i++) {
					arr[cnt-1]=c_card[i];
					dfs(arr,cnt);
				}
			}
		}
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		
		//������ ���� �� �ִ� ī���� ����
		if(1<=a&&a<=1000&&1<=b&&b<=1000&&1<=c&&c<=1000) {
			a_card = new int[a];
			b_card = new int[b];
			c_card = new int[c];
			int [] arr = new int[3];
			
			//�Է�
			for(int i=0;i<a;i++) {
				int tmp = sc.nextInt();
				if(tmp<=Math.abs(Math.pow(10, 9))) {
					a_card[i]=tmp;
				}
			}
			for(int i=0;i<b;i++) {
				int tmp = sc.nextInt();
				if(tmp<=Math.abs(Math.pow(10, 9))) {
					b_card[i]=tmp;
				}
			}
			for(int i=0;i<c;i++) {
				int tmp = sc.nextInt();
				if(tmp<=Math.abs(Math.pow(10, 9))) {
					c_card[i]=tmp;
				}
			}
			//Ž�� ����
			for(int i=0;i<a;i++) {
				arr[0]=a_card[i];
				dfs(arr,1);
			}
			System.out.println(answer);
		}
	}
}
