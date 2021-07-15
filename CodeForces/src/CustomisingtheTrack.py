for _ in range(int(input())):
    n = int(input()) 
    l = list(map(int, input().split()))

    sum = 0
    for i in l:
        sum = sum + i
    
    k = sum % n
    print(k*(n-k))

    