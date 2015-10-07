/**
 * 
 */

function sendChannelNumber(n) {
	
    $.ajax({
		 url: 'ChannelSwitching',
		 data: "ChannelNo="+n,
		 cache: false,
		 processData: false,
		 type: 'POST',
		 success: function(data){  
		 	var hello=data;		 	
		 	console.log(hello);
		 	if(hello!="-1"){
		 		var channelURL = "videos"+"/"+hello+"_Video.mp4";
		 		document.getElementById('vid').src = channelURL;
		 		console.log(channelURL);
		 		document.getElementById('vid').load();
		 	}
		 	else {
		 		alert("Channel Unavailable");
		 	}
		 		
		 }
	});
}

function incChannelNumber() {
	var a = document.getElementById('chno').innerHTML*1+1; 
	document.getElementById('chno').innerHTML = a;
	console.log(a);
	sendChannelNumber(a);
}

function decChannelNumber() {
	var b =document.getElementById('chno').innerHTML -1; 
	document.getElementById('chno').innerHTML = b;
	console.log(b);
	sendChannelNumber(b);
	
}

function manChannelChange() {
	var c = document.getElementById("no").value;
	document.getElementById('chno').innerHTML = c;
	console.log(c);
	sendChannelNumber(c);
}