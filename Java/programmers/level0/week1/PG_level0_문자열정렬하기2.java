package level0.week1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class PG_level0_문자열정렬하기2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String my_string = br.readLine();
		
		String result = solution(my_string);
		
		bw.write(result + "\n");

		bw.flush();
		bw.close();
		
	}
	
    public static String solution(String my_string) {
        String answer = "";
        
        my_string = my_string.toLowerCase();
        
        char[] char_arr = my_string.toCharArray();
        
        // char[] c = my_string.toLowerCase().toCharArray();
        
        Arrays.sort(char_arr);
        
        for (int i = 0; i < char_arr.length; i++) {
			answer += char_arr[i];
		}
        
        return answer;
    }
	
}
