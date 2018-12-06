package solution;

import java.util.Scanner;

//�Ա��ɻ縦 �޴µ� �ɸ��� �ɻ���� �ð�, ����� ���� �־��� �� ��� ������� �Ա��ɻ縦 ������ ���µ� �ɸ��� �ּ� �ð� ���ϱ�
//�̺�Ž��(Ư�� ������ ������ �� �ִ� �ο� ���� �ݺ������� ����ϸ� low���� high ���� ����)
public class Q12 {
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] T = new int[N]; 
		int max = 0;
		for(int i=0;i<N;i++){
			T[i] = sc.nextInt();
			if(max < T[i])
				max = T[i];
		}
		long lo = 0;
		long hi = (long)max * M;
		
		while(lo < hi){
			long mid = (lo+hi)/2;
			long total = 0;
			for(int i=0;i<N;i++){
				total += mid/T[i];
			}
			if(total >= M){
				hi = mid;
			} else {
				lo = mid +1;
			}
		}
		System.out.println(lo);
	}
}
