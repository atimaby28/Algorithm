package level0.week2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class PG_level0_다음에올숫자 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = null;
		
		int k = Integer.parseInt(br.readLine());
		
		int[] common = new int[k];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < common.length; i++) {
			common[i] = Integer.parseInt(st.nextToken());
		}
		
		
		int result = solution(common);
		
		bw.write(result + "\n");
		
		bw.flush();
		bw.close();
	}
	
//    public static int solution(int[] common) {
//        int answer = 0;
//        
//        int a = common[0];
//        int d = common[1] - common[0];
//        int n = common.length;
//        int r = 0;
//        
//        try {
//        	r = common[1] / common[0];
//        } catch(ArithmeticException e){
//        	r = common[2] / common[1];
//        }
//        
//        if(common[2] == a + 2 * d) {
//        	answer = a + n * d;
//        } else {
//        	int t = r;
//        	for (int i = 0; i < common.length - 1; i++) {
//				t *= r;
//			}
//        	
//        	answer = a * t;
//        }
//        return answer;
//    }
    
    public static int solution(int[] common) {
        int answer = 0;
        
        if((common[1] - common[0]) == (common[2] - common[1])) {
            answer = common[common.length-1] + (common[1] - common[0]);
        } else {
        	answer = common[common.length-1] * (common[1] / common[0]);
        }
        
        return answer;
    }

}
