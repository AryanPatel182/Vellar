for _ in range(int(input())):
    d = input()
    k,n,m = map(int,input().split());
    A = list(map(int,input().split()));
    B = list(map(int,input().split()));
    
    flag = "true"
    ans = []
    i,j = 0,0
    while i<n and j<m:        
        if(A[i]<=B[j] and A[i]<=k):
            if(A[i]==0):
                ans.append(A[i])
                k=k+1
                i=i+1
            else:
                ans.append(A[i])
                i=i+1
        elif(B[j]<=A[i] and B[j]<=k):
            if(B[j]==0):
                ans.append(B[j])
                k=k+1
                j=j+1
            else:
                ans.append(B[j])
                j=j+1
        else:    
            flag = "false"
            break

    while i<n:
        if(A[i]==0):
            ans.append(A[i])
            k=k+1
            i=i+1
        elif(A[i]<=k):
            ans.append(A[i])
            i=i+1
        else:
            flag = "false"
            break

    while j<m:
        if(B[j]==0):
            ans.append(B[j])
            k=k+1
            j=j+1
        elif(B[j]<=k):
            ans.append(B[j])
            j=j+1
        else:
            flag = "false"
            break
    
    if(flag == "true"):
        for i in ans:
            print(i , end =" ")
        print()
    
    else:
        print(-1)
        

    
