'''
https://www.hackerrank.com/challenges/symmetric-difference/problem

Created on 04 jan. 2021

@author: jgrodrigueza
'''

#!/bin/python3

if __name__ == '__main__':
    size1 = input()
    arr1 = set(list(map(int, input().split(' '))))
    size2 = input();
    arr2 = set(list(map(int, input().split(' '))))
    diff1 = arr1.difference(arr2)
    diff2 = arr2.difference(arr1)
    print(*sorted(diff1.union(diff2)), sep = "\n") 
