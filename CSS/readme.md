CSS
===
Useful CSS tips and tricks that I can use in other projects.

### Asynchronous Stylesheet Loading
```javascript
var stylesheet = document.createElement('link');
stylesheet.href = '/inc/body/jquery/css/start/jquery-ui-1.8.10.custom.css';
stylesheet.rel = 'stylesheet';
stylesheet.type = 'text/css';
// temporarily set media to something inapplicable to ensure it'll fetch without blocking render
stylesheet.media = 'only x';
// set the media back when the stylesheet loads
stylesheet.onload = function() {stylesheet.media = 'all'}
document.getElementsByTagName('head')[0].appendChild(stylesheet);
```

### Use a "Font Stack" of platform native fonts
Gives better performance and reliability
```css
body {  
   font-family: -apple-system, 
                BlinkMacSystemFont, 
                "Segoe UI", 
                Roboto, 
                Oxygen-Sans, 
                Ubuntu, 
                Cantarell, 
                "Helvetica Neue", 
                sans-serif;
}
```

### Use the :target pseudo class to show and hide elements
Check out the example in `css_text_transition.html`

## CSS Variables
```css
/*Detect compatibility*/
@supports (--css: variables){
	/*Do your thing!*/
}
@supports not (--css: variables){
	/*Do it old school!*/
}

/*Convert a number to units*/
.widget{
	--size: 50;
	width: calc(1vw * var(--size));
	height: calc(1vh * var(--size));
}
/*We can't convert in the opposite direction...yet!*/

/*Fallbacks are defined AFTER the primary definitions*/
.body{
	--mainColor: rebeccapurple;
	--fallback1: salmonpink;
	background: var(--mainColor, var(fallback1), #BADA55);
}

/*Use variables in your animations, but don't try to animate the variables themselves*/
@keyframes displayArea{
	from{
		background-color: var(--color1);
	}
	to{
		background-color: var(--color2);
	}
}

/*Use vairiables to modify single properties out of entire declarations
Think of these as single property mixins*/
:root{
	--clearance: 5;
}

.info_box_large{
	margin: calc(1vmin * var(--clearance)) 20px;
}

.info_box_small{
	--clearance: 1;
}

/*Use a vairable like it's a custom property*/
*::before{ 
	content: var(--prepend);
}
.footer{
	/*Now you change everyone's before content with an inline declaration as opposed to opening up a new css block{}*/
	
	--prepend: "Copyright 2017";
}
```
