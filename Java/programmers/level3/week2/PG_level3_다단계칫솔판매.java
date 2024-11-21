package level3.week2;

import java.io.*;
import java.util.*;

public class PG_level3_다단계칫솔판매 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = null;

        int n = Integer.parseInt(br.readLine());

        String[] enroll = new String[n];
        String[] referral = new String[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < enroll.length; i++) {
            enroll[i] = st.nextToken();
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < referral.length; i++) {
            referral[i] = st.nextToken();
        }

        int m = Integer.parseInt(br.readLine());

        String[] seller = new String[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < seller.length; i++) {
            seller[i] = st.nextToken();
        }

        int[] amount = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < amount.length; i++) {
            amount[i] = Integer.parseInt(st.nextToken());
        }

        int[] result = solution(enroll, referral, seller, amount);

        bw.write(Arrays.toString(result) + "\n");

        bw.flush();
        br.close();
        bw.close();
    }

    public static int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        HashMap<String, Person> personHashMap = new HashMap<>();
        for (String name : enroll)
            personHashMap.put(name, new Person(name, null, 0));

        for (int i = 0; i < enroll.length; i++) {
            if (referral[i].equals("-"))
                continue;

            personHashMap.get(enroll[i]).parent = personHashMap.get(referral[i]);
        }

        for (int i = 0; i < seller.length; i++)
            personHashMap.get(seller[i]).getReward(amount[i] * 100);

        int[] result = new int[enroll.length];

        for (int i = 0; i < result.length; i++)
            result[i] = personHashMap.get(enroll[i]).money;

        return result;
    }

}

class Person {
    String name;
    Person parent;
    int money;

    public Person(String name, Person parent, int money) {
        this.name = name;
        this.parent = parent;
        this.money = money;
    }

    void getReward(int money) {
        int moneyToParent = (int) (money * 0.1);

        this.money += money - moneyToParent;

        if (this.parent != null)
            this.parent.getReward(moneyToParent);
    }
}

/*
public class PG_level3_다단계칫솔판매 {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        // 트리 구성 및 계산
        Map<String, TreeNode> nodeMap = buildTree(enroll, referral);
        distributeProfits(nodeMap, seller, amount);

        int[] result = new int[enroll.length];

        for (int i = 0; i < enroll.length; i++) {
            result[i] = (int) nodeMap.get(enroll[i]).income;
        }

        // 결과 출력
        return result;
    }

    // 트리 구성
    public static Map<String, TreeNode> buildTree(String[] enroll, String[] referral) {
        Map<String, TreeNode> nodeMap = new HashMap<>();
        TreeNode root = null;

        // 모든 노드 생성
        for (String name : enroll) {
            nodeMap.put(name, new TreeNode(name, 0.0));
        }

        // 부모-자식 관계 설정
        for (int i = 0; i < enroll.length; i++) {
            String childName = enroll[i];
            String parentName = referral[i];

            if (!parentName.equals("-")) {
                TreeNode parent = nodeMap.get(parentName);
                TreeNode child = nodeMap.get(childName);
                parent.children.add(child);
            }
        }

        return nodeMap;
    }

    // 이익 분배
    public static void distributeProfits(Map<String, TreeNode> nodeMap, String[] seller, int[] amount) {
        for (int i = 0; i < seller.length; i++) {
            String sellerName = seller[i];
            int profit = amount[i] * 100; // 칫솔당 100원
            distributeToParent(nodeMap.get(sellerName), profit, nodeMap);
        }
    }

    private static void distributeToParent(TreeNode node, int profit, Map<String, TreeNode> nodeMap) {
        if (node == null || profit < 1) return;

        int commission = profit / 10; // 10% 수수료
        node.income += profit - commission; // 자신이 가지는 금액

        // 추천인을 찾기 위해 역으로 참조
        String parentName = findParent(nodeMap, node.name);
        if (parentName != null) {
            distributeToParent(nodeMap.get(parentName), commission, nodeMap);
        }
    }

    // 추천인을 찾는 함수
    private static String findParent(Map<String, TreeNode> nodeMap, String childName) {
        for (String key : nodeMap.keySet()) {
            TreeNode parent = nodeMap.get(key);
            for (TreeNode child : parent.children) {
                if (child.name.equals(childName)) {
                    return parent.name;
                }
            }
        }
        return null;
    }

}


class TreeNode {
    String name;
    double income;
    List<TreeNode> children;

    TreeNode(String name, double income) {
        this.name = name;
        this.income = income;
        this.children = new ArrayList<>();
    }
}
*/

/*
8
john mary edward sam emily jaimie tod young
- - mary edward mary mary jaimie edward
5
young john tod emily mary
12 4 2 5 10
 */