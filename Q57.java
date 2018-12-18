package solution;

import java.util.ArrayList;

//3797 �Ҽ��� ���� �����ʿ��� ���ڸ� �ϳ��� ����ų� ���ʿ��� ���ڸ� �ϳ��� �������� �� �� ���� ��� �Ҽ��� ��� ���ϱ�(�� 11��)
public class Q57 {

	//�Ҽ����� �Ǻ��ϴ� �޼ҵ�
	public static boolean sosoo(long n) {
		if(n==1) {
			return false;
		}else {
			boolean flag = false;
			for(long i=2;i<=n/2;i++) {
				if(n%i==0) {
					flag=true;
					break;
				}
			}
			if(!flag) {
				return true;
			}
			return false;	
		}
	}

	//���ʺ��� ����������
	public static boolean left(String left) {
		long tmp = 0;
		String str = "";
		boolean flag = false;
		for(int i=left.length()-1;i>=0;i--) {
			str=left.charAt(i)+str;
			tmp = Integer.parseInt(str);
			flag = sosoo(tmp);
			if(!flag) {
				return false;
			}
		}
		return true;
	}
	
	//�����ʺ��� ����������
	public static boolean right(String right) {
		long tmp = 0;
		String str = "";
		boolean flag = false;
		for(int i=0;i<right.length();i++) {
			str+=right.charAt(i);
			tmp = Integer.parseInt(str);
			flag = sosoo(tmp);
			if(!flag) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {

		ArrayList<Long> answer = new ArrayList<>();
		
		long k = 10;
		while(true) {
			boolean flag = false;
			for(long i=2;i<=k/2;i++) {
				if(k%i==0) {
					flag=true;
					break;
				}
			}
			//�Ҽ��̸� Ž�� ����
			if(!flag) {
				String str = String.valueOf(k);
				boolean flag_left = left(str);
				boolean flag_right = right(str);
				if(flag_left&&flag_right) {
					answer.add(k);
				}
			}
			if(answer.size()==10) {
				break;
			}
			k++;
		}
		//�� ����ϱ�
		for(int i=0;i<answer.size();i++) {
			System.out.println(answer.get(i));
		}
	}
}
