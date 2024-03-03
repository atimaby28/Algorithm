package level1.week4;

import java.io.*;
import java.util.StringTokenizer;

public class PG_level1_공원산책 {

    public static int[] dx = {1, -1, 0, 0};
    public static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = null;

        int p = Integer.parseInt(br.readLine());

        String[] park = new String[p];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < park.length; i++) {
            park[i] = st.nextToken();
        }

        int q = Integer.parseInt(br.readLine());

        String[] routes = new String[q];

        for (int i = 0; i < routes.length; i++) {
            routes[i] = br.readLine();
        }

        int[] result = solution(park, routes);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }
    public static int[] solution(String[] park, String[] routes) {
        int[] answer = new int[2];

        char[][] map = new char[park.length][park[0].length()];

        int startX = 0;
        int startY = 0;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                map[i][j] = park[i].charAt(j);

                if(map[i][j] == 'S') {
                    startX = j;
                    startY = i;
                }
            }
        }

        int xPos = startX, yPos = startY;

        for (int i = 0; i < routes.length; i++) {

            for (int j = 0; j < (routes[i].charAt(2) - '0'); j++) {

                int nx = 0, ny = 0;

                if(routes[i].charAt(0) == 'E') {
                    nx = nx + dx[0] * j;
                } else if(routes[i].charAt(0) == 'W') {
                    nx = nx + dx[1] * j;
                } else if(routes[i].charAt(0) == 'S') {
                    ny = ny + dx[2] * j;
                } else if(routes[i].charAt(0) == 'N'){
                    ny = ny + dx[3] * j;
                }

                if(nx >= 0 && nx < map[i].length && ny >= 0 && ny < map.length && map[ny][nx] == 'O') {
                    xPos = nx;
                    yPos = ny;
                } else {
                    break;
                }
            }

            System.out.println(xPos + " " + yPos);

        }

        answer[0] = yPos;
        answer[1] = xPos;

        return answer;
    }

}


//3
//SOO OOO OOO
//3
//E 2
//S 2
//W 1

//3
//SOO OXX OOO
//3
//E 2
//S 2
//W 1

//4
//OSO OOO OXO OOO
//3
//E 2
//S 3
//W 1