package solution;

import java.util.Arrays;
import java.util.Scanner;

//����Ʈ�� ���� �뷮, ���ε��� ���� ������� ������ �迭�� �־��� �� �ʿ��� ����Ʈ ������ �ּҰ� ���ϱ�
public class Q31 {

	public static int result(int [] weight, int limit) {
		int cnt = 0;
		int sum = 0;
		//�������� ����
		Arrays.sort(weight);
		for(int i=0;i<weight.length;i++) {
			sum+=weight[i];
			if(sum>limit) {
				cnt++;
				sum=0;
				if(i==weight.length-1) {
					cnt++;
					break;
				}
				i--;
			}
			if(i==weight.length-1) {
				cnt++;
				break;
			}
		}
		return cnt;
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		if(1<=n&&n<=50000&&40<=k&&k<=240) {
			int [] weight = new int[n];
			//�Է�
			for(int i=0;i<weight.length;i++) {
				int tmp = sc.nextInt();
				if(40<=tmp&&tmp<=240) {
					weight[i]=tmp;
				}
			}
			//����
			System.out.println(result(weight,k));
		}
	}
}
