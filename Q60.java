package solution;

//5õ�� �̸��� �� �� �Ҽ��� ���� + �Ҽ��� 3�� + �Ҽ��� 4������ ǥ���� �� �ִ� ��� ������ ���� ���ϱ�
public class Q60 {

	static int cnt = 0;
	
	//�Ҽ����� �Ǻ��ϴ� �޼ҵ�
	public static boolean check(int n) {
		boolean flag = false;
		for(int i=2;i<=n/2;i++) {
			if(n%i==0) {
				flag = true;
				break;
			}
		}
		//�Ҽ��̸�
		if(!flag) {
			return true;
		}
		return false;
	}
	
	public static void dfs(int [] sosoo, int count) {
		if(count<3) {
			long sum = 0;
			for(int i=0;i<count;i++) {
				sum+=Math.pow(sosoo[i], i+2);
			}
			//�հ谡 5õ�� ������ ���� dfs ����
			if(!(sum>=50000000)) {
				count++;
				boolean flag = false;
				for(int i=2;i<=1000;i++) {
					flag = check(i);
					if(flag) {
						sosoo[count-1]=i;
						dfs(sosoo, count);
					}
				}
			}
		}else if(count==3) {
			long sum = 0;
			for(int i=0;i<count;i++) {
				sum+=Math.pow(sosoo[i], i+2);
			}
			if(sum<50000000) {
				cnt++;
			}
		}
	}
	
	public static void main(String[] args) {

		int [] sosoo = new int[3];
		boolean flag = false;
		
		for(int i=2;i<10000;i++) {
			flag = check(i);
			//�Ҽ��̸�
			if(flag) {
				sosoo[0]=i;
				dfs(sosoo,1);
			}
		}
		System.out.println(cnt);
	}
}
