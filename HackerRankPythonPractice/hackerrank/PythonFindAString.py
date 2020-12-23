'''
https://www.hackerrank.com/challenges/find-a-string/problem

Created on 17 dic. 2020

@author: jgrodrigueza
'''

#!/bin/python3

def count_substring(string, sub_string):
    #Using list comprehension
    return sum([1 for substr in range(len(string) - len(sub_string) + 1) if string[substr:substr + len(sub_string)] == sub_string])

if __name__ == '__main__':
    string = input().strip()
    sub_string = input().strip()
    count = count_substring(string, sub_string)
    print(count)