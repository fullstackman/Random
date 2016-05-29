// Main execution
fish();

// Looking at some intermediate functionality
function fish(){
	var sampleRegEx = /ab+c/;

	// ES2015 brings String interpolation!!!
	var name = "Bob", time = "today";
	// Yes, those are back ticks!
	console.log(`Hello ${name}, how are you ${time}?`);

	// Declaration of an array literal
	var zoo = ["lion",,"tiger",,"howler monky"];
	console.log(zoo[1]);  // Undefined

	// Even objects can be declared as literals!
	var sales = "Toyota";

	function carTypes(name) {
	  if (name === "Honda") {
	    return name;
	  } else {
	    return "Sorry, we don't sell " + name + ".";
	  }
	}

	var car = { myCar: "Saturn", getCar: carTypes("Honda"), special: sales };

	console.log(car.myCar);   // Saturn
	console.log(car.getCar);  // Honda
	// Another way to access the properties of an object!
	console.log(car["special"]); // Toyota
}
