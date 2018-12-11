package solution;

import java.util.Arrays;
import java.util.Scanner;

//��� �������� ���� �ο� Ƚ���� �迭�� �־��� ��, h-index �� ���ϱ�
public class Q33 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		if(1<=n&&n<=1000) {
			int [] docu = new int[n];
			//�Է�
			for(int i=0;i<docu.length;i++) {
				int tmp = sc.nextInt();
				if(0<=tmp&&tmp<=10000) {
					docu[i]=tmp;
				}
			}
			//����
			//�������� ����
			Arrays.sort(docu);
			//�̺� Ž��
			int low = docu[0];
			int high = docu[docu.length-1];
			int mid = 0;
			int answer = 0;
			while(low<high) {
				mid = (low+high)/2;
				int cnt = 0;
				for(int i=docu.length-1;i>=0;i--) {
					if(mid<=docu[i]) {
						cnt++;
					}else {
						break;
					}
				}
				//�� �� = ���� ��(���� �����ϴ� �ִ� ��)
				if(cnt==mid) {
					answer = mid;
					break;
				}
				//������ ����(���� ������ ���� ��)
				else if(cnt<mid) {
					high=mid;
				}
				//������ ����(���� ������ ū ��)
				else {
					low=mid+1;
				}
			}
			System.out.println(answer);
		}
	}
}
