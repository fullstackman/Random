//Main execution
warmUp("Neo");
bistro();

// Something to warm up with
function warmUp(name){
	alert("Hello, "+name+"!");
}

// Let's get familiar with some basic operations
function bistro(){
	// The global vairable glub is "hoisted"
	// Even though it is declared later in the program,
	// it is still recognized by this function
	console.log("Do you like "+glub);
	// So it is marked as undefined rather than throwing a ReferenceError

	var a;
	console.log("The value of a is " + a); // logs "The value of a is undefined"

	if(true){
		// New in ECMAScript 6!
		// the variable x will only be preserved throughout this block!
		// But the variable cannot be hoisted like other variables.
		let x;
		if(x === undefined){  // no exception
			console.log("The value of x could not be found...");
		}
		// Constants have the same scoping rules as let variables.
		const two = 2;
		console.log(x+two);  // returns a NaN exception
		x = null;
		console.log(x*two);  // x evaluates to zero!
	}

	// throws ReferenceError exception because of x's block-level scope
	console.log("The value of x is " + x);

}


// Throw in a global variable for fun
var glub = "Pies overeasy";
// Once declared in a document, we could refer to this variable from an
// iframe as parent.glub
