package test_181203;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

//�غ��̰� ���� �� �ִ� �м� �������� ������ �־��� �� �˸��� �ƴ� ���·� ���ƴٴ� �� �ִ� �ϼ� ���ϱ�
public class B_9375 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int n = 0;
		int [] answer = new int[t];
		//���� ������ ����� ��
		int cnt = 0;
		
		if(0<=t&&t<=30) {
			int k=0;
			while(k<t) {
				n=sc.nextInt();
				//�ּ� �־����� �������� ������ŭ ���� ����
				cnt=n;
				String [] cate = new String[n];
				//�ߺ��Ǵ� ������ ������ ���� ����
				ArrayList<Integer> list = new ArrayList<>();
				for(int i=0;i<n*2;i++) {
					String str = sc.next();
					if(i%2==1) {
						cate[i/2]=str;
					}
				}
				Arrays.sort(cate);
				
				int tmp = 1;
				boolean flag = false;
				for(int i=0;i<cate.length-1;i++) {
					//������ ������ �޶����� ���� �ߺ� ���� ����
					if(!cate[i].equals(cate[i+1])) {
						list.add(tmp);
						tmp=1;
						flag=true;
					}else {
						tmp++;
					}
				}
				//��� ���� ������ �ƴ� ��� ������ ������ �ߺ� ���� ����
				if(flag) {
					list.add(tmp);
				}
				//���� ��Ȱ��
				tmp=1;
				for(int i=0;i<list.size();i++) {
					tmp*=list.get(i);
				}
				if(flag) {
					answer[k]=cnt+tmp;	
				}else {
					answer[k]=cnt;
				}
				//Ƚ�� �ʱ�ȭ
				cnt=0;
				list.clear();
				k++;
			}
			for(int i=0;i<answer.length;i++) {
				System.out.println(answer[i]);
			}
		}
	}
}
