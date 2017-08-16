/* Notes from this Douglas Crokford lecture on how the DOM works:
 * https://youtu.be/Y2Y0U-2qJMs
 * Even though it was recorded in 2006, some of his recommendations are still relevant for new web developers that mindlessly copy source code they find on tutorials from before the 2010's
 */

/*TIP 01
    This commenting scheme is unnecessary unless you are targeting the Mosaic browser from the 90s.
    <!-- // -->
*/

/*TIP 02
    The attribute "type='text/javascript' " was implemented to replace the attribute "language=javascript"
    Nowadays we use "type='application/javascript' " which is the default setting for a script tag anyway.
    See what other types are supported:
    http://www.iana.org/assignments/media-types/media-types.xhtml
*/

/*TIP 03
    Place script tags as close to the bottom of the body as possible. Leave CSS links as high in the head as possible.
    Also minify and gzip these files.
*/

/*TIP 04
    Avoid document.write and document collections (document.all, document.embeds, etc.)
*/

/*TIP 05
    Use the new school method of manipulating rendered elements
*/

let my_image = document.getElementById('the_one_image');
//Old school
if(my_image.complete){
    my_image.src = "http://example.com/img.png";
}

//New School
if(my_image.getAttribute('complete') ){
    my_image.setAttribute('src', "http://example.com/img.png");
}

/*TIP 06
    Quotable:
    The browser has an event-driven, single-threaded, asynchronous programming model.
*/

/*TIP 07
    Due to the bubble up nature of event dispatching, you can set an event listener to a parent element to capture all such events on its descendants.
    So one parent can listen for all clicks on its child list items.
    You can then call event.stopPropogation()
    More info:
    https://developer.mozilla.org/en-US/docs/Web/API/Document_Object_Model/Examples#Example_5:_Event_Propagation
*/

/*TIP 08
    Set massive data structures to null when you are done using them so that the garbage collector will take care of them.
*/

/*TIP 09
    Be careful with the use of these methods because they break the asynchronous model of the browser:
    alert()
    confirm()
    prompt()
    setTimeout()
    setInterval()
*/

/*TIP 10
    Use feature detection, NOT browser detection!
*/

/*TIP 11
    Quotable:
    The browser was not designed to be a general purpose application platform.
*/