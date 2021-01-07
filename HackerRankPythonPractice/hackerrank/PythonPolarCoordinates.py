'''
https://www.hackerrank.com/challenges/polar-coordinates/problem

Created on 07 jan. 2021

@author: jgrodrigueza
'''

#!/bin/python3

import cmath

if __name__ == '__main__':
    print(*cmath.polar(complex(input())), sep='\n')