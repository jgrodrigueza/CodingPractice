'''
https://www.hackerrank.com/challenges/python-tuples/problem

Created on 13 dic. 2020

@author: jgrodrigueza
'''

#!/bin/python3

if __name__ == '__main__':
    n = int(input())
    print(hash(tuple(list(map(int, input().split())))))