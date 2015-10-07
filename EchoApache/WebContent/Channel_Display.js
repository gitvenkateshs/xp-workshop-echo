/**
 * 
 */

window.onload = function () {
var today = new Date();
h = today.getHours();
m = today.getMinutes();
s = today.getSeconds();
var diff = timeDiff(h,m,s);
m = checkTime(m);
s = checkTime(s);
}

function checkTime(i) {
    if (i < 10) {i = "0" + i};  // add zero in front of numbers < 10
    return i;
}

function timeDiff() {
var today = new Date();
    var H = today.getHours();
    var M = today.getMinutes();
    var S = today.getSeconds();
    M = checkTime(M);
    S = checkTime(S);
var diff = (H - h)*3600 + (M - m)*60 + (S - s);

return diff;
}

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
		 		document.getElementById('vid').currentTime = document.getElementById('vid').currentTime + timeDiff();
		 		document.getElementById('vid').play();
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