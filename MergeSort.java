package test_190323;

//������, �ĺ���(��ġ�� ���� ���� ����)
public class MergeSort {

	//������ ���� ����� �ܰ躰 �ӽ� �迭
	static int [] sorted = new int[8];
	
	//m=���� mid=�߰� n=��
	public static void sort(int [] A, int m, int mid, int n) {
		//�� ���� �ε��� �ʿ�
		//i=���� �κй迭�� �ε���
		int i = m;
		//j=������ �κй迭�� �ε���
		int j = mid+1;
		//k=������ �迭�� �ε���(���� ó�� �� �ε��� �� = m)
		int k = m;
		//���� ������� �迭�� ����(���� �κ� �迭�� ������ �κ� �迭�� �� ��)
		while(i<=mid&&j<=n) {
			if(A[i]<=A[j]) {
				sorted[k]=A[i];
				i++;
			}else {
				sorted[k]=A[j];
				j++;
			}
			k++;
		}
		//i>mid = ���� �κ� �迭�� ���� ���� ��� �ԷµǸ�(���� �����ʵ� ���� �Է�)
		if(i>mid) {
			for(int t=j;t<=n;t++) {
				sorted[k]=A[t];
				k++;
			}
		}else {
			for(int t=i;t<=mid;t++) {
				sorted[k]=A[t];
				k++;
			}
		}
		//���� �迭�� ��ġ�� ����
		for(int t=m;t<=n;t++) {
			A[t]=sorted[t];
		}
	}
	
	public static void merge(int [] A, int m, int n) {
		//ũ�Ⱑ 1���� ū ��츸 ���
		if(m<n) {
			int mid = (m+n)/2;
			//���� ������ ��� �����ϰ� ���߿� ��ħ
			//����
			merge(A, m, mid);
			//������
			merge(A, mid+1, n);
			//����+��ħ
			sort(A, m, mid, n);
		}
	}
	
	public static void main(String[] args) {
		int [] ans = {7,6,5,8,3,5,9,1};
		
		//��� ���(�ڹٿ��� �迭�� ��ü�� �ν��ϱ� ������ ���� �޼ҵ尡 void���̾ ���������� ���� ���� ����� �ݿ���)
		merge(ans,0,ans.length-1);
		for(int i=0;i<ans.length;i++) {
			System.out.println(ans[i]);
		}
	}
}
