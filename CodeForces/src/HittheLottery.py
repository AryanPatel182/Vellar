import math
n = int(input())

l = [100,20,10,5,1]

count = 0
for i in l:    
    if(n==0):
        break
    if(n>=i):
        count = count + int(n/i)        
        n = n%i
        
print(count)    
        

