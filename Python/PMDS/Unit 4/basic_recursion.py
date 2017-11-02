# Brandon Diaz-Abreu
# brd48
# Unit 4
# Assignment 1
# Time to get recursive!

def myPow(base, power):
	if(power < 2):
		return base
	return base * myPow(base, power-1)

def main():
	print("\t7 to the power of 3 equals: "+str(myPow(7, 3) ) + "\n")
	print("\t2 to the power of 6 equals: "+str(myPow(2, 6) ) + "\n")
	print("\t12 to the power of 5 equals: "+str(myPow(12, 5) ) + "\n")

main()
""" Interactive version
givenBase = int( input("\tI hear you are looking for power. Give me a number: ") )
givenPower = int( input("\tNow tell me how much power it should get: ") )
print("\n\tLook at the power you've unleashed: "+str(myPow(givenBase, givenPower) ) + "\n")
"""
