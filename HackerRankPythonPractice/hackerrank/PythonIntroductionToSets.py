'''
https://www.hackerrank.com/challenges/py-introduction-to-sets/problem

Created on 04 jan. 2021

@author: jgrodrigueza
'''

#!/bin/python3

def average(array):
    unique = set(array)
    return sum(unique) / len(unique)

if __name__ == '__main__':
    n = int(input())
    arr = list(map(int, input().split()))
    result = average(arr)
    print(result)