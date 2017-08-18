# WebGuitar!
A port of the (in)famous TuxGuitar(http://tuxguitar.herac.com.ar/download.html)

## Background
My friend introduced me to this software when he needed help composing music for his [awesome game](https://etc-drew.itch.io/). I was surprised at how useful it was! The project is no longer maintained but I thought it would be a nice exercise for me to try and convert it to a webapp.

## Game Plan
Here is the [original project](https://github.com/Totallicks/TuxGuitar). It is written in Java-SWT. My first idea is to just use some kind of conversion tool/platform. Here is what I'm looking at so far:
* Java's built-in [web deployment library](http://docs.oracle.com/javase/7/docs/technotes/guides/javaws/developersguide/contents.html)
* Framework [#1](https://vaadin.com/swing)
* Framework [#2](http://swingweb.sourceforge.net/swingweb/)
* Framework [#3](http://www.webswing.org/#!/home)

If all else fails, I could just learn the back-end logic and build this from the ground up as a React app (and maybe go mobile with React Native!).