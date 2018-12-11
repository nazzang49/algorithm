package solution;

import java.util.Scanner;
import java.util.Stack;

//���� �а��� ��, �а��� ���� ����, 	���� ������ �а��� ���� �迭�� �־��� �� �ּ����� �������� ������ ��� �� �ִ� Ƚ�� ���ϱ�
public class Q32 {

	public static int result(int [] date, int [] supply, int n, int k) {
		int answer = 0;
		//��ü �а����(���� ��+���ο� ����)
		int flour = n;
		int time = n;
		int idx = 0;
		Stack<Integer> st = new Stack<>();
		//��ü �� > ���߾� �ϴ� �ϼ� -> �ݺ� ����(�� �̻� ���� ��� ��)
		while(flour>k) {
			//��� �����Ǹ� ���� �ʿ�
			if(time==0) {
				flour+=st.peek();
				time+=st.peek();
				st.pop();
				answer++;
			}
			//���� ������ ������ �� ���
			if(idx<date.length&&date[idx]<=flour) {
				st.push(supply[idx]);
				idx++;
			}
			//��ƿ �� �ִ� �ϼ� ����(1�� 1�� �Һ�)
			time--;
		}
		
		
		return answer;
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int m = sc.nextInt();
		
		if(1<=n&&n<=100000&&1<=k&&k<=100000&&1<=m&&m<=20000) {
			//���� ���� �迭
			int [] date = new int[m];
			//�� ������ ���� ���ɷ�
			int [] supply = new int[m];
			//�Է�
			for(int i=0;i<date.length;i++) {
				int tmp1 = sc.nextInt();
				int tmp2 = sc.nextInt();
				if(1<=tmp1&&tmp1<=k) {
					date[i]=tmp1;
					supply[i]=tmp2;
				}
			}
			//����
			result(date, supply, n, k);
		}
	}	
}
