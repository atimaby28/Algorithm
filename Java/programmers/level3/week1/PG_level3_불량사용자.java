package level3.week1;

import java.io.*;
import java.util.*;

public class PG_level3_불량사용자 {

    static int N, R;
    static Set<Set<String>> bannedSets; //경우의 수를 담기위한 HashSet

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int p = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        String[] user_id = new String[p];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < user_id.length; i++) {
            user_id[i] = st.nextToken();
        }

        String[] banned_id = new String[q];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < banned_id.length; i++) {
            banned_id[i] = st.nextToken();
        }

        int result = solution(user_id, banned_id);

        bw.write(result + "\n");

        bw.flush();
        bw.close();

    }

    public static int solution(String[] user_id, String[] banned_id) {
        int answer = 0;

        N = user_id.length;
        R = banned_id.length;

        bannedSets = new HashSet<>();

        permute(user_id, banned_id, new boolean[N], new ArrayList<>());

        answer = bannedSets.size();

        return answer;
    }

    private static void permute(String[] user_id, String[] banned_id, boolean[] visited, List<String> current) {
        if(current.size() == R) {
            if (isValid(current, banned_id)) {
                bannedSets.add(new HashSet<>(current));
            }
            return;
        }

        for(int i = 0; i < N; i++) {
            if(!visited[i]) {
                visited[i] = true;
                current.add(user_id[i]);
                permute(user_id, banned_id, visited, current);
                current.removeLast(); //current.remove(current.size() - 1);
                visited[i] = false;
            }
        }
    }

    private static boolean isValid(List<String> current, String[] banned_id) {
        for (int i = 0; i < R; i++) {
            if (!matches(current.get(i), banned_id[i])) {
                return false;
            }
        }
        return true;
    }

    private static boolean matches(String user, String banned) {
        if (user.length() != banned.length()) return false;

        for (int i = 0; i < user.length(); i++) {
            if (banned.charAt(i) != '*' && user.charAt(i) != banned.charAt(i)) {
                return false;
            }
        }

        return true;
    }

}
