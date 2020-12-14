'''
https://www.hackerrank.com/challenges/python-string-split-and-join/problem

Created on 14 dic. 2020

@author: jgrodrigueza
'''

#!/bin/python3

def split_and_join(line):
    temp =  line.split(" ")
    return '-'.join(word for word in temp)

if __name__ == '__main__':
    line = input()
    result = split_and_join(line)
    print(result)