package level0.week2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class PG_level0_이진수더하기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		
		String bin1 = st.nextToken();
		String bin2 = st.nextToken();
		
		String result = solution(bin1, bin2);
		
		bw.write(result + "\n");
		
		bw.flush();
		bw.close();
	}
	
    public static String solution(String bin1, String bin2) {
        String answer = "";

        int k1 = Integer.parseInt(bin1, 2);
        int k2 = Integer.parseInt(bin2, 2);
        
        answer = Integer.toBinaryString(k1 + k2);
        
        return answer;
    }

}
