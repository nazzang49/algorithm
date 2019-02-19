package test_190219;

//��� ī�� �˰���(���ڿ� ��Ī �˰���) = �� ������ �ƽ�Ű ���� Ȱ���� ���� �ؽð��� ���ϸ� ��ġ�ϴ� ��ġ Ž���ϴ� �˰���
//ex) a -> 97*2^n �� ���� ������ ���հ� ���� ���ڿ��� ������ �������� ���� Ȯ��
public class RabinKarp {

	public static void findString(String parent, String pattern) {
		int parentSize = parent.length();
		int patternSize = pattern.length();
		int parentHash = 0;
		int patternHash = 0;
		//power = ���� ��
		int power = 1;
		for(int i=0;i<parentSize-patternSize;i++) {
			//ó���̸� �ؽð� ����
			if(i==0) {
				for(int j=0;j<patternSize;j++) {
					//�������� ���� ex) 98*2^1+97*2^0
					parentHash+=parent.charAt(patternSize-1-j)*power;
					patternHash+=pattern.charAt(patternSize-1-j)*power;
					//2�� n�� ����
					if(j<patternSize-1) power*=2;
				}
			}
			//�� ��°���� �ؽð� ����(���� ���ʿ� �ִ� ��ġ�� -, ���� ������ ��ġ�� �ű� �߰� +)
			else {
				parentHash = 2*(parentHash-parent.charAt(i-1)*power)+parent.charAt(patternSize-1+i);
			}
			//���� ������ �κ� ���ڿ��� �ؽð� = ���� ���ڿ��� �ؽð�(�� ���� �� -> �ؽð��� ���Ƶ� ���� ������ �ٸ� �� �ֱ⿡)
			if(parentHash==patternHash) {
				boolean flag = false;
				for(int j=0;j<patternSize;j++) {
					//�ϳ��� �ٸ��� ���� X
					if(parent.charAt(i+j)!=pattern.charAt(j)) {
						flag = true;
						break;
					}
				}
				if(!flag) {
					System.out.println(i+1+"��° �ڸ����� �����մϴ�.");
				}
			}
		}
	}
	
	public static void main(String[] args) {

		String parent = "ababacabacaabacaaba";
		String pattern = "abacaaba";
		
		findString(parent,pattern);	
	}
}
