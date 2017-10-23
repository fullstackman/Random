# Brandon Diaz-Abreu
# brd48
# Unit 3
# Assignment 2
# This main program is a triple threat!

from myLib import Hodges, isHarshad, isSiete

# open Rumbers.txt and save the numbers to a list
sillyList = open("Rumbers.txt", "r")
#rumbers = sillyList.read()
print("\tDetecting all the Harshad numbers in the in Rumbers list.\n")
runningSum = int(0)
outFile = open("HarshOut.txt", "w")
print("\tHere are some very special numbers:\n\t")
# Loop through Rumbers, one line at a time
newLine = sillyList.readline()
while(newLine):
	# The input is tab delimited, so we have to perform a split
	for number in newLine.split("\t"):
		# The input is read as a string, so we have to cast it to an integer
		number = int(number)
		if(isHarshad(number) ):
			# Add each Harshad number to our sum
			runningSum += number
			if(isSiete(number)):
				# Write each isSiete Harshad number to the file
				outFile.write(str(number)+",\t")
				if(number % Hodges == 0):
					# Print out every number that satisfies all three conditions
					print("\t"+str(number))
	newLine = sillyList.readline()
sillyList.close()
outFile.close()
# Report the results
print("\n\tLook at the sum of all the Harshad numbers: "+str(runningSum))
print("\n\tYou can view the output of deliverable #2 in the file 'HarshOut.txt'\n")
