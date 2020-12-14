'''
https://www.hackerrank.com/challenges/find-second-maximum-number-in-a-list/problem

Created on 13 dic. 2020

@author: jgrodrigueza
'''

#!/bin/python3

import sys

if __name__ == '__main__':
    n = int(input())
    arr = list(map(int, input().split()))
    arr.sort(key=None, reverse=True)
    runnerScore = arr[0]
    for score in arr:
        if runnerScore > score:
            runnerScore = score
            break
    print(runnerScore)