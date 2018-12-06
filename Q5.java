package solution;

import java.util.ArrayList;
import java.util.Scanner;

class Pos {
	int start, end;
	
	public Pos(int start, int end) {
		this.start=start;
		this.end=end;
	}
}

//��ӵ��θ� �̿��ϴ� ������ ��ΰ� �־��� �� ��� ������ �ݵ�� �ѹ��� ī�޶� �������� �ϱ� ���� �ּ� ��� ���ϱ�
public class Q5 {

	public static int camera(int [][] car) {
		ArrayList<Pos> list = new ArrayList<>();
		int cnt = 1;
		//ī�޶� ��ġ�Ǵ� ����(�ʱⰪ ����)
		list.add(new Pos(car[0][0], car[0][1]));
		for(int i=1;i<car.length;i++) {
			for(int j=0;j<list.size();j++) {
				Pos p = list.get(j);
				//���� ��ΰ� ī�޶� ��ġ ������ ���Ե� ��
				if(p.start<=car[i][0]&&car[i][1]<=p.end) {
					list.set(j, new Pos(car[i][0], car[i][1]));
				}
				//�Ϻκи� ��ĥ ��1
				else if(car[i][0]<p.start&&p.start<=car[i][1]) {
					list.set(j, new Pos(p.start, car[i][1]));
				}
				//�Ϻκи� ��ĥ ��2
				else if(car[i][0]<p.end&&p.end<=car[i][1]) {
					list.set(j, new Pos(car[i][1], p.end));
				}
				//������ ����� ���
				else if(car[i][1]<p.start||p.end<car[i][0]) {
					list.add(new Pos(car[i][0], car[i][0]));
					cnt++;
				}
			}
		}
		return cnt;
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		//������ ����� 10000�� ����
		if(1<=n&&n<=10000) {
			int [][] car = new int[n][2];
			for(int i=0;i<car.length;i++) {
				int start = sc.nextInt();
				int end = sc.nextInt();
				//������ ����, ���� ����
				if(-30000<=start&&start<=30000&&-30000<=end&&end<=30000) {
					car[i][0]=start;
					car[i][1]=end;
				}else {
					System.out.println("�Է� ��Ģ�� Ȯ���ϼ���.");
					System.exit(0);
				}
			}
			int cnt = camera(car);
			System.out.println(cnt);
		}
	}
}
