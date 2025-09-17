# 문제 : Malvika is peculiar about color of balloons
# 주인공 Malvika는 색깔에 대해 까다롭습니다.
# 그녀가 좋아하는 색은 amber(a) 와 brass(b) 딱 두 가지뿐입니다.
# 엄마가 풍선 n개를 사왔는데, 각각 풍선의 색은 amber(‘a’) 또는 brass(‘b’) 중 하나입니다.
# 이 풍선들의 색깔 정보는 문자열 s로 주어집니다.
# 'a' → amber 색
# 'b' → brass 색

# 상황
# Malvika는 풍선이 모두 같은 색이길 원했는데, 풍선이 섞여 있어서 화가 납니다.
# 그래서 일부 풍선을 반대 색으로 칠해서 모든 풍선이 같은 색이 되도록 만들었습니다.

# 문제 요구사항
# 풍선들을 모두 같은 색으로 만들려면, 최소 몇 개의 풍선을 색칠해야 하는지 구하는 프로그램을 작성하세요.

# 입력
# 첫 번째 줄에는 정수 T가 주어집니다. (테스트 케이스의 개수)
# 각 테스트 케이스의 첫 번째이자 유일한 줄에는 문자열 s가 주어집니다.

# 출력
# 각 테스트 케이스마다, 모든 풍선을 같은 색으로 만들기 위해 최소한 칠해야 하는 풍선의 개수를 한 줄에 출력합니다.

# 제한 조건
# 1 ≤ T ≤ 100
# 1 ≤ n ≤ 100, 여기서 n은 문자열 s의 길이를 의미합니다.

# 힌트
# 예시 1.
# 문자열이 `ab` 일 때, amber를 brass로 바꾸거나, brass를 amber로 바꾸면 됩니다.
# 두 경우 모두 풍선이 같은 색이 되므로 1개 풍선만 칠하면 됩니다. 답 : 1
# 예시 2.
# 문자열이 `aaa` 일 때, 이미 모든 풍선이 같은 색입니다.
# 따라서 0개의 풍선을 칠해도 됩니다. 답 : 0

# 내가 푼 풀이
t = int(input())

for _ in range(t):
    s = input()
    a = 0
    b = 0
    count = 0
    for i in s:
        if i == 'a':
            a += 1
        if i == 'b':
            b += 1
    if a > b:
        for i in s:
            if i == 'b':
                count += 1
    elif b > a:
        for i in s:
            if i == 'a':
                count += 1
    else:
        # a == b
        count = a
    print(count)

# 간단한 풀이
t = int(input())

for _ in range(t):
    s = input()
    a = s.count('a')
    b = s.count('b')
    print(min(a, b))
