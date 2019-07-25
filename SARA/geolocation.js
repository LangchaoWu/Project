if(navigator.geolocation) {
	navigator.geolocation.getCurrentPosition(showPosition);
}
else {
	document.getElementById("Latitude").innerHTML = "Geolocation is not supported by this browser.";
	document.getElementById("Longitude").innerHTML = "Geolocation is not supported by this browser.";
}
