# Brandon Diaz-Abreu
# brd48
# Unit 2
# Assignment 2
# Negative Average

MyList = [ 23, -45, 6, -23, -9, 77, 54, -54, 21, -2, 8, -3, -23, 45, 93, -43, 999, -2, 3, 78, 90 ]
print("\nBig Lars gave me this list:\n\t"+str(MyList))
runningSum = 0
candidates = 0
for number in MyList:
	if(number == 999):
		break;
	if(number < 0):
		candidates += 1
		runningSum += number
theAverage = runningSum / candidates
# Report the results
print("This is the average of the negative numbers I found: "+str(theAverage)+"\n")