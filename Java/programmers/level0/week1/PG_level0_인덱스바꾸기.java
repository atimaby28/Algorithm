package level0.week1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class PG_level0_인덱스바꾸기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = null;
		
		String my_string = br.readLine();
		
		st = new StringTokenizer(br.readLine());
		
		int num1 = Integer.parseInt(st.nextToken());
		int num2 = Integer.parseInt(st.nextToken());
		
		String result = solution(my_string, num1, num2);

		bw.write(result + "\n");

		bw.flush();
		bw.close();
	}
	
    public static String solution(String my_string, int num1, int num2) {
        String answer = "";
        
        char[] new_string = my_string.toCharArray();
        
        char temp1 = new_string[num1];
        char temp2 = new_string[num2];
        
        new_string[num1] = temp2;
        new_string[num2] = temp1;
        
        for (int i = 0; i < new_string.length; i++) {
			answer += new_string[i];
		}

        return answer;
    }
    
//    public String solution(String my_string, int num1, int num2) {
//        String answer = "";
//
//        char[] ch = my_string.toCharArray();
//
//        ch[num1] = my_string.charAt(num2);
//        ch[num2] = my_string.charAt(num1);
//
//        answer = String.valueOf(ch);
//        return answer;
//    }

}
