# Brandon Diaz-Abreu
# brd48
# Unit 4
# Assignment 2
# Can I have your random number?

"""Instructions
	A main program called lookup.py should import both functions from mySearches.py.  In the body of the program you should search for three numbers in the data (78700, 3333, 1118).
	Output should show if the number was found in the list and how many lookups were needed for each kind of search, even if the number is not found in the list.
"""

from mySearches import bsearch, lsearch

# Function to handle the searches separately
def runSearches(givenNumber, fullList):
	linearResult = int(lsearch(givenNumber, fullList))
	binaryResult = int(bsearch(givenNumber, fullList))
	if(linearResult != binaryResult):
		print("\t\tThe search results do not agree!")
	if(linearResult > -1 or binaryResult > -1): #change to and
		print("\t\tTarget found!\n")
	else:
		print("\t\tTarget not found!\n")

# open rands.txt and save the numbers to a list
print("\tReading in the input...")
sillyList = open("rands.txt", "r")
rands = []
# Loop through rands, one line at a time
newLine = sillyList.readline()
while(newLine):
	# The input is tab delimited, so we have to perform a split
	for number in newLine.split("\t"):
		# The input is read as a string, so we have to cast it to an integer
		number = int(number)
		rands.append(number)
	newLine = sillyList.readline()
sillyList.close()
print("\tStored "+str(len(rands))+" items.")
# Sort this 10,000 item list!
print("\tSorting the input...")
rands.sort()
print("\tSuccessfully sorted the items!")
# Report the results
print("\tSearching for targets...")
print("\t\tTarget: 78700")
runSearches(78700, rands)
print("\t\tTarget: 3333")
runSearches(3333, rands)
print("\t\tTarget: 1118")
runSearches(1118, rands)
print("\tGoodbye!")