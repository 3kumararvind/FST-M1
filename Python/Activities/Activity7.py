list1 = list(input("Enter comma separated numbers:").split(","))
sum = 0;
for number in list1:
    sum+=int(number)
print("Total sum=", sum)