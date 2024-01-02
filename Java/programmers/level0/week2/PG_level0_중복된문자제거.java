package level0.week2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class PG_level0_중복된문자제거 {

	public static void main(String[] args) throws IOException {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		 
		 String my_string = br.readLine();
		 
		 String result = solution(my_string);
		 bw.write(result + "\n");
		 
		 bw.flush();
		 bw.close();

	}
	
//    public String solution(String my_string) {
//        String[] answer = my_string.split("");
//        Set<String> set = new LinkedHashSet<String>(Arrays.asList(answer));
//
//        return String.join("", set);
//    }
	
    public static String solution(String my_string) {
        String answer = "";
        
        boolean[] check = new boolean[100];
        
        for (int i = 0; i < my_string.length(); i++) {
			check[my_string.charAt(i) - ' '] = true;
		}
        
        for (int i = 0; i < my_string.length(); i++) {
			if(check[my_string.charAt(i) - ' '] == true) {
				answer += my_string.charAt(i);
				check[my_string.charAt(i) - ' '] = false;
			}
		}
        
        return answer;
    }

}
