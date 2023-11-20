package level0.week2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class PG_level0_분수의덧셈 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int numer1 = Integer.parseInt(st.nextToken());
		int denom1 = Integer.parseInt(st.nextToken());
		int numer2 = Integer.parseInt(st.nextToken());
		int denom2 = Integer.parseInt(st.nextToken());
		
		int[] result = solution(numer1, denom1, numer2, denom2);

		bw.write(result + "\n");

		bw.flush();
		bw.close();

	}
	
    public static int[] solution(int numer1, int denom1, int numer2, int denom2) {
        int[] answer = new int[2];
        
//        int lcmNum = lcm(denom1, denom2);
//        
//        if(denom1 != lcmNum) {
//        	int diff = lcmNum / denom1;
//        	
//        	numer1 *= diff;
//        	denom1 *= diff;
//        }
//        
//        if( denom2 != lcmNum) {
//        	int diff = lcmNum / denom2;
//        	
//        	numer2 *= diff;
//        	denom2 *= diff;
//        }
//        
//        answer[0] = numer1 + numer2;
//        answer[1] = lcmNum;
        
        answer[0] = numer1 * denom2 + numer2 * denom1;
        answer[1] = denom1 * denom2;
        
        int gcdNum = gcd(answer[0], answer[1]);
        
        answer[0] /= gcdNum;
        answer[1] /= gcdNum;
        
        System.out.println(answer[0] + " " + answer[1]);
        
        return answer;
    }
    
//    Recursion...
//    public int gcd(int a, int b) {
//        if (a % b == 0)
//            return b;
//        return gcd(b, a % b);
//    }
    
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
    
    public static int lcm(int x, int y) {
    	return (x * y) / gcd(x, y);
    }

}