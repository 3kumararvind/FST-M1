def sumList(list1):
    total = 0
    for num in list1:
        total= total+int(num)

    return total
numlist = list(input("Enter number separated by comma:").split(","))
res = sumList(numlist)
print("Sum of elements of list=", res)