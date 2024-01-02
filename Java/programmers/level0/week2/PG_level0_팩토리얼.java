package level0.week2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class PG_level0_팩토리얼 {

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
        
        for (int i = 1; i <= 11; i++) {
        	
        	if(factorial(i) > n) {
        		answer = i - 1;
        		break;
        	}
        	
		}
        
        return answer;
    }

	private static int factorial(int n) {
		
		if(n == 1) {
			return 1;
		}
		
		return n * factorial(n - 1);
	}

}