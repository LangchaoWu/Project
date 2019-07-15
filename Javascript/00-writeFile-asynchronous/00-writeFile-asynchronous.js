/*
=======================
00-writeFile-asynchronous.js
=======================
Student ID:23387910
Comment (Required):
      use for loop to asynchronously write 10 files. when i increases, the early files may not finish write so the order is not same.
=======================
*/
const fs = require("fs");
const output_dir = "./output/";
const files= [];
for(let i=0; i<10;i++){
	files[i]="0"+i+"-file-output.txt";
	fs.writeFile(`${output_dir}${files[i]}`, "Hello World",function(err) {
		if (err) {
			console.log(err);
		}else{
			console.log(files[i]);
		}
		if(i==9)console.log("Finished!");
	});
}