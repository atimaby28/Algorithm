package level0.week2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class PG_level0_잘라서배열로저장하기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String my_str = br.readLine();
		
		int n = Integer.parseInt(br.readLine());
		
		String[] result = solution(my_str, n);
		
		bw.write(result + "\n");
		
		bw.flush();
		bw.close();
		
	}
	
    public static String[] solution(String my_str, int n) {
        String[] answer = new String[my_str.length() / n];
        
        int i = 0;
		for (int j = 0; j < my_str.length(); j++) {
			answer[i++] += my_str.charAt(j);
		}
        
        return answer;
    }

}
