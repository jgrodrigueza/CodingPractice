'''
https://www.hackerrank.com/challenges/nested-list/problem

Created on 13 dic. 2020

@author: jgrodrigueza
'''

#!/bin/python3

if __name__ == '__main__':
    scoresList = []
    for _ in range(0, int(input())):
        scoresList.append([input(), float(input())])
    second_highest = sorted(list(set([marks for name, marks in scoresList])))[1]
    print('\n'.join([a for a,b in sorted(scoresList) if b == second_highest]))