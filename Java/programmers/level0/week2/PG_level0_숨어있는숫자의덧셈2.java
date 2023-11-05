package level0.week2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class PG_level0_숨어있는숫자의덧셈2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String s = br.readLine();

		int result = solution(s);
		
		bw.write(result + "\n");
		
		bw.flush();
		bw.close();

	}
	
    public static int solution(String my_string) {
        int answer = 0;
        
        String new_string = my_string.replaceAll("[^0-9]", " ");
        
        String[] array = new_string.split(" ");
        
        for (int i = 0; i < array.length; i++) {
			if(!array[i].isEmpty()) {
				answer += Integer.parseInt(array[i]);
			}
		}
        
        return answer;
    }

}
