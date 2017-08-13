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

### Use a "Font Stack" of native fonts for better performance and reliability
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
