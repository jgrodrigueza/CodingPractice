'''
https://www.hackerrank.com/challenges/alphabet-rangoli/problem

Created on 23 dic. 2020

@author: jgrodrigueza
'''

#!/bin/python3

import string

def print_rangoli(size):
    chars = string.ascii_lowercase #Generate string of lowercase characters.
    arr = []
    for i in range(size):
        s = "-".join(chars[i:size]) #Generate string of first "size" characters joined by "-"
        left = s[::-1] #Left side is reversed string from position 1.
        right = s[1:] #Right is string from position 1.
        arr.append((left + right).center(4 * n - 3, "-")) #Add concatenation of left and right, centered.
    print('\n'.join(arr[:0:-1] + arr))

if __name__ == '__main__':
    n = int(input())
    print_rangoli(n)
