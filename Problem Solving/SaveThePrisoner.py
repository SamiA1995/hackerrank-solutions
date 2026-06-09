#!/bin/python3

import math
import os
import random
import re
import sys

# Make more efficient by simply doing an add instea of iterating
def saveThePrisoner(n, m, s):
    remainder_sweets =  m % n
    for i in range(remainder_sweets-1):
        if(s != n):
            s += 1
        else:
            s = 1
    return s

if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    t = int(input().strip())

    for t_itr in range(t):
        first_multiple_input = input().rstrip().split()

        n = int(first_multiple_input[0])

        m = int(first_multiple_input[1])

        s = int(first_multiple_input[2])

        result = saveThePrisoner(n, m, s)

        fptr.write(str(result) + '\n')

    fptr.close()
