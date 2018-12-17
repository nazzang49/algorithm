package solution;

import java.util.ArrayList;
import java.util.Scanner;

//���� �����ϴ� ���� �����ϱ� ���� �ʿ��� Ŭ����
class Set {
	int x, y, z;
	
	public Set(int x, int y, int z) {
		this.x=x;
		this.y=y;
		this.z=z;
	}
}

//����ڰ� ö���� ���̸� �Է��� ��, �ش� ö�縦 �߶� ���� �� �ִ� ���� �ﰢ�� ���� ���� ����ϱ�(���� ���� ��� ���)
public class Q54 {

	static ArrayList<Set> list = new ArrayList<>();
	static int n;
	
	public static void dfs(int start, int [] arr, int cnt) {
		//�� ���� ���� ������� ���� �ﰢ�� ���� Ȯ��
		if(cnt==arr.length-1) {
			arr[2]=n-arr[0]-arr[1];
			//ù��°�� �ι�° �� ������ �� = ����° ���� ����(���� �ﰢ�� ����)
			if(Math.pow(arr[0], 2)+Math.pow(arr[1], 2)==Math.pow(arr[2], 2)) {
				list.add(new Set(arr[0], arr[1], arr[2]));
			}
		}else{
			cnt++;
			for(int i=start+1;i<n/2;i++) {
				arr[cnt-1]=i;
				dfs(i,arr,cnt);
			}
		}
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		int [] arr = new int[3];
		
		if(1<=n&&n<=100000) {
			for(int i=1;i<n/2;i++) {
				arr[0]=i;
				dfs(i,arr,1);
			}
			//������ ��찡 ������
			if(list.size()==0) {
				System.out.println("������ ��찡 �����ϴ�.");
			}else {
				for(int i=0;i<list.size();i++) {
					Set s = list.get(i);
					System.out.println(s.x);
					System.out.println(s.y);
					System.out.println(s.z);
				}
			}
		}
	}
}
