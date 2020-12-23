'''
https://www.hackerrank.com/challenges/capitalize/problem

Created on 23 dic. 2020

@author: jgrodrigueza
'''

#!/bin/python3

import string

# Complete the solve function below.
def solve(s):
    for x in s[:].split():
        s = s.replace(x, x.capitalize())
    return s
    

if __name__ == '__main__':
    #fptr = open(os.environ['OUTPUT_PATH'], 'w')
    s = input()
    result = solve(s)
    print(result)
    #fptr.write(result + '\n')
    #fptr.close()
