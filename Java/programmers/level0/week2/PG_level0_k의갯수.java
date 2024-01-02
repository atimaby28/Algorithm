package level0.week2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class PG_level0_k의갯수 {

	public static void main(String[] args) throws IOException {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		 StringTokenizer st = new StringTokenizer(br.readLine());
		 
		 int i = Integer.parseInt(st.nextToken());
		 int j = Integer.parseInt(st.nextToken());
		 int k = Integer.parseInt(st.nextToken());
		 
		 int result = solution(i, j, k);

		 bw.write(result + "\n");
		 
		 bw.flush();
		 bw.close();
	}

	public static int solution(int i, int j, int k) {

		int count = 0;
		
		for (int n = i; n <= j; n++) {
			for(int m = 0; m < Integer.toString(n).length(); m++) {
				if(Integer.toString(n).charAt(m) == Integer.toString(k).charAt(0)) {
					count++;
				}
			}
		 }
		
		return count;
	}
	
//    public int solution(int i, int j, int k) {
//        String str = "";
//        for(int a = i; a <= j; a++) {
//            str += a+"";
//        }
//
//        return str.length() - str.replace(k+"", "").length();
//    }

}
