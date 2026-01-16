package boj.자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Josephus {

  public static void main(String[] args) throws IOException {
    /*
    * 실버 4 / 시간 제한 2초 / 메모리 제한 512MB
    * 문제
    * 요세푸스 문제는 다음과 같다.
    * 1번부터 N번까지 N명의 사람이 원을 이루면서 앉아있고, 양의 정수 K(≤ N)가 주어진다. 이제 순서대로 K번째 사람을 제거한다.
    * 한 사람이 제거되면 남은 사람들로 이루어진 원을 따라 이 과정을 계속해 나간다. 이 과정은 N명의 사람이 모두 제거될 때까지 계속된다.
    * 원에서 사람들이 제거되는 순서를 (N, K)-요세푸스 순열이라고 한다. 예를 들어 (7, 3)-요세푸스 순열은 <3, 6, 2, 7, 5, 1, 4>이다.
    *
    * N과 K가 주어지면 (N, K)-요세푸스 순열을 구하는 프로그램을 작성하시오.
    *
    * 입력
    * 첫째 줄에 N과 K가 빈 칸을 사이에 두고 순서대로 주어진다. (1 ≤ K ≤ N ≤ 1,000)
    *
    * 출력
    * 예제와 같이 요세푸스 순열을 출력한다.
    * 예제 1
    * 7 3
    * <3, 6, 2, 7, 5, 1, 4>
     * */

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());

    Queue<Integer> queue = new LinkedList<>();

    StringBuilder sb = new StringBuilder();
    sb.append("<");

    // 1부터 N까지의 사람을 큐에 순서대로 추가
    for (int i = 1; i <= n; i++) {
      queue.add(i);
    }

    // 큐에 한 명이 남을 때까지 반복
    while (queue.size() > 1) {
      // K번째 사람을 제거하기 위해, 앞의 K-1명을 뒤로 보냄
      for (int i = 0; i < k-1; i++) {
        queue.offer(queue.poll());
      }
      // K번째 사람을 제거하고 결과 문자열에 추가
      sb.append(queue.poll());
      sb.append(", ");
    }

    // 마지막 남은 사람을 추가 (뒤에 쉼표 없음)
    sb.append(queue.poll());
    sb.append(">");

    System.out.println(sb);
  }

  /*
   * 문제 레벨 : 실버 4
   * 제한 시간 : 20분
   * 걸린 시간 : 15분
   * 해결 과정 :
   * 처음에는 배열의 인덱스처럼 K번째 요소에 직접 접근하여 제거하고, 인덱스가 범위를 넘어가면 다시 처음으로 돌아오는 로직을 고민했음.
   * 하지만 이 방식은 인덱스 계산이 복잡해지고 구현이 까다로웠음.
   * 그래서 큐의 특성을 활용하여 생각을 좀 바꿔보았음.
   * 내가 K번째 위치로 이동하는 것이 아니라, K번째 사람이 내 앞으로 오게 만드는 것으로 관점을 바꿔보았음.
   * 즉, K번째 사람을 제거하기 위해 앞의 K-1명을 큐에서 꺼내(poll) 다시 맨 뒤로 넣는(offer) 방식을 사용했음
   * 이렇게 하면 복잡한 인덱스 계산 없이도 원형으로 줄을 선 것과 같은 효과를 낼 수 있어 문제를 쉽게 해결할 수 있었음.
   * 이 문제를 풀기 전 다른 큐 관련 문제를 풀어본 경험으로 이 문제를 어떻게 풀 지 생각해낼 수 있었던 것 같음.
   * */
}
