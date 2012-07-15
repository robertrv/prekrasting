'''
Created on 15/07/2012

@author: rramirez
'''
import unittest
from kata.home.FizzBuzz import FizzBuzz

class Test(unittest.TestCase):

    single_results = {
                      1: 1,
                      2: 2,
                      3: "Fizz",
                      4: 4,
                      5: "Buzz",
                      15: "FizzBuzz",
                      30: "FizzBuzz",
                      31: "Fizz",
                      32: "Fizz",
                      33: "Fizz",
                      35: "FizzBuzz",
                      44: 44,
                      45: "Fizz",
                      45: "FizzBuzz",
                      55: "Buzz",
                      53: "FizzBuzz",
                      55: "Buzz",
                      57: "FizzBuzz",
                      60: "FizzBuzz",
                      99: "Fizz",
                      }
    def setUp(self):
        self.cut = FizzBuzz()
    
    def testFizzBuzzPresent(self):
        result = self.cut.generate(15) 
        expected = result[len(result)-1]
        self.assertEquals("FizzBuzz", expected)

    def testMaxAsLetter(self):
        self.assertRaises(ValueError, self.cut.generate, "maximum")
    
    def testMaxIsNotIgnored(self):
        self.assertEqual(33, len(self.cut.generate(33)))
    
    def testSingleResults(self):
        result = self.cut.generate()
        for position, expected in self.single_results.items():
            actual = result[position-1]
            self.assertEqual(expected, actual, 
                            "Error Postion: %s. Expected: %s. Actual: %s." % 
                            (position, expected, actual))
    
if __name__ == "__main__":
    unittest.main()
