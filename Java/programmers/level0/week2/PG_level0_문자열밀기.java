package level0.week2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class PG_level0_문자열밀기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		
		String A = st.nextToken();
		String B = st.nextToken();
		
		int result = solution(A, B);
		
		bw.write(result + "\n");
		
		bw.flush();
		bw.close();
	}
	
    public static int solution(String A, String B) {
        int answer = -1;
        
        for (int i = 0; i < A.length(); i++) {
        	if(A.equals(B)) {
        		answer = i++;
        		break;
        	}
        	
        	String head = A.charAt(A.length() - 1) + "";
			String body = A.substring(0, A.length() - 1);
			
			A = head + body;
			
		}
        
//        String tempB = B.repeat(3);
//        return tempB.indexOf(A);
        
        return answer;
    }

}
