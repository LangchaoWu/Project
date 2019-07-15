/*
=======================
03-mister-worldwide.js
=======================
Student ID:23387910
Comment (Required):
  it will keeping printing the message when execute the for loop, nothing happen , just deday the printing for a second.
=======================
*/

const print =function (){	
	console.log("¡Dale!");
	setTimeout(print,1000);
}
setTimeout(print,1000);
console.log();

