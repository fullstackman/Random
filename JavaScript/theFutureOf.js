/* Notes from this Douglas Crokford video on the future of programming languages:
 * https://www.youtube.com/watch?v=NPB34lDZj3E
 * BTW you might like the new number format he proposed:
 * https://github.com/douglascrockford/DEC64 
 */

/* NUMBER 01
 * This is what null should have been in the first place!
 * It is an immutable, empty object.
 * In a sequence of code execution and function calls, if anything fails to compute,
 * it could return this null object. We could then run equality checks against this
 * immutable definition.
 */

const realNull = Object.freeze(
	Object.create()
);

/* NUMBER 02
 * This is basically how an ES6 generator function works and it's more elegant:
 * function factory(...){
 *   state variables declared and defined
 *   return function generator(){
 *     compute new value(s)
 *     update state variables if necessary
 *     return value
 *   }
 * }
 * So then, tell me if this replaces a for loop?
 */

function element(array){
	let i = 0;
	return function generator(){
		if (i < array.length){
			let value = array[i];
			i += 1;
			return value;
		}
		// no other return?
	}
}

/* NUMBER 03
 * The impurities of JavaScript that prevent it from being a purely functional language
 */
 
Date
Math.Random
delete
Object.assign
Array.splice
Array.sort
RegExp.exec
var
let (const is okay!)
for
user interaction
the network