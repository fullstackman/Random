# Function for searching the given text
def findKeywords(pathToOpen, keywords):
	source = open(pathToOpen)
	text = source.read()
	for word in keywords:
		print("We are checking:  "+word)
		if word in text:
			print("That keyword was found!")
	source.close()
	
#Main Method
path = input("Where can I find the text file that you want to search? ")
userInput= input("What are the keywords you are looking for? ")
keywordsList = []
tempWord = ""
for letter in userInput:
	if ( (letter == " ") or (letter == ",") or (letter== ";") or (letter == ":") ):
		keywordsList.append(tempWord)
		tempWord = ""
	else:
		tempWord = tempWord + letter
# The above loop misses the last input word.
keywordsList.append(tempWord)
findKeywords(path, keywordsList)
#end