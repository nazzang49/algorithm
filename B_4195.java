package test_190228;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

//ģ�� ���谡 �־��� ��, �Է����� �־����� �� ����� ģ�� ��Ʈ��ũ �ο� �� ����ϱ�
public class B_4195 {

	static int n;
	static HashMap<String, Integer> parent;
	static int [] depth = new int[100001];
	static int [] d = new int[100001];
	static ArrayList<Integer> ans = new ArrayList<>();
	
	public static int getParent(int s) {
		if(d[s]==s) return s;
		else return getParent(d[s]);
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		if(t<=1000) {
			while(t!=0) {
				n = sc.nextInt();
				parent = new HashMap<>();
				Arrays.fill(depth, 1);
				//�θ� �迭 �ʱ�ȭ
				for(int i=1;i<d.length;i++) {
					d[i]=i;
				}
				//���� ������ ������ �ο��� ����
				int person = 1;
				//ģ�� ���� �Է�
				for(int i=1;i<=n;i++) {
					String s1 = sc.next();
					String s2 = sc.next();
					//�̹� �Էµ� Ű���� �ƴ� ��쿡�� �ű� �Է�
					if(!parent.containsKey(s1)) {
						parent.put(s1, person++);
					}
					if(!parent.containsKey(s2)) {
						parent.put(s2, person++);
					}
					int idx1 = getParent(parent.get(s1));
					int idx2 = getParent(parent.get(s2));
					//�θ� ���� ������(=��ġ��)
					if(idx1!=idx2) {
						d[idx2]=idx1;
						depth[idx1]+=depth[idx2];
						ans.add(depth[idx1]);
					}
				}
				t--;
			}
			//���� ���
			for(int i=0;i<ans.size();i++) {
				System.out.println(ans.get(i));
			}
		}	
	}
}
