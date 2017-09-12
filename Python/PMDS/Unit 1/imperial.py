# Brandon Diaz-Abreu
# brd48
# Assignment 1
# Let's convert inches to other imperial units!

# This will be a verbose program!
print("\nHello! I heard you need help converting from inches to other units.")
# Collect input
inches = int(input("Tell me how many inches you're dealing with: "))
print("\nAwesome. This is what I can tell you. You have:")
# Do the conversions
feet = int(inches / 12)
yards = int(inches / 12 / 3)
miles = int(inches / 12 / 3 / 1760)
# Report the results
print("\t"+str(feet)+" feet")
print("\t"+str(yards)+" yards")
print("\t"+str(miles)+" miles")
print("\nI hope this helps. See you next time!\n")