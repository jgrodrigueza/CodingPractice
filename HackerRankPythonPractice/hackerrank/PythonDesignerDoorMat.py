'''
https://www.hackerrank.com/challenges/designer-door-mat/problem

Created on 17 dic. 2020

@author: jgrodrigueza
'''

#!/bin/python3

#Read the input.
n, m = map(int,input().split())

#Generate the pattern.
pattern = [('.|.' * (2 * i + 1)).center(m, '-') for i in range(n // 2)]

#Join the strings.
print('\n'.join(pattern + ['WELCOME'.center(m, '-')] + pattern[::-1]))