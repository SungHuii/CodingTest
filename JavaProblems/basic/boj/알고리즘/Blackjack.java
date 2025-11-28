package boj.알고리즘;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Blackjack {
    // 브론즈 2, 브루트포스 알고리즘

    public static void main(String[] args) throws IOException {
        /*  문제
          카지노에서 제일 인기 있는 게임 블랙잭의 규칙은 상당히 쉽다. 카드의 합이 21을 넘지 않는 한도 내에서, 카드의 합을 최대한 크게 만드는 게임이다.
          블랙잭은 카지노마다 다양한 규정이 있다.
          한국 최고의 블랙잭 고수 김정인은 새로운 블랙잭 규칙을 만들어 상근, 창영이와 게임하려고 한다.
          김정인 버전의 블랙잭에서 각 카드에는 양의 정수가 쓰여 있다.
          그 다음, 딜러는 N장의 카드를 모두 숫자가 보이도록 바닥에 놓는다. 그런 후에 딜러는 숫자 M을 크게 외친다.
          이제 플레이어는 제한된 시간 안에 N장의 카드 중에서 3장의 카드를 골라야 한다. 블랙잭 변형 게임이기 때문에,
          플레이어가 고른 카드의 합은 M을 넘지 않으면서 M과 최대한 가깝게 만들어야 한다.
          N장의 카드에 써져 있는 숫자가 주어졌을 때, M을 넘지 않으면서 M에 최대한 가까운 카드 3장의 합을 구해 출력하시오.*/
        /*
        입력
        첫째 줄에 카드의 개수 N(3 ≤ N ≤ 100)과 M(10 ≤ M ≤ 300,000)이 주어진다. 둘째 줄에는 카드에 쓰여 있는 수가 주어지며, 이 값은 100,000을 넘지 않는 양의 정수이다.
        합이 M을 넘지 않는 카드 3장을 찾을 수 있는 경우만 입력으로 주어진다.

        출력
        첫째 줄에 M을 넘지 않으면서 M에 최대한 가까운 카드 3장의 합을 출력한다.*/

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 카드 개수
        int m = Integer.parseInt(st.nextToken()); // 목표 값

        int[] cards = new int[n];
        st = new StringTokenizer(br.readLine()); // 두 번째 줄을 읽기 시작하는 기준점은 br.readLine()을 다시 호출했을 때
        for (int i = 0; i < n; i ++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }

        int ans = 0;
        for (int i = 0; i < n - 2; i++ ) { // n-2 : 뒤에 for문에서 j = i + 1 / k = j + 1 이라서 최소 2칸이 더 필요하기 때문
            for (int j = i + 1; j < n - 1; j ++ ) { // 두번째 인덱스 j는 항상 i보다 오른쪽(인덱스)에서 시작. 중복 방지 + 순서만 다른 조합을 또 세지 않기 위함
                for (int k = j + 1; k < n; k++ ) {
                    int sum = cards[i] + cards[j] + cards[k];

                    if (sum > ans && sum <= m) {
                        ans = sum;
                    }
                }
            }
        }

        System.out.println(ans);

        /*
         * 문제 레벨 : 브론즈 2
         * 제한 시간 : 20분
         * 걸린 시간 : 20분 초과.
         * 해결 과정 : 브루트포스 알고리즘에 대해서 몰라서, 검색해보고 이해함. 3중 for loop를 사용하는 것까지는 알았는데,
         * for loop의 조건식을 어떻게 써야할 지 생각하다가 시간이 다 지나가버림. 20분을 초과해서 끙끙대다가 AI에게 도움을 받음.
         * 어려웠던 점(아쉬운 점) : 두번째 인덱스가 항상 첫번째 인덱스보다 한칸 오른쪽에서 시작한다는 점을 알았다면 조금 더 쉽게 풀었을지도 모르겠다.
         * 개선 포인트 :
         * 최적값(m)을 딱 맞춘 경우에 바로 종료하는 로직을 넣을 수 있다.
         * sum의 값을 확인 한 후
         * if (sum == m) {
         *  sout(m);
         *  return;
         * }
         * 이런식으로 return해서 계산을 끝냄. 
         * */
    }
}
