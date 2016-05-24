#Module used for basic drawing in Python
import turtle

#Functioni 1: Draw a square
def draw_square():	
	squirtle = turtle.Turtle()
	squirtle.speed(2)
	
	# A basic loop to manage the simple, repetitive nature of drawing a square.
	count = 0
	while(count<4):
		squirtle.forward(150)
		squirtle.right(90)
		count += 1

#Functioni 2: Draw a circle		
def draw_circle():
	tangrowth = turtle.Turtle()
	tangrowth.shape("arrow")
	tangrowth.color("blue")
	tangrowth.circle(110)

#Functioni 3: Draw a triangle
def draw_triangle():
	ziggy = turtle.Turtle()
	ziggy.shape("classic")
	ziggy.color("yellow", "yellow")
	
	count = 0
	while(count<3):
		ziggy.back(110)
		# Go left to prevent this shape from overlapping with the square!
		ziggy.left(120)
		count += 1

#Main Method

# A screen for drawing on must be initialized.
window = turtle.Screen()
window.bgcolor("pink")

# Call each of the functions that have been defined
draw_square()
draw_circle()
draw_triangle()
window.exitonclick()

#end