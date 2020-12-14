'''
https://www.hackerrank.com/challenges/write-a-function/problem

Created on 13 dic. 2020

@author: jgrodrigueza
'''

#!/bin/python3

def is_leap(year):
    leap = False
    if (year % 400 == 0 or (year % 4 == 0 and year % 100 != 0)):
        leap = True
    return leap

year = int(input())
print(is_leap(year))
