# Brandon Diaz-Abreu
# brd48
# Unit 1
# Assignment 2
# Let's play a game!

# Here are my hard-coded values
age = int(62)
weight = int(232)
# Let's begin
print("\nWelcome! I haven't told anyone my age and weight yet.\n\
Take a guess. I doubt you can figure it out. = P\n")
# Collect input
guess_age = int(input("Enter your guess for age: "))
guess_weight = int(input("Enter your guess for weight: "))
# Add some space for legibility
print("\n")
# Work through the different possibilities
if(guess_age > age and guess_weight > weight):
	print("Both guesses were higher.")
elif(guess_age < age and guess_weight < weight):
	print("Both guesses were lower.")
elif(guess_age == age and guess_weight == weight):
	print("Bingo! I can't believe you got it right!")
else:
	print("Game over. I knew you couldn't figure it out!")
# Say goodbye
print("Thanks for playing!\n")