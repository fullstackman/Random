"""
Write a function called myRoot, that accepts two parameters, a number and the root of that number you desire as a return value (Use integers, also, you can avoid negatives and fractions).
For example:
To get the cube root of 512 (8) I would call - root(512,3)
For the 4th root of 16 (2), root(16,4), etc.
"""
# Ignoring the hint. I think I can do this on my own.
# The 12th root of 12,345 is: 2.19 but my code will return zero because the instructions said use integers!

def myRoot(inputNumber, nthRoot):
	# We can't deal with anything less than a square root
	if(nthRoot < 2 or inputNumber < 1):
		print("\t\tOh! I'm not ready to handle that number.")
		return 0
	# If inputNumber is 1, then we always get the same answer
	if(inputNumber == 1):
		print("\t\tI found the root!")
		return 1
	# If inputNumber is too small, then we know it won't have an nthRoot
	if(inputNumber < 2**nthRoot):
		print("\t\tSuch an integer root does not exist.")
		return 0
	# Use (inputNumber/nthRoot+1) as a safe stopping point in case we can't find the root for whatever strange reason.
	for guess in range(2,(int(inputNumber/nthRoot)+1) ):
		testNumber = inputNumber
		for x in range(1,nthRoot):
			testNumber = int(testNumber / guess)
		#print("\t\tWe are checking if it is "+str(guess)+". The testNumber came out as "+str(testNumber))
		if(testNumber == guess):
			print("\t\tI found the root!")
			return guess
		else:
			continue
	print("\t\tSuch an integer root does not exist.")
	return 0

def main():
	theNumber = int(input("\tGive me a number: "))
	theRoot = int(input("\tTell me which root to find: "))
	print("\tLooking for that root. . .")
	print("\t"+str(myRoot(theNumber, theRoot)) )
	return

main()