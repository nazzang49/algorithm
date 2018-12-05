package solution;

import java.util.Scanner;

//�ٸ� ���̿� �ٸ��� �ߵ� �� �ִ� ���԰� �־��� ��, ��� Ʈ������ ����ϴµ� �ɸ��� �ּ� �ð� ���ϱ�(Ʈ���� 1�ʿ� 1��ŭ ������)
public class Q3 {

	//��� Ʈ������ ������� �ٸ��� �ǳʴµ� �ɸ��� �ð� ��ȯ
	public static int min(int length, int weight, int [] truck) {
		//�ð� ����
		int cnt = 0;
		//Ʈ�� ������ ��
		int sum = 0;
		//�Բ� �̵� ������ Ʈ�� ���
		int pack = 0;
		for(int i=0;i<truck.length;i++) {
			sum+=truck[i];
			if(sum<=weight) {
				pack++;
				if(i==truck.length-1) {
					cnt+=(length+pack);
				}
			}else {
				//�Բ� �̵� ������ Ʈ�� ����� �ٸ� ���̺��� ª����
				if(pack<=length) {
					i--;
					cnt+=(length+pack-1);
				}
				//�Բ� �̵� ������ Ʈ�� ����� �ٸ� ���̺��� ���
				else {
					cnt+=(2*length-1);
					i-=(pack-length+1);
				}
				sum=0;
				pack=0;
			}
		}
		
		return cnt;
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		//Ʈ�� ��� �Է�
		int n = sc.nextInt();
		int length = sc.nextInt();
		int weight = sc.nextInt();
		int [] truck = new int[n];
		if(1<=n&&n<=10000) {
			for(int i=0;i<truck.length;i++) {
				int tmp = sc.nextInt();
				//��� Ʈ���� ���Դ� �ٸ��� �ߵ� �� �ִ� ���� ����
				if(1<=tmp&&tmp<=weight) {
					truck[i]=tmp;
				}
			}	
		}else {
			System.out.println("�Է°� ��Ģ�� Ȯ���ϼ���.");
			System.exit(0);
		}
		if(1<=length&&length<=10000&&1<=weight&&weight<=10000) {
			System.out.println(min(length, weight, truck));	
		}
	}
}
