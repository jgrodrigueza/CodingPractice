'''
https://www.hackerrank.com/challenges/text-wrap/problem

Created on 17 dic. 2020

@author: jgrodrigueza
'''

#!/bin/python3

import textwrap

def wrap(string, max_width):
    return textwrap.fill(string, max_width)

if __name__ == '__main__':
    string, max_width = input(), int(input())
    result = wrap(string, max_width)
    print(result)