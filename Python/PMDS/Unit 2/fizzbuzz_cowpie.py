# Brandon Diaz-Abreu
# brd48
# Unit 2
# Assignment 1
# Fizz Buzz Cow Pie!

print("Here are the first 100 numbers.\n\
Note that I have a weird thing with multiples of 3 and 7.")
for number in range(1,100):
	if(number % 7 == 0):
		if(number % 3 == 0):
			print("\tCowPie\n")
		else:
			print("\tPie\n")
	elif(number % 3 == 0):
		print("\tCow\n")
	else:
		print("\t"+str(number)+"\n")
# Say goodbye
print("Did you like it?\n")