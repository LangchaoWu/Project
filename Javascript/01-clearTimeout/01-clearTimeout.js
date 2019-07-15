/*
=======================
01-clearTimeout.js
=======================
Student ID:23387910
Comment (Required):
 count counts the numbers of clicks for first button, time_id  array store the number of timeout. when click the second button 
 it go through all the array, clear all the timeout.
=======================
*/
let count=0;
var time_id =[];
let btn00 = document.getElementById('btn00');
let btn01 = document.getElementById('btn01');
const clickhandler =function(){
	 time_id[count] = setTimeout(function(){console.log("Delayed Hello");
	},10000);
	count++;
}
const clear =function(){
	for(let i=count;i>=0;i--){
	clearTimeout(time_id[i]);
	}
	console.log("All remaining timers canceled");
}
btn00.addEventListener("click",clickhandler);
btn01.addEventListener("click",clear);

