# Brandon Diaz-Abreu
# brd48
# Unit 3
# Assignment 1
# Harshad Numbers, dude!

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

print("Detecting all the Harshad numbers in the first 500 numbers.\n")
for number in range(1,500):
	if(isHarshad(number) ):
		print("\t"+str(number)+"\n")
# Say goodbye
print("Do you agree?\n")