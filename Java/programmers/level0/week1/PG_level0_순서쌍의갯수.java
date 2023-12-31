package level0.week1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class PG_level0_순서쌍의갯수 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		int result = solution(n);

		bw.write(result + "\n");

		bw.flush();
		bw.close();

	}
	
    public static int solution(int n) {
        int answer = 0;
        
        int k = 1;
        
        boolean flag = false;
        while(k <= Math.sqrt(n)) {
        	if(n % k == 0) {
        		answer++;
        	} 
        	
        	if(k == Math.sqrt(n)) {
        		flag = true;
        	}
        	k++;
        }
        
        if(flag) {
        	answer = answer * 2 - 1;
        } else {
        	answer = answer * 2;
        }
        
        return answer;
    }
    
//    public int solution(int n) {
//        int answer = 0;
//        for(int i = 1; i <= n; i++){
//            if(n % i == 0){
//                answer++;
//            }
//        }
//        return answer;
//    }

}