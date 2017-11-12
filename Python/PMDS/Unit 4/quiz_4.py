"""
	Just code a recursive function that returns the factorial of a number. Test your code by printing 8 factorial. 
"""
def myFactorial(givenNumber):
    # Base case #1
    if(givenNumber < 0):
        return 0
       # Base case #2
    if(givenNumber == 1):
        return 1
    # else, make the recursive call
    return givenNumber * myFactorial(givenNumber - 1)
# Main program
print(str(myFactorial(8)))
