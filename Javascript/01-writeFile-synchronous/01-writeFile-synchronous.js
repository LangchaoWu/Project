/*
=======================
01-writeFile-synchronous.js
=======================
Student ID:23387910
Comment (Required):
     the function writefile calls itself when it finish writing so the order is always the same.
=======================
*/
const fs = require("fs");
const output_dir = "./output/";
const files= [];
let index=0;
let writeFiles = function (){
	files[index]="0"+index+"-file-output.txt";
	fs.writeFile(`${output_dir}${files[index]}`, "Hello World", function (err,data){
		if(err){
			console.log(err);
		}
		else{
			console.log(files[index]);
			index++;
			if(index === 10){
				console.log("Finished!");
			}
			else{
				writeFiles();
			}
		}
	} );
}
writeFiles();