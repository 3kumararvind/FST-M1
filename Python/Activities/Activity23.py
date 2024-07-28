import pytest

@pytest.fixture
def myList():
    list = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
    return list

def test_sum(myList):
    sum = 0
    for n in myList:
        sum += n
    assert sum == 55