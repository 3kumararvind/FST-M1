list1 = [10, 28, 3, 8 ,7]
list2 = [11, 20, 5,90]

list3=[]

for num in list1:
    if num%2!=0:
        list3.append(num)
for num1 in list2:
    if num1%2!=0:
        list3.append(num1)
print(list3)