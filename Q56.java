package solution;

import java.util.Scanner;

//1�� ������ �� �� ��Ī���� ���� ���ϴ� ����ũ�� ���� ���� ���ϱ�(50�� �̸� �ݺ��� ���� ��Ī���� ���� ������ ����ũ�� ���� ����)
public class Q56 {

	//�ΰ��� ���� �տ��� ������ �޼ҵ�
	public static long sum(long x) {
		String x_str = String.valueOf(x);
		String y_str = "";
		//�ڿ������� ���ʴ�� ���� ����
		for(int i=x_str.length()-1;i>=0;i--) {
			y_str+=x_str.charAt(i);
		}
		long y = Long.parseLong(y_str);
		
		return x+y;
	}
	
	//��Ī������ �ƴ��� �Ǻ��ϴ� �޼ҵ�
	public static boolean result(long n) {
		String str = String.valueOf(n);
		boolean flag = false;
		for(int i=0;i<str.length()/2;i++) {
			//���� ���������� ��Ī�� ��ġ�� �ִ� ���ڰ� ���� �������� Ȯ��
			if(str.charAt(i)!=str.charAt(str.length()-1-i)) {
				flag = true;
				break;
			}
		}
		//��Ī���̸� true ��ȯ
		if(!flag) {
			return true;
		}else {
			return false;
		}
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int answer = 0;
		
		for(int i=1;i<10000;i++) {
			//�ݺ� Ƚ�� ������ ����
			int cnt = 0;
			//��Ī�� �Ǻ� ����� ������ ����
			boolean flag = false;
			//�ʱⰪ
			long tmp1 = i;
			//�ִ� �ݺ� Ƚ���� 50ȸ �̸�
			while(!flag||cnt<50) {
				tmp1 = sum(tmp1);
				flag = result(tmp1);
				cnt++;
			}
			if(flag) {
				answer++;
			}
		}
		System.out.println(answer);
	}
}
