package level2.week2;

import java.io.*;
import java.util.*;

public class PG_level2_스킬트리 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = null;

        String skill = br.readLine();

        int k = Integer.parseInt(br.readLine());

        String[] skill_trees = new String[k];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < skill_trees.length; i++) {
            skill_trees[i] = st.nextToken();
        }

        int result = solution(skill, skill_trees);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }

    public static int solution(String skill, String[] skill_trees) {
        int answer = -1;

        int count = 0;
        for (int i = 0; i < skill_trees.length; i++) {

            LinkedList<Character> skillList = new LinkedList<>();
            LinkedList<Character> givenList = new LinkedList<>();

            for (int j = 0; j <skill.length() ; j++) {
                skillList.add(skill.charAt(j));
            }

            for (int j = 0; j < skill_trees[i].length(); j++) {
                char c = skill_trees[i].charAt(j);
                if(skillList.contains(c)) {
                    givenList.add(c);
                }
            }



            boolean flag = true;
            for (int j = 0; j < givenList.size(); j++) {
                if(skillList.get(j) != givenList.get(j)) {
                    flag = false;
                    break;
                }
            }

            if(flag) {
                count++;
            }
        }

        answer = count;

        return answer;
    }

}
