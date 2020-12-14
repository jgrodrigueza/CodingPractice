'''
https://www.hackerrank.com/challenges/swap-case/problem

Created on 14 dic. 2020

@author: jgrodrigueza
'''

#!/bin/python3

def swap_case(s):
    return s.swapcase();

if __name__ == '__main__':
    s = input()
    result = swap_case(s)
    print(result)