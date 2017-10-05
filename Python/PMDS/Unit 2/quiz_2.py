# Create a list that contains the natural numbers from 1 to 400 and then iterate through the list finding the sum of all the multiples of 19. 
myList = range (1,400)

finalSum = 0

for current in myList:

  if (current % 19 == 0):

    finalSum += current

print(finalSum)
