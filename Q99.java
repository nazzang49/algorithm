package solution;

import java.util.Arrays;
import java.util.Scanner;

//n���� �����ν���, �����ν����� ���� �� �ο��޴� ����ġ, ���ÿ� Ȱ��ȭ ��ų �� �ִ� �����ν����� ������ �־��� �� ���� �� �ִ� ����ġ�� �ִ밪 ���ϱ�
//Ȱ��ȭ �Ǿ� �ִ� �����ν��濡�� ����ġ�� �����ȴٴ� �� ����
public class Q99 {

	//�� ���溰 ����ġ
	static int [] stone;
	//�ִ밪
	static int max = 0;
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		//��ü �����ν��� ����
		int n = sc.nextInt();
		//���� Ȱ�� ������ �����ν��� ����
		int k = sc.nextInt();
		
		if(1<=k&&k<=n&&n<=3*Math.pow(10, 5)) {
			stone = new int[n];
			//�� ������ ���� �� �ο��޴� ����ġ �Է�
			for(int i=0;i<n;i++) {
				int tmp = sc.nextInt();
				if(0<=tmp&&tmp<=Math.pow(10, 8)) {
					stone[i]=tmp;
				}
			}
			//�������� ����
			Arrays.sort(stone);
			//Ž�� ����
			for(int i=0;i<k;i++) {
				//��� ������ Ȱ��ȭ ��ų �� �ִٸ�(=������ ���� ����ġ�� ���� ȹ�� ����)
				if(i==stone.length-1) {
					max+=stone[i];
					break;
				}
				stone[i]=0;
				for(int j=i+1;j<stone.length;j++) {
					stone[i]+=stone[j];
				}
				max+=stone[i];
			}
			System.out.println(max);
		}
	}
}
