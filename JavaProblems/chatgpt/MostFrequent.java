import java.util.*;

public class MostFrequent {
    public static void main(String[] args) {
        // 예시 케이스
        int[] a = {1, 3, 2, 3, 2, 2, 4};   // 기대 결과: 2
        System.out.println(mostFrequent(a));

        int[] b = {5, 5, 7, 7, 7, 5};      // 빈도 동률(3,3) → 더 작은 수 5
        System.out.println(mostFrequent(b));

        // 직접 추가해서 더 테스트해보세요
        int[] c = {9, 8, 8, 9, 9, 8};      // 동률(3,3) → 8
        System.out.println(mostFrequent(c));
    }

    /**
     * TODO:
     * 1) 각 정수의 빈도를 계산한다.
     * 2) 가장 많이 등장한 수를 반환한다.
     * 3) 최빈 빈도가 같다면 "값이 더 작은 수"를 반환한다.
     */
    public static int mostFrequent(int[] nums) {
// 빈도 계산엔 Map<Integer, Integer>가 유용
// 한 번 순회로 빈도 채우고, 또 한 번 순회로 “최대 빈도 → 값 작은 것 우선” 규칙으로 고르기.
/*
 * 1. 숫자가 몇 번 나왔는지 세어보기
 * -> 숫자 - 횟수 관계를 저장하는 자료구조가 필요
 * 키(key) : 숫자 / 값(value) : 횟수
 * 자바에서는 HashMap<Integer, Integer>
 * 
 * 2. 다 세고 나면 그 중 가장 많은 횟수를 가진 숫자 찾기
 * -> Map을 순회하면서
 * 현재 숫자의 등장 횟수 > 지금까지의 최고 등장 횟수 -> 갱신
 * 같다면 숫자 값이 더 작으면 갱신
 * 
 * 3. 모든 숫자들을 다 확인한 후, 저장해둔 bestNum을 리턴
 */
        // 1. 각 숫자 등장 횟수 세기
        Map<Integer, Integer> freq = new HashMap<>(); // key - value 형태로 저장

        // 배열을 순회하며 카운트를 누적하기
        for (int n : nums) {
            // freq.getOrDefault(n, 0) : n이 없으면 0 리턴 (key가 없으면 기본값 반환)
            freq.put(n, freq.getOrDefault(n, 0) + 1); // map.put(key, value)데이터 추가/수정
        }

        // 2. 최빈값 추적 변수
        int bestNum = Integer.MAX_VALUE; // 아직 값이 없으므로 큰 값으로 초기화
        int bestCount = -1;

        // 3. Map을 돌며 최빈값 판단
        for (Map.Entry<Integer, Integer> e : freq.entrySet()) { // map.entrySet() -> key-value 쌍으로 순회
            int num = e.getKey();
            int count = e.getValue();

            // (1) 더 자주 등장했거나
            // (2) 등장 횟수가 같지만 숫자가 더 작으면 갱신
            if (count > bestCount || (count == bestCount && num < bestNum)) {
                bestCount = count;
                bestNum = num;
            }
        }



        return bestNum;
    }
}
