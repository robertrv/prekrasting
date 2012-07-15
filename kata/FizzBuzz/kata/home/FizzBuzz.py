'''
Created on 15/07/2012

@author: rramirez

'''

FIZZ = "Fizz"
BUZZ = "Buzz"

class FizzBuzz(object):
    '''
    A class to represents katas main class. 
    Kata description @see https://github.com/12meses12katas/Marzo-FizzBuzz
    '''

    
    def __next(self, i):
        result = ""
        if (i % 3 == 0) or ('3' in str(i)):
            result = ''.join([result,FIZZ])
            
        
        if (i % 5 == 0) or ('5' in str(i)):
            result = ''.join([result,BUZZ])
        if not result:
            return i
        else:
            return result
    
    
    def generate(self, maximum = None):
        '''
        generate a list of elements based on the kata's algorithm.
        
        :param max: the limit of elements to be generated
        '''
        limit = 100
        if maximum is not None:
            limit = int(maximum)+1
        i = 1
        result = []
        while (i < limit):
            result.append(self.__next(i))
            i = i + 1
        return result
    
        