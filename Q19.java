package solution;

import java.util.ArrayList;
import java.util.Scanner;

//���������� �����ؾ� �� �۾��� ���� ��Ȳ�� ���� ������ �־��� ��, ��� ���·� ������ �Ϸ�Ǵ��� ����ϱ�
public class Q19 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		ArrayList<Integer> answer = new ArrayList<>();
		
		//������ �Ϸ翡 �ѹ��� ����(100% �ʰ��� �����Ǵ� ��)
		if(1<=n&&n<=100) {
			int [] task = new int[n];
			int [] speed = new int[n];
			//�۾��� �ϼ��Ǵµ� �ɸ��� �ð�
			int [] finish = new int[n];
			
			//�Է�
			for(int i=0;i<task.length;i++) {
				int tmp = sc.nextInt();
				if(1<=tmp&&tmp<=100) {
					task[i]=tmp;
				}
			}
			for(int i=0;i<task.length;i++) {
				int tmp = sc.nextInt();
				if(1<=tmp&&tmp<=100) {
					speed[i]=tmp;
					if((100-task[i])/speed[i]==0) {
						finish[i]=(100-task[i])/speed[i];
					}else {
						finish[i]=(100-task[i])/speed[i]+1;
					}
				}
			}
			//Ž��
			for(int i=0;i<finish.length-1;i++) {
				int cnt = 1;
				for(int j=i+1;j<finish.length;j++) {
					if(finish[i]>=finish[j]) {
						cnt++;
						//���������� �ѹ��� �����ȴٸ�
						if(j==finish.length-1) {
							answer.add(cnt);
							i=finish.length;
						}
					}else {
						answer.add(cnt);
						//���� �񱳰��� �� �������� �ٽ� Ž�� ����
						i=j-1;
						//���� �񱳰��� ������ idx��
						if(j==finish.length-1) {
							answer.add(1);
						}
						break;
					}
				}
			}
			for(int i=0;i<answer.size();i++) {
				System.out.println(answer.get(i));
			}
		}
	}
}
