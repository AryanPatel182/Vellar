for _ in range(int(input())):
    l = input()
    A = list(map(int, input().split()))
    B = list(map(int, input().split()))
    F = list(map(int, input().split()))

    ans = 0
    if(A[0] == B[0] and A[1]==B[1]):
        ans = 1
    elif A[1]==B[1] and A[1]==F[1]:
        if(max(A[0] , B[0]) < F[0] or min(A[0],B[0]) > F[0]):
            ans = abs(A[0]-B[0])
        else:
            ans = abs(A[0]-B[0]) +  2
    elif A[0]==B[0] and A[0]==F[0]:
        if(max(A[1] , B[1]) < F[1] or min(A[1],B[1]) > F[1]):
            ans = abs(A[1]-B[1])
        else:
            ans = abs(A[1]-B[1])+ 2
    else:
        ans = abs(A[0]-B[0]) + abs(A[1]-B[1])

    print(ans)