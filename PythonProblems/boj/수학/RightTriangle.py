# 문제 : 직각삼각형
# 과거 이집트인들은 각 변들의 길이가 3, 4, 5인 삼각형이 직각 삼각형인것을 알아냈다. 
# 주어진 세변의 길이로 삼각형이 직각인지 아닌지 구분하시오.

# 입력
# 입력은 여러개의 테스트케이스로 주어지며 마지막줄에는 0 0 0이 입력된다. 
# 각 테스트케이스는 모두 30,000보다 작은 양의 정수로 주어지며, 각 입력은 변의 길이를 의미한다

# 출력
# 각 입력에 대해 직각 삼각형이 맞다면 "right", 아니라면 "wrong"을 출력한다.

# 입력 예시
# 6 8 10
# 25 52 60
# 5 12 13
# 0 0 0

# 출력 예시
# right
# wrong
# right

# 공식: a² + b² = c² -> 빗변의 제곱이 다른 두 변의 제곱의 합과 같다

# 풀이
import sys

for line in sys.stdin:
    a, b, c = map(int, line.split())
    a2 = a * a
    b2 = b * b
    c2 = c * c
    if (a + b + c) == 0:
        break
    if a2 + b2 == c2:
        print("right")
    elif a2 + c2 == b2:
        print("right")
    elif b2 + c2 == a2:
        print("right")
    else:
        print("wrong")

# 깔끔한 예시
import sys

for line in sys.stdin:
    if not line.strip(): # 공백 방지
        continue
    a, b, c = sorted(map(int, line.split())) # 입력을 받는 순간 sorted로 정렬을 해버림 -> c가 가장 긴 변이 됨
    if a == b == c == 0:
        break
    print("right" if a*a + b*b == c*c else "wrong")