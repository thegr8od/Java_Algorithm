import itertools

n,m = input().split()
r = 0
if(m=='Y'):
    r=1
elif(m=='F'):
    r=2
else:
    r=3
lst = []
for _ in range(int(n)):
    lst.append(input())

s1 = set(lst)

print(int(len(s1)/r))