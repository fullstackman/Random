import turtle

def draw_square():
	window = turtle.Screen()
	window.bgcolor("yellow")
	
	squirtle = turtle.Turtle()
	#squirtle.speed(2)
	
	squirtle.forward(150)
	squirtle.right(90)
	squirtle.forward(150)
	squirtle.right(90)
	squirtle.forward(150)
	squirtle.right(90)
	squirtle.forward(150)
	squirtle.right(90)
	
	tangrowth = turtle.Turtle()
	tangrowth.shape("arrow")
	tangrowth.color("blue")
	tangrowth.circle(110)
	
	window.exitonclick()

draw_square()