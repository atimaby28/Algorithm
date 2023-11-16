package level0.week2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class PG_level0_OX퀴즈 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int k = Integer.parseInt(br.readLine());
		String[] quiz = new String[k];
		
		for (int i = 0; i < quiz.length; i++) {
			quiz[i] = br.readLine();
		}
	
		String[] result = solution(quiz);
		
		bw.write(result + "\n");
		
		bw.flush();
		bw.close();
		
	}
	
    public static String[] solution(String[] quiz) {
        String[] answer = new String[quiz.length];
        
        for (int i = 0; i < quiz.length; i++) {
			String[] equ = quiz[i].split(" ");

			String ans = "";
			if(equ[1].equals("+")) {
				if(Integer.parseInt(equ[0]) + Integer.parseInt(equ[2]) == Integer.parseInt(equ[4])) {
					ans = "O";
				} else {
					ans = "X";
				}
			} else if(equ[1].equals("-")) {
				if(Integer.parseInt(equ[0]) - Integer.parseInt(equ[2]) == Integer.parseInt(equ[4])) {
					ans = "O";
				} else {
					ans = "X";
				}
			}
			
            //int result = Integer.parseInt(text[0]) + ( Integer.parseInt(text[2]) * ( text[1].equals("+") ? 1:-1) );
            //quiz[i] = result == Integer.parseInt(text[4])? "O": "X";
			
			answer[i] = ans;
		}
        
        return answer;
    }

}
