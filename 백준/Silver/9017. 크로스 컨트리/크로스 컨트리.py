i = int(input())
for _ in range(i):
    num = int(input())
    data = [0 for _ in range(201)]
    data_cnt = [0 for _ in range(201)]
    data_five = [0 for _ in range(201)]
    data_cnt2 = [0 for _ in range(201)]

    lst = list(map(int, input().split()))
    min_score = 9999999
    ans = -1 
    plus = 1

    for j in range(num):
        data_cnt[lst[j]] += 1

    for f in range(num):
        player = lst[f]
        if data_cnt[player] == 6:
            if data_cnt2[player] < 4:
                data[player] += plus
            elif data_cnt2[player] == 4:
                data_five[player] = plus
            data_cnt2[player] += 1
            plus += 1

    for k in range(201):
        if data_cnt[k] == 6:
            if data[k] < min_score:
                min_score = data[k]
                ans = k
            elif data[k] == min_score:
                if data_five[k] < data_five[ans]:
                    ans = k

    print(ans)
