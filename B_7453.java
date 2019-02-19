package test_190219;

import java.util.HashMap;
import java.util.Scanner;

//Nx4 ��Ŀ� �ڿ����� �Էµ� ��, �� ������ �ϳ��� ���ڸ� �̾� ���� ���� 0�� �Ǵ� ���� ���� ���ϱ�
public class B_7453 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int ans = 0;
		
		//���� ũ�Ⱑ �ִ� 4000 -> ����Ž�� �� �ð����⵵ ��ȿ�� -> 0,1�� / 2,3���� ������ ���
		if(n<=4000) {
			long [][] map = new long[n][4];
			//�ڿ��� �Է�
			for(int i=0;i<n;i++) {
				for(int j=0;j<4;j++) {
					map[i][j]=sc.nextLong();
				}
			}
			HashMap<Long, Long> hs = new HashMap<>();
			//�ؽ��� ����
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					//0������ 1��, 1������ 1�� �����ϴ� ���
					long tmp = map[i][0]+map[j][1];
					//�̹� �ش��ϴ� ���� ���ԵǾ� ������(value �� ���� = ���� ������ ���� �ٸ� ����� ��)
					if(hs.containsKey(tmp)) {
						hs.replace(tmp, hs.get(tmp)+1);
					}else {
						//1�� �ڷ��� long���� ����
						hs.put(tmp, 1l);
					}
				}
			}
			//2,3���� ��
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					//0,1���� ������ ������ ���� ��ȣ�� �ٸ� ���� ���ؾ߸� 0�� �Ǵ��� Ȯ���� �� ����
					long tmp = (map[i][2]+map[j][3])*-1;
					if(hs.containsKey(tmp)) {
						ans+=hs.get(tmp);
					}
				}
			}
			System.out.println(ans);
		}
	}
}
