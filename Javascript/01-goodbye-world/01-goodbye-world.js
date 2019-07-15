/*
=======================
01-goodbye-world.js
=======================
Student ID:23387910
Comment (Required):
	initializes two strings variables 
	set the function to concatenates these two strings 
	set a  time out  change the x  so that new strings will be assign to x and print out

=======================
*/
let x = 'Hello';
let y = 'Langchao Wu';
const print_greeting = function(){
    console.log( x + ' '+ y );
}
setTimeout(print_greeting, 3000); 
x = 'Goodbye';
console.log();