// Main execution
linez();
specialz(false);

function linez(){
	// Multi-line string literals!
	var str = "this string \
	is broken \
	across multiple\
	lines."
	console.log(str);   // "this string is broken across multiplelines."
}

function specialz(show){
	if(show){
		// Obviously, two backslashes are used to escape these special characters.
		console.log("\\0 is the Null Byte character.");
		console.log("\\b is the Backspace character.");
		console.log("\\f is the Form Feed character.");
		console.log("\\n is the New Line character.");
		console.log("\\r is the Carriage Return character.");
		console.log("\\t is the Tab character.");
		console.log("\\v is the Vertical Tab character. (An obsolete character as far as \
			I could tell.");
		console.log("\' is the Apostrophe character.");
		console.log("\" is the Double Quote character.");
		console.log("\\ is the Backslash character.");
		console.log("\\XXX is the The character with the Latin-1 encoding specified by up \
			to three octal digits XXX between 0 and 377. For example, \\251 is the octal \
			sequence for the copyright symbol.");
		console.log("\\xXX is The character with the Latin-1 encoding specified by the \
			two hexadecimal digits XX between 00 and FF. For example, \\xA9 is the \
			hexadecimal sequence for the copyright symbol.");
		console.log("\\uXXX is The Unicode character specified by the four hexadecimal \
			digits XXXX. For example, \\u00A9 is the Unicode sequence for the copyright symbol.");
		console.log("\\u{XXXXX} is Unicode code point escapes. For example, \\u{2F804} is \
			the same as the simple Unicode escapes \\uD87E\\uDC04.");
		
		// Example
		console.log("Can you tell \n which are the \t special characters \n used in this string?");
	}
	else{
		console.log("Do you know that there are special character sequences?");
	}
}
