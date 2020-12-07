'''
https://www.hackerrank.com/challenges/py-if-else/problem

Created on 3 dic. 2020

@author: jgrodrigueza
'''

#!/bin/python3

import math
import os
import random
import re
import sys



if __name__ == '__main__':
    n = int(input().strip())
    if (n % 2 != 0):
        print("Weird")
    else:
        if (2 <= n & n <= 5):
            print("Not Weird")
        elif (6 <= n & n <= 20):
            print("Weird")
        else:
            print("Not Weird")
