package solution;

import java.util.Scanner;

//1���� n������ ���ڸ� ����� ǥ���� �� Ȯ���Ǵ� ���ڿ��� ���� �ջ��Ͽ� ����ϱ�
public class Q51 {

	//���� �ڸ�
	public static int first(int chk) {
		if((1<=chk&&chk<=2)||chk==6) {
			return 3;
		}else if(chk==3||(7<=chk&&chk<=8)) {
			return 5;
		}else {
			return 4;
		}
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int sum = 0;
		int [] arr = new int[n+1];
		
		if(1<=n&&n<=1000) {
			for(int i=1;i<=n;i++) {
				//���ڸ� ����
				if(1<=i&&i<=9) {
					arr[i]=first(i);
				}
				//���ڸ� ����
				else if(10<=i&&i<=19) {
					if(i==10) {
						arr[i]=3;
					}else if(11<=i&&i<=12) {
						arr[i]=6;
					}else if((13<=i&&i<=14)||(18<=i&&i<=19)) {
						arr[i]=8;
					}else if(15<=i&&i<=16) {
						arr[i]=7;
					}else {
						arr[i]=9;
					}
				}else if(20<=i&&i<=99) {
					if((i<=20&&i<=29)||(i<=30&&i<=39)||(i<=40&&i<=49)
							||(i<=80&&i<=89)||(i<=90&&i<=99)) {
						if(i%10==0) {
							arr[i]=6;
						}else {
							arr[i]+=6;
							String tmp = String.valueOf(i);
							String tmp_reset = "";
							tmp_reset+=tmp.charAt(1);
							int chk = Integer.parseInt(tmp_reset);
							arr[i]+=first(chk);
						}
					}else if((i<=50&&i<=59)||(i<=60&&i<=69)) {
						if(i%10==0) {
							arr[i]=5;
						}else {
							arr[i]+=5;
							String tmp = String.valueOf(i);
							String tmp_reset = "";
							tmp_reset+=tmp.charAt(1);
							int chk = Integer.parseInt(tmp_reset);
							arr[i]+=first(chk);
						}
					}else {
						if(i%10==0) {
							arr[i]=7;
						}else {
							arr[i]+=7;
							String tmp = String.valueOf(i);
							String tmp_reset = "";
							tmp_reset+=tmp.charAt(1);
							int chk = Integer.parseInt(tmp_reset);
							arr[i]+=first(chk);
						}
					}
				}
				//���ڸ� ����
				else {
					//���ڸ� ���� ����
					String str = String.valueOf(i);
					//���� �ڸ�
					String tmp1 = "";
					//���� �ڸ� + ���� �ڸ�
					String tmp2 = "";
					tmp1 += str.charAt(0);
					tmp2 += str.charAt(1);
					tmp2 += str.charAt(2);
					int num1 = Integer.parseInt(tmp1);
					int num2 = Integer.parseInt(tmp2);
					if(i%100==0) {
						arr[i]=arr[num1]+10;
					}else {
						arr[i]+=arr[num1]+10;
						arr[i]+=arr[num2];
					}
				}
			}
			for(int i=0;i<arr.length;i++) {
				sum+=arr[i];
			}
			System.out.println(sum);
		}
	}
}
