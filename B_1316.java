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
    		//총 알파벳 소문자 갯수
    		int[]check=new int[26];
    		
    		for(int i=1;i<line.length();i++) {
    			//이전 문자와 같지 않을 경우
    			if(line.charAt(i-1)!=line.charAt(i)) {
    				//이전 문자와 같지 않은데 이미 문자가 출현한 경우(false)
    				if(check[line.charAt(i)-'a']==1) {
    					ans--;
    					break;
    				}
    				//이전 문자와 같지 않고, 새로 출현한 문자인 경우(true)
    				check[line.charAt(i-1)-'a']=1;
    			}
    		}
    	}
    	System.out.println(ans);
   	}
}