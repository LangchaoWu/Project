/*
=======================
02-batch-b.js
=======================
Student ID:23387910
Comment (Required):

=======================
*/
const fs = require("fs");
const input_dir = "./input/";
const output_dir = "./output/";
const input_files = fs.readdirSync(input_dir);
let n = 11;
let b= 5;
let m=Math.ceil(n/b);
let file_data = Array(files.length);	
let files_read = 0;
/*const readFiles = function(){
    for(let index = 0; index < files.length; index++){
        fs.readFile(`${input_dir}${files[index]}`, "utf8", function (err, data){
            if(err){
                console.log(err);
            }
            else{
				file_data[index] = data;
				console.log(file_data);
				files_read++;
                if(files_read === files.length){
                    console.log("Finished!");
                }
				console.log("------------------------------");
            }
        } );
    }
}
readFiles();*/