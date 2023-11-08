package level0.week2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class PG_level0_로그인성공 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st;
		
		String[] id_pw = new String[2];
		st = new StringTokenizer(br.readLine());
		
		id_pw[0] = st.nextToken();
		id_pw[1] = st.nextToken();
		
		int k = Integer.parseInt(br.readLine());
		String[][] db = new String[k][2];
		
		for (int i = 0; i < db.length; i++) {
			st = new StringTokenizer(br.readLine());
			
			db[i][0] = st.nextToken();
			db[i][1] = st.nextToken();
			
		}

		String result = solution(id_pw, db);

		bw.write(result + "\n");

		bw.flush();
		bw.close();

	}
	
    public static String solution(String[] id_pw, String[][] db) {
        String answer = "";
        
        HashMap<String, String> m = new HashMap<>();
        
        for (int i = 0; i < db.length; i++) {
			m.put(db[i][0], db[i][1]);
			
			if(id_pw[0].equals(db[i][0])) {
				if(id_pw[1].equals(db[i][1])) {
					answer = "login";
					break;
				} else {
					answer = "wrong pw";
					break;
				}
			} else {
				answer = "fail";
			}
		}
        
        return answer;
    }
}
