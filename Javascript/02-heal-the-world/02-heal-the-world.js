/*
=======================
02-heal-the-world.js
=======================
Student ID:23387910
Comment (Required):
    print() is undefined so need to create a wrapper function.
=======================
*/

const print =function(message){
	console.log(message);
}
const helper =function(){
	print("Heal the World");
}
setTimeout(helper,5000);
console.log();