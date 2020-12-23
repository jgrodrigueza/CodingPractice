'''
https://www.hackerrank.com/challenges/whats-your-name/problem

Created on 14 dic. 2020

@author: jgrodrigueza
'''

#!/bin/python3

def print_full_name(a, b):
    print("Hello {first} {last}! You just delved into python.".format(first = a, last = b))

if __name__ == '__main__':
    first_name = input()
    last_name = input()
    print_full_name(first_name, last_name)