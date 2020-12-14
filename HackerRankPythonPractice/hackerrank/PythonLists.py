'''
https://www.hackerrank.com/challenges/python-lists/problem

Created on 13 dic. 2020

@author: jgrodrigueza
'''

#!/bin/python3

if __name__ == '__main__':
    N = int(input())
    list = []
    for _ in range(0, N):
        ops = input().split(" ")
        if ops[0] == 'insert':
            list.insert(int(ops[1]), int(ops[2]))
        elif ops[0] == 'print':
            print(list)
        elif ops[0] == 'remove':
            list.remove(int(ops[1]))
        elif ops[0] == 'append':
            list.append(int(ops[1]))
        elif ops[0] == 'sort':
            list.sort()
        elif ops[0] == 'pop':
            list.pop(len(list) - 1)
        elif ops[0] == 'reverse':
            list.reverse()
