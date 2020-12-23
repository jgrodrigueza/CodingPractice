'''
https://www.hackerrank.com/challenges/itertools-product/problem

Created on 23 dic. 2020

@author: jgrodrigueza
'''

#!/bin/python3

import itertools
from itertools import product

if __name__ == '__main__':
    a = map(int, input().split())
    b = map(int, input().split())
    print(*product(a, b))