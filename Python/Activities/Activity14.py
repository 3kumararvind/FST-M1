def prinFibonacci(num):
    if num ==1:
        print(num) 
    else:
        firstNum =0
        secondNum=1
        print(firstNum,",",secondNum,",", end="")
        for i in range(2, num+1):
            thirdNum = firstNum + secondNum
            print(thirdNum,",", end="")
            firstNum = secondNum
            secondNum = thirdNum
prinFibonacci(10)
