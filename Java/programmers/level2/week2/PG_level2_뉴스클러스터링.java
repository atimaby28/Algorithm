package level2.week2;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class PG_level2_뉴스클러스터링 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str1 = br.readLine();
        String str2 = br.readLine();

        int result = solution(str1, str2);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }

    public static int solution(String str1, String str2) {
        int answer = 0;

        ArrayList<String> A = new ArrayList<>();
        ArrayList<String> B = new ArrayList<>();

        for (int i = 0; i < str1.length() - 1; i++) {
            A.add(str1.toLowerCase().substring(i, i + 2));

            if(A.get(A.size() - 1).replaceAll("[^A-Za-z]", "").length() != A.get(A.size() - 1).length()) {
                A.remove(A.size() - 1);
            }
        }

        for (int i = 0; i < str2.length() - 1; i++) {
            B.add(str2.toLowerCase().substring(i, i + 2));

            if(B.get(B.size() - 1).replaceAll("[^A-Za-z]", "").length() != B.get(B.size() - 1).length()) {
                B.remove(B.size() - 1);
            }
        }

        ArrayList<String> union = new ArrayList<>();
        ArrayList<String> intersection = new ArrayList<>();

        for(String s : A){
            if(B.remove(s)){
                intersection.add(s);
            }
            union.add(s);
        }

        for(String s : B){
            union.add(s);
        }

        double jakard = 0;

        if(union.size() == 0) {
            jakard = 1;
        } else {
            jakard = (double)intersection.size() / (double)union.size();
        }

        answer = (int)(jakard * 65536);

        return answer;
    }

}
