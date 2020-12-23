'''
https://www.hackerrank.com/challenges/itertools-permutations/problem

Created on 23 dic. 2020

@author: jgrodrigueza
'''

#!/bin/python3

import itertools
from itertools import permutations

if __name__ == '__main__':
    arr =  input().split()
    word = arr[0]
    count = int(arr[1])
    print(*[''.join(i) for i in permutations(sorted(word), count)], sep='\n')
    