n,score,p = map(int, input().split())
if(n==0):
    print(1)
else:
    lst = list(map(int, input().split()))

    lst.append(score)
    lst.sort(reverse=True)
    ans = 0
    chk = 0

    for i in range(len(lst)):
        if lst[i] == score:
            if(i+1 > p):
                ans = -1
            else:
                if(chk==1):
                    continue
                else:
                    ans = i+1
                    chk = 1
                
                
    print(ans)

