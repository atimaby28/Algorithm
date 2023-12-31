package level0.week1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class PG_level0_피자나눠먹기3 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int slice = Integer.parseInt(st.nextToken());
		
		int n = Integer.parseInt(st.nextToken());

		int result = solution(slice, n);

		bw.write(result + "\n");

		bw.flush();
		bw.close();

	}
	
    public static int solution(int slice, int n) {
        int answer = 0;
        
        if(n % slice != 0) {
        	answer = n / slice + 1;
        } else {
        	answer = n / slice;
        }
        
        return answer;
    }

}