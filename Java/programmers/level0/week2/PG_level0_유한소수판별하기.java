package level0.week2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class PG_level0_유한소수판별하기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		int result = solution(a, b);

		bw.write(result + "\n");

		bw.flush();
		bw.close();

	}
	
    public static int solution(int a, int b) {
        int answer = 0;
        
        int gcdNum = gcd(a, b);
        //int lcmNum = lcm(a, b);
        
        a = a / gcdNum;
        b = b / gcdNum;
        
        while(b > 0) {
        	if(b % 2 == 0) {
        		b /= 2;
        	} else if(b % 5 == 0) {
        		b /= 5;
        	} else {
        		break;
        	}
        }
        
        if(b == 1) {
        	answer = 1;
        } else {
        	answer = 2;
        }
        
        return answer;
    }
    
    public static int gcd(int a, int b) {
    	if(a < b) {
    		int temp = a;
    		a = b;
    		b = temp;
    	}
    	
    	while(b != 0) {
    		int r = a % b;
    		a = b;
    		b = r;
    	}
    	
    	return a;
    }
    
    public static int lcm(int a, int b) {
    	return a * b / gcd(a, b);
    }

}
