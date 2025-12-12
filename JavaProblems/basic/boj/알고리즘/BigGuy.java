package boj.알고리즘;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BigGuy {
    public static void main(String[] args) throws IOException {
        /*문제
        우리는 사람의 덩치를 키와 몸무게, 이 두 개의 값으로 표현하여 그 등수를 매겨보려고 한다.
        어떤 사람의 몸무게가 x kg이고 키가 y cm라면 이 사람의 덩치는 (x, y)로 표시된다. 두 사람 A 와 B의 덩치가 각각 (x, y), (p, q)라고 할 때
         x > p 그리고 y > q 이라면 우리는 A의 덩치가 B의 덩치보다 "더 크다"고 말한다.
         예를 들어 어떤 A, B 두 사람의 덩치가 각각 (56, 177), (45, 165) 라고 한다면 A의 덩치가 B보다 큰 셈이 된다.
         그런데 서로 다른 덩치끼리 크기를 정할 수 없는 경우도 있다.
         예를 들어 두 사람 C와 D의 덩치가 각각 (45, 181), (55, 173)이라면 몸무게는 D가 C보다 더 무겁고, 키는 C가 더 크므로,
         "덩치"로만 볼 때 C와 D는 누구도 상대방보다 더 크다고 말할 수 없다.

        N명의 집단에서 각 사람의 덩치 등수는 자신보다 더 "큰 덩치"의 사람의 수로 정해진다.
        만일 자신보다 더 큰 덩치의 사람이 k명이라면 그 사람의 덩치 등수는 k+1이 된다. 이렇게 등수를 결정하면 같은 덩치 등수를 가진 사람은 여러 명도 가능하다.
        아래는 5명으로 이루어진 집단에서 각 사람의 덩치와 그 등수가 표시된 표이다.

        이름	(몸무게, 키)	덩치 등수
        A	(55, 185)	2
        B	(58, 183)	2
        C	(88, 186)	1
        D	(60, 175)	2
        E	(46, 155)	5
        위 표에서 C보다 더 큰 덩치의 사람이 없으므로 C는 1등이 된다. 그리고 A, B, D 각각의 덩치보다 큰 사람은 C뿐이므로 이들은 모두 2등이 된다.
        그리고 E보다 큰 덩치는 A, B, C, D 이렇게 4명이므로 E의 덩치는 5등이 된다. 위 경우에 3등과 4등은 존재하지 않는다.
        여러분은 학생 N명의 몸무게와 키가 담긴 입력을 읽어서 각 사람의 덩치 등수를 계산하여 출력해야 한다.

        입력
        첫 줄에는 전체 사람의 수 N이 주어진다. 그리고 이어지는 N개의 줄에는 각 사람의 몸무게와 키를 나타내는 양의 정수 x와 y가 하나의 공백을 두고 각각 나타난다.

        출력
        여러분은 입력에 나열된 사람의 덩치 등수를 구해서 그 순서대로 첫 줄에 출력해야 한다. 단, 각 덩치 등수는 공백문자로 분리되어야 한다.*/

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] people = new int[n][2];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            people[i][0] = Integer.parseInt(st.nextToken()); // 몸무게
            people[i][1] = Integer.parseInt(st.nextToken()); // 키
        }

        int[] rank = new int[n];
        for (int i = 0; i < n; i++) {
            rank[i] = 1; // 초기 등수는 1등
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    if (i == j) continue; // 자기 자신과 비교하지 않음
                    if (people[i][0] < people[j][0] && people[i][1] < people[j][1]) {
                        rank[i]++; // 더 큰 덩치가 있으면 등수 증가
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(rank[i]);
            if (i < n - 1) sb.append(" "); // 마지막 등수 뒤에는 공백 추가하지 않음
        }
        System.out.println(sb);
    }

    /*
     * 문제 레벨 : 실버 5
     * 제한 시간 : 20분
     * 걸린 시간 : 20분 살짝 초과.
     * 해결 과정 : 배열을 어떻게 설정할지 고민을 좀 했고, 2중 for loop를 사용하는 것까지는 알았는데, 등수를 어떻게 처리할 지 고민을 했음.
     * 처음에는 사람 객체를 따로 만들어서 등수를 포함시키는 방법도 생각했는데, 너무 복잡하게 만드는 것 같아서 다른 방법을 생각했음.
     * 단순하게 등수 배열을 하나 더 만들어서 처리하는 방법으로 해결함.
     * 어려웠던 점(아쉬운 점) : 같은 덩치 등수를 가진 사람이 여러 명도 가능하다는 점 if문 안에 조건 설정하는 부분이 어려웠다.
     * */
}
