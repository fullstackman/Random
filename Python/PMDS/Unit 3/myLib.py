# Brandon Diaz-Abreu
# brd48
# Unit 3
# Assignment 2
# Please keep your voices down in my library.

Hodges = int(14)

def isHarshad(originalNumber):
	""" The algorithm
		* Loop to get each digit
		* Sum them
		* Return true if modulo by the original number == 0
		* Else return false
	"""
	if(originalNumber < 1):
		return False
	testNumber = int(originalNumber)
	digitSum = int(0)
	currentDigit = int(0)
	while testNumber >= 1:
		currentDigit = testNumber % 10
		digitSum += currentDigit
		testNumber = int(testNumber / 10)
	if(originalNumber % digitSum == 0):
		return True
	else:
		return False

def isSiete(inputNumber):
	# Eliminate the ones digit
	inputNumber = inputNumber / 10
	# Check the tens digit
	if(inputNumber % 10 == 7):
		return True
	else:
		return False