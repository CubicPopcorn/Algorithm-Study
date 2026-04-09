from itertools import combinations


goal = int(input().split(" ")[1])
candidate = -1
for cards in combinations(map(int, input().split(" ")), 3):
    cards_sum = sum(cards)
    if cards_sum <= goal and cards_sum > candidate:
        candidate = cards_sum
print(candidate)