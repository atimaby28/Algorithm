package level0.week2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class PG_level0_다항식더하기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String polynomial = br.readLine();
		
		String result = solution(polynomial);
		
		bw.write(result + "\n");
		
		bw.flush();
		bw.close();
	}
	
    public static String solution(String polynomial) {
        String answer = "";
        
        String[] mono = polynomial.split(" ");
        
    	int var = 0;
    	int con = 0;
        
        for (String s : mono) {
			if(s.equals("+")) {
				continue;
			} else if(s.contains("x")){
				if(s.length() == 1) {
					var += 1;
				} else {
					s = s.substring(0, s.length() - 1);
					var += Integer.parseInt(s);
				}
			} else {
				con += Integer.parseInt(s);
			}
		}
        
        if(var == 0) {
        	answer = con + "";
        } else if(var == 1 && con == 0) {
        	answer = "x";
        } else if(var == 1) {
        	answer = "x + " + con;
        } else if (con == 0) {
        	answer = var + "x";
        } else {
        	 answer = var + "x + " + con;
        }
       
        return answer;
    }
    
//    public String solution(String polynomial) {
//        int xCount = 0;
//        int num = 0;
//
//        for (String s : polynomial.split(" ")) {
//            if (s.contains("x")) {
//                xCount += s.equals("x") ? 1 : Integer.parseInt(s.replaceAll("x", ""));
//            } else if (!s.equals("+")) {
//                num += Integer.parseInt(s);
//            }
//        }
//        return (xCount != 0 ? xCount > 1 ? xCount + "x" : "x" : "") + (num != 0 ? (xCount != 0 ? " + " : "") + num : xCount == 0 ? "0" : "");
//    }

}
