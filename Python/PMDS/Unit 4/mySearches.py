# Brandon Diaz-Abreu
# brd48
# Unit 4
# Assignment 2
# Sorting to the rescue!

""" Instructions
	Create a library called mySearches.py. In this module two functions should reside:

	bsearch - a function that accepts an integer and a list. The function should conduct a binary search through the list and return the index of the number in the list if the number is found and a -1 if the number is not found.  The function should report how many lookups were performed during the search before it returns its value.

	lsearch - a function that accepts an integer and a list. The function should conduct a linear search through the list and and return the index of the number in the list if the number is found and a -1 if the number is not found.  The function should report how many lookups were performed during the search before it returns its value.
"""

def bsearch(target, population):
	iterations = 0
	guess = int(0)
	hi = int(len(population) - 1)
	low = int(0)

	while low <= hi:
		# increment the iteration count
		iterations += 1
		# calculate the midpoint of this range
		mid = int( (hi+low)/2 )
		# print("\t\t\t\tThe midpoint is now: ",mid)
		# pull out the number at the midpoint
		guess = population[mid]
		# midpoint was too large. We need to move on to the lower half of this range.
		if guess > target:
			hi = mid - 1
			continue
		# midpoint was too small. We need to move on to the upper half of this range.
		if guess < target:
			low = mid + 1
			continue
		# otherwise, this must be the value we are looking for!
		else:
			print("\t\t\tB_Search performed "+str(iterations)+" lookups.")
			return mid
	# at this point, the search has failed
	print("\t\t\tB_Search performed "+str(iterations)+" lookups.")
	return -1

def lsearch(target, population):
	# start at -1 because because list indices start at 0
	position = int(-1)
	# loop through each number in the given list and check if it is our target
	for number in population:
		position += 1
		if(number == target):
			print("\t\t\tL_Search performed "+str(position+1)+" lookups.")
			return position
	# at this point, the search has failed
	print("\t\t\tL_Search performed "+str(position+1)+" lookups.")
	return -1