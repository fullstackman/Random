import webbrowser
import time

counter = 0
while(counter < 3):
    time.sleep(5)
    webbrowser.open("http://www.youtube.com/watch?v=dQw4w9WgXcQ")
    counter = counter +1
