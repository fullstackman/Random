# first attempts at python

# A list is like a Java array.

print("")
print("Let's create a list of the first nine numbers.")
list=[1,2,3,4,5,6,7,8,9]
print("Here is the last number in the list:")
print(list[-1]) # 9
list=list[1:9:5] # This parses a list from index 1 to index 9 going by 5s.
print("Now let's format the list somehow and print it:")
print(list) # 2, 7
print("Let's make a new list.")
other_list=[3, 5, 7]
print("Here it is:")
print(other_list)
print("This is a combination of the two lists:")
print(list+other_list)
list.extend(other_list)  #An actual combination of the two lists.
print("The two lists have been combined formally:")
print(list)

print("")
print("Let's try to do the same with a string: acetylcoenzyme.")
word="acetylcoenzyme"
print(word)
print("Let's parse it from index 0 to index 5:")
print(word[0:6]) # To INCLUDE the final index of the substring, we need to end this call one index above that final index we want.
print("Let's parse it from the /'e/' in /'enzyme/' to the end:")
print(word[-6:]) # The negative sign means "Start from the last index" and not specifying an end means "Go up to the end."
print("Lastly, let's print every other letter:")
print(word[0:100:2])  # Specifying a terminal index that is out of bounds just makes it go to the end and the third argument always
				# means count by (this number).
print("By the way, how long is this word??")
print(len(word))  # Instead of "word.length", python works like this.

print("")
print ("Hello World!")
print ("This is working so far.")
print ("Let's try formatting strings....")
print ("This is without formatting")
print ("This is {}".format("with formatting!"))
# Formatting a string requires calling the "format()" function with as many arguments as there are "{}".
print ("And now let's create a container called \"test\" to hold multiple formattings")
test="This {} is {}. Thank you for {}."
print("This is what test holds: "+test)
print("Here is a formatted version of test: "+test.format("test","incomplete","beginning the test. Now please proceed to the next part"))
print("Now we'll save a new formatted version of test.")
test=test.format("test", "complete", "your time")
print("Here is the final version of the container \"test\": "+test)
print("")

# A dictionary is like a Java HashMap

print("Now we'll make a dictionary called stuff.")
stuff = {}
print("Let's add a person named Carla:")
stuff["name"]="Carla"
print(stuff) # This print statement will print all the stored keys and their corresponding values but I don't know what
				# determines the order of the keys.
print("Now let's put in her age:")
stuff["age"]=35
print(stuff)
print("And she must have a height:")
stuff["height"]="5 feet, 4 inches"
print(stuff)
info = input("Now tell me another piece of information: ") # This is how to ask for input. Including text just displays that
															# message when the input prompt comes up.
value = input("And the value of that information: ")
stuff[str(info)]=str(value) # the "str()" function type casts the argument as a string.
print("The given information was successfully stored!")
print(stuff)

print("")
print("Now it's time for a for-loop!")
for blah in ["dog", "cat", "mouse"]:
# The syntax for a for-loop. Any name can be given for the initialized container and the brackets indicate some kind of list.
# The list can be generated as a list of numbers by calling the "range()" function.
  print("{} is a mammal".format(blah))
print("")

#This is a subroutine.
print("Let's add numbers!")
def add(x,y):
  print("x is {} and y is {}".format(x,y))
  return x+y
z=add(5,6)
print("The sum is:")
print(z)
print("")

print("We can also create classes, like a car class:")
class Car():
  def setMake(self,make):
    self.make=str(make)
  def setModel(self, model):
    self.model=str(model)
  def getInfo(self):
    return("This car is a {} {}.".format(self.make,self.model))
c=Car()
brand=input("Give me a car brand: ")
c.setMake(brand)
type=input("And the model name: ")
c.setModel(type)
print(c.getInfo)
print("")


""" try:
	raise GenError("This is a generic error")
except GenError as e:
	pass #It's like "return." This is choosing not to deal with the error. """

print("")