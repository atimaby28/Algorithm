package level1.week5;

import java.io.*;
import java.util.Queue;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class PG_level1_붕대감기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] bandage = new int[3];

        for (int i = 0; i < bandage.length; i++) {
            bandage[i] = Integer.parseInt(st.nextToken());
        }

        int health = Integer.parseInt(br.readLine());

        int k = Integer.parseInt(br.readLine());
        int[][] attacks = new int[k][3];

        for (int i = 0; i < attacks.length; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                attacks[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = solution(bandage, health, attacks);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }

    public static int solution(int[] bandage, int health, int[][] attacks) {
        int answer = 0;

        Queue<Monster> damageQueue = new LinkedList<>();

        int attackTime = attacks[attacks.length - 1][0];
        final int healthLimit = health;

        for (int i = 0; i < attacks.length; i++) {
            damageQueue.offer(new Monster(attacks[i][0], attacks[i][1]));
        }

        int combo = 0;
        for (int time = 0; time <= attackTime; time++) {

            if (!damageQueue.isEmpty() && time == damageQueue.peek().time) {
                health -= damageQueue.peek().damage;
                damageQueue.poll();
                combo = 0;
                continue;
            } else combo++;

            if (health <= 0 || damageQueue.isEmpty()) break;

            if (combo >= bandage[0]) {
                combo = 0;              // Combo를 다시 초기화 해주어야 함
                health += bandage[2];
            }

            health += bandage[1];

            if (health >= healthLimit) health = healthLimit;

        }

        if (health <= 0) answer = -1;
        else answer = health;

        return answer;
    }
}

class Monster {
    int time, damage;

    Monster(int time, int damage) {
        this.time = time;
        this.damage = damage;
    }
}