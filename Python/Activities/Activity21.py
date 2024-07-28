import pytest;

def test_add():
    num1=10
    num2=20
    sum1 = num1+num2
    assert sum1 ==30

def test_sub():
    num1=40
    num2 = 10
    sub=num1-num2
    assert sub==30

def test_mul():
    num1=20
    num2=20
    mul=num1*num2
    assert num1*num2 == 400

def test_div():
    num1=200
    num2=100
    div=num1/num2
    assert div == 2
