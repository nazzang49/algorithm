package solution;

import java.util.Scanner;

//�����ձ⸦ �ϴ� ����� ��, �ο��� ����� �ܾ��� �迭�� �־��� �� ���� ���� Ż���ϴ� ����� ���° ���ʿ��� Ż���ϴ��� ���ϱ�
public class Q50 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		//�����ϴ� �ο�
		int n = sc.nextInt();
		//�ܾ� �迭�� ����
		int k = sc.nextInt();
		//�� ��° ���ʿ� Ż���ϴ��� Ȯ��
		int num = 0;
		//���� ���� Ż���ϴ� ����� idx
		int person = Integer.MAX_VALUE;
		int idx = Integer.MAX_VALUE;
		int tmp = 0;
		
		if(2<=n&&n<=10&&n<=k&&k<=100) {
			String [] words = new String[k+1];
			for(int i=1;i<words.length;i++) {
				String str = sc.next();
				if(2<=str.length()&&str.length()<=50) {
					words[i]=str;
				}
			}
			for(int i=1;i<words.length-1;i++) {
				//�ٽ� 1������ ���ƿ��� ����(����+1)
				if(i%n==1) {
					num++;
				}
				for(int j=i+1;j<words.length;j++) {
					if(words[i].equals(words[j])) {
						tmp=j;
						break;
					}
				}
				//�� ���� Ż���ϴ� ����� ��� �� ����
				if(person>=tmp&&tmp!=0) {
					person=tmp;
					idx=person%n;
					if(idx==0) {
						idx=n;
					}
				}
				tmp = 0;
			}
			if(idx==Integer.MAX_VALUE) num=0;
			System.out.println("idx : "+idx+", "+"num : "+num);
		}
	}
}
