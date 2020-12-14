'''
https://www.hackerrank.com/challenges/np-zeros-and-ones/problem

Created on 13 dic. 2020

@author: jgrodrigueza
'''

#!/bin/python3

import numpy

inputInts = tuple(map(int,(input().split())))
zeroArr = numpy.zeros((inputInts), dtype = numpy.int)
print(zeroArr)
onesArr = numpy.ones((inputInts), dtype = numpy.int)
print(onesArr)