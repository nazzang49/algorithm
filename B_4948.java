package test_190218;

import java.util.ArrayList;
import java.util.Scanner;

//����Ʈ�� ����(n���� ũ��, 2n���� �۰ų� ���� �� �� �ݵ�� �ϳ��� �Ҽ��� �����Ѵٴ� ��Ģ)�� �ǰ�, �ش� ���� �� �Ҽ��� ���� ���ϱ�
public class B_4948 {

	//�����佺�׳׽��� ü Ȱ��(1~2n������ �� �� �Ҽ��� �ƴ� ���� 0���� ����)
	public static int result(int n) {
		int cnt = 0;
		int [] d = new int[n+1];
		//�ڱ� �ڽ����� �ʱ�ȭ
		for(int i=1;i<=n;i++) {
			d[i]=i;
		}
		//2���� Ž�� ����
		for(int i=2;i<=n;i++) {
			//�̹� ������ ���� �ǳʶٱ�
			if(d[i]==0) continue;
			//i�� ����� �Ǵ� �ڸ��� ���ڸ� 0���� ����
			for(int j=2;i*j<=n;j++) {
				d[i*j]=0;
			}
		}
		//�Ҽ� ���� ����
		for(int i=n/2+1;i<=n;i++) {
			if(d[i]!=0) cnt++;
		}
		return cnt;
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> ans = new ArrayList<>();
		
		while(true) {
			int n = sc.nextInt();
			if(n==0) {
				break;
			}
			ans.add(result(2*n));
		}
		//���� ���
		for(int i=0;i<ans.size();i++) {
			System.out.println(ans.get(i));
		}
	}
}
