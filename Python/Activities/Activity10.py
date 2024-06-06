tuple1 = tuple(input("Enter comma separated numbers:").split(","))
print("Number divisible by 5:")
for number in tuple1:
    if int(number)%5==0:
        print(number, " ")