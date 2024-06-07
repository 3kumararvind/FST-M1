def sumNumber(num):
    if num>0:
        return num + sumNumber(num-1)
    else:
        return 0
res = sumNumber(10)
print("Sum of numbers=", res)