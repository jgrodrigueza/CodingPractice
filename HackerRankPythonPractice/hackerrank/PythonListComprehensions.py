'''
https://www.hackerrank.com/challenges/list-comprehensions/problem

Created on 13 dic. 2020

@author: jgrodrigueza
'''

#!/bin/python3

if __name__ == '__main__':
    x = int(input())
    y = int(input())
    z = int(input())
    n = int(input())
    #arr = [[[0 for _ in range(x)] for _ in range(y)] for _ in range(z)]
    print ([[a,b,c] for a in range(0, x + 1) for b in range(0, y + 1) for c in range(0, z + 1) if a + b + c != n ])