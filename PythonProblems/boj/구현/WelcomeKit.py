# 문제
# 2024년 2월 3일 개최 예정인 온사이트 그랜드 아레나에서는 참가자들에게 티셔츠 한 장과 펜 한 자루가 포함된 
# 웰컴 키트를 나눠줄 예정입니다. 키트를 제작하는 업체는 다음과 같은 조건으로만 주문이 가능합니다.

# 티셔츠는 S, M, L, XL, XXL, 그리고 XXXL의 6가지 사이즈가 있습니다. 티셔츠는 같은 사이즈의 T장 묶음으로만 주문할 수 있습니다.
# 펜은 한 종류로, P자루씩 묶음으로 주문하거나 한 자루씩 주문할 수 있습니다.
# 총 N명의 참가자 중 S, M, L, XL, XXL, XXXL 사이즈의 티셔츠를 신청한 사람은 각각 
# S, M, L, XL, XXL, XXXL명입니다. 티셔츠는 남아도 되지만 부족해서는 안 되고 신청한 사이즈대로 나눠주어야 합니다. 
# 펜은 남거나 부족해서는 안 되고 정확히 참가자 수만큼 준비되어야 합니다.

# 티셔츠를 T장씩 최소 몇 묶음 주문해야 하는지, 그리고 펜을 
# P자루씩 최대 몇 묶음 주문할 수 있고, 그 때 펜을 한 자루씩 몇 개 주문하는지 구하세요.

# 입력
# 첫 줄에 참가자의 수 N이 주어집니다. (1 <= N <= 10^9)
# 둘째 줄에 티셔츠 사이즈별 신청자의 수  S, M, L, XL, XXL, XXXL이 공백으로 구분되어 주어집니다. 
# (0 <= S, M, L, XL, XXL, XXXL <= N; S + M + L + XL + XXL + XXXL = N) 

# 셋째 줄에 정수 티셔츠와 펜의 묶음 수를 의미하는 정수 T와 P가 공백으로 구분되어 주어집니다. 
# (2 <= T, P <= 10^9)

# 출력
# 첫 줄에 티셔츠를 T장씩 최소 몇 묶음 주문해야 하는지 출력하세요.
# 다음 줄에 펜을 P자루씩 최대 몇 묶음 주문할 수 있는지와, 그 때 펜을 한 자루씩 몇 개 주문하는지 구하세요.

# 입력 예시       / 출력 예시
# 23               7
# 3 1 4 1 5 9      3 2
# 5 7

# 풀이
n = int(input())
s, m, l, xl, xxl, xxxl = map(int, input().split())
t, p = map(int,input().split())

count = 0
if s / t > 0:
    count += 1
if m / t > 0:
    count += 1
if l / t > 0:
    count += 1
if xl / t > 0:
    count += 1
if xxl / t > 0:
    count += 1
if xxxl / t > 0:
    count += 1
least_shirt_bundle = (n // t) + 1
least_pen_bundle = (n // p)
lack_of_pen = n - (least_pen_bundle * p)
print(least_shirt_bundle)
print(least_pen_bundle, lack_of_pen)

# 해설
# 참가자 수 입력
n = int(input().strip())

# 티셔츠 사이즈별 신청자 수 (S, M, L, XL, XXL, XXXL)
sizes = list(map(int, input().split()))

# 티셔츠 묶음 크기 T, 펜 묶음 크기 P
t, p = map(int, input().split())

# -------------------------------
# 1. 티셔츠 묶음 계산
# 각 사이즈별 신청자 수를 올림 나눗셈으로 묶음 개수 계산
# 공식을 (x + t - 1) // t 로 쓰면 나눗셈의 올림 효과가 남
# ex) 3명이 신청, T=5 → (3+4)//5 = 7//5 = 1묶음
# ex) 9명이 신청, T=5 → (9+4)//5 = 13//5 = 2묶음
# 모든 사이즈에 대해 묶음을 계산하고 합산
shirt_bundles = sum((x + t - 1) // t for x in sizes)

# -------------------------------
# 2. 펜 묶음 계산
# 펜은 정확히 N개가 필요하므로
# 최대한 P묶음으로 사고 나머지는 낱개로 주문
pen_bundles = n // p   # 묶음으로 살 수 있는 개수
pen_singles = n % p    # 묶음으로 채우고 남은 나머지

# -------------------------------
# 3. 출력
print(shirt_bundles)            # 티셔츠 묶음 수
print(pen_bundles, pen_singles) # 펜 묶음 수와 낱개 수
