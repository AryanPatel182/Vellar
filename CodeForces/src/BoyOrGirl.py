s = input()

l = []
count = 0
for char in s:
    if(char not in l):
        count+=1
        l.append(char)
    
if count%2==0:
    print("CHAT WITH HER!")
else:
    print("IGNORE HIM!")sevenkplus