package test;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B_1316 {

    public static void main(String[] args)throws Exception {
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	
    	int T=Integer.parseInt(br.readLine());
    	int ans=T;
    	
    	for(int t=1;t<=T;t++) {
    		String line=br.readLine();
    		//�� ���ĺ� �ҹ��� ����
    		int[]check=new int[26];
    		
    		for(int i=1;i<line.length();i++) {
    			//���� ���ڿ� ���� ���� ���
    			if(line.charAt(i-1)!=line.charAt(i)) {
    				//���� ���ڿ� ���� ������ �̹� ���ڰ� ������ ���(false)
    				if(check[line.charAt(i)-'a']==1) {
    					ans--;
    					break;
    				}
    				//���� ���ڿ� ���� �ʰ�, ���� ������ ������ ���(true)
    				check[line.charAt(i-1)-'a']=1;
    			}
    		}
    	}
    	System.out.println(ans);
   	}
}