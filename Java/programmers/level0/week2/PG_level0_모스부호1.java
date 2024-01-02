package level0.week2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class PG_level0_모스부호1 {
	
	static StringTokenizer st = null;
	static HashMap<String, String> moss;

	public static void main(String[] args) throws IOException {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		 
		 String letter = br.readLine();
		 
		 String result = solution(letter);

		 bw.write(result + "\n");
		 
		 bw.flush();
		 bw.close();

	}
	
    public static String solution(String letter) {
        String answer = "";
        
        st = new StringTokenizer(letter, " ");
        
        moss = new HashMap<>();
		 
		moss.put(".-", "a");
		moss.put("-...", "b");
		moss.put("-.-.", "c");
		moss.put("-..", "d");
		moss.put(".", "e");
		moss.put("..-.", "f");
		moss.put("--.", "g");
		moss.put("....", "h");
		moss.put("..", "i");
		moss.put(".---", "j");
		moss.put("-.-", "k");
		moss.put(".-..", "l");
		moss.put("--", "m");
		moss.put("-.", "n");
		moss.put("---", "o");
		moss.put(".--.", "p");
		moss.put("--.-", "q");
		moss.put(".-.", "r");
		moss.put("...", "s");
		moss.put("-", "t");
		moss.put("..-", "u");
		moss.put("...-", "v");
		moss.put(".--", "w");
		moss.put("-..-", "x");
		moss.put("-.--", "y");
		moss.put("--..", "z");
        
		while(st.hasMoreTokens()) {
			answer += moss.get(st.nextToken());
		}
		
		return answer;
    }

}
