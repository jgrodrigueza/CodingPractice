'''
https://www.hackerrank.com/challenges/defaultdict-tutorial/problem

Created on 07 jan. 2021

@author: jgrodrigueza
'''

#!/bin/python3

from collections import defaultdict

if __name__ == '__main__':
    d = defaultdict(list)
    list1=[]
    n, m = map(int, input().split())
    for i in range(0, n):
        d[input()].append(i + 1) 
    for i in range(0, m):
        list1 = list1 + [input()]  
    for i in list1: 
        if i in d:
            print(" ".join( map(str,d[i])))
        else:
            print(-1)