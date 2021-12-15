primelist= [2,3]
for i in range(4,192):
     prime= True
     for j in range(2,i):
             if (i%j==0):
                     prime = False
     if prime:
             primelist.append(i)

