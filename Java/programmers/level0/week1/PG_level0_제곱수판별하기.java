package level0.week1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class PG_level0_제곱수판별하기 {

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
        int answer = 2;
        
        int k = 1;
        while(k * k < n) {
        	k++;
        }
        
        if(k * k == n) {
        	answer = 1;
        }
        
        return answer;
    }
    
//    public int solution(int n) {
//        if (n % Math.sqrt(n) == 0) {
//            return 1;
//        } else {
//            return 2;
//        }
//    }

}