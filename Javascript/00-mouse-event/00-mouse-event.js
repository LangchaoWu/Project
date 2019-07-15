/*
=======================
00-mouse-event.js
=======================
Student ID:23387910
Comment (Required):
	the function passes the event ,when click event happens  x,y get the position of the mouse and print out.

=======================
*/

const clickhandler=function(e){
	var x = e.clientX; 
    var y = e.clientY;
	console.log(x +'   ' + y);
}
document.addEventListener("click" , clickhandler);