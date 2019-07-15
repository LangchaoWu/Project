/*
=======================
02-keyboard-event.js
=======================
Student ID:23387910
Comment (Required):
	array_a stores pressed keycode, array_b stores the order keydoce . when array_a has the part same as array_b then print message.
	array_a.slice select same length as array_b to compare. 
=======================
*/
var array_a =[];
let count=0;
var array_b =[38,38,40,40,37,39,37,39,66,65];
const keydect =function(event){	
	if(event.keyCode == 37){
		array_a[count]=37;
		count++;
	}
	else if(event.keyCode == 38){
		array_a[count]=38;
		count++;
	}
	else if(event.keyCode == 39){
		array_a[count]=39;
		count++;
	}
	else if(event.keyCode == 40){
		array_a[count]=40;
		count++;
	}
	else if(event.keyCode == 65){
		array_a[count]=65;
		count++;
	}
	else if(event.keyCode == 66){
		array_a[count]=66;
		count++;
	}
	else {
		array_a[count]=0;
		count++;
		}
	console.log(event);
	for(let i=0;i<count;i++){
		if(JSON.stringify(array_a.slice(i,i+10)) === JSON.stringify(array_b)){
			console.log("CHEATS ACTIVATED");
		}
	}
}
document.addEventListener("keydown",keydect);
