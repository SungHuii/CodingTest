package grammer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BasicGrammer {
    public static void main(String[] args) throws IOException {

        /* 입출력 (IO) */
        // 빠른 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        // 출력
        StringBuilder sb = new StringBuilder();
        sb.append("text\n");
        System.out.println(sb);

        /* 배열 */
        // 선언 / 초기화
        int[] arr = new int[10]; // 크기 10인 정수 배열 선언
        int[] arr2 = {1, 2, 3, 4}; // 초기화

        // 정렬
        Arrays.sort(arr2); // 오름차순 정렬

        // 2차원 배열
//        int[][] map = new int[n][m]; // n x m 크기의 2차원 배열 선언

        /* 리스트 */
        // ArrayList
        List<Integer> list = new ArrayList<>();
        list.add(10);
        list.get(0);
        list.set(0, 20); // 인덱스 0의 값을 20으로 변경
        Collections.sort(list); // 오름차순 정렬

        /* Set / Map (Hash 기반) */
        // 중복 제거, 탐색 빠름
        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.contains(1);

        // Key-Value 저장
        Map<String, Integer> map2 = new HashMap<>();
        map2.put("a", 1);
        map2.get("a");
        map2.containsKey("a");

        /* 정렬 관련 문법 */
        // 기본 정렬
        Arrays.sort(arr2); // 오름차순
        // 객체 정렬
//        Arrays.sort(arr2, (a, b) -> a.value - b.value); // 오름차순
        // 리스트 정렬
        list.sort((a, b) -> a - b); // 오름차순
        // 역순 정렬
        Collections.sort(list, Collections.reverseOrder()); // 내림차순

        /* 우선순위 큐 (PriorityQueue) */
        // 최소 힙
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        // 최대 힙
        PriorityQueue<Integer> maxPq = new PriorityQueue<>(Collections.reverseOrder());

        /* 스택 / 큐 */
        // 스택
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.pop();
        stack.peek();

        // 큐
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.poll();
        queue.peek();

        /* BFS / DFS 기본 틀 */
        // BFS (Breadth-First Search) 너비 우선 탐색. 가장 가까운 노드부터 우선적으로 탐색
        Queue<int[]> q = new LinkedList<>();
//        q.add(new int[]{x, y});

        while (!q.isEmpty()) {
            int[] curr = q.poll();
        }

        // DFS (Depth-First Search) 깊이 우선 탐색. 최대한 깊게 탐색 후, 더 이상 갈 곳이 없으면 다시 돌아와서 탐색
/*        static void dfs(int x) {
            visited[x] = true;
            for (int next : graph[x]) {
                if(!visited[next]) {
                    dfs(next);
                }
            }
        }*/

        /* 시간 계산 유틸 */
        System.currentTimeMillis(); // 밀리초 단위

        /* 기타 자주 쓰는 것 */
        // Math 클래스
/*        Math.max(a, b);
        Math.min(a, b);
        Math.abs(x);
        Math.pow(a, b); // a의 b제곱
        Math.sqrt(x); // 제곱근*/

    }
    /* 클래스, 객체 (정렬용 or 구조체로 자주 사용) */
    static class Node {
        int x, y, cost;
        Node(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
    }
}
