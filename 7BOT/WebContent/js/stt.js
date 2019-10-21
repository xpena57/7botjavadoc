//webkitURL é legado 
URL = window.URL || window.webkitURL;
// stream é criado a partir getUserMedia()
var gumStream;
// Objeto do Record.js
var rec;
// MediaStreamAudioSourceNode
var input;
// criar novo AudioContext
var AudioContext = window.AudioContext || window.webkitAudioContext; // Classe
var audioContext; // objeto
// selecionar os botoes
console.log("stt.JS");

var btnRecord = document.querySelector(".audioText");
var btnPause = document.querySelector("#pauseAudio");
var btnStop = document.querySelector("#stopAudio");

btnRecord.addEventListener("click", function(event) {
	if(btnRecord.id == "sendAudio") {
		
		event.preventDefault();
		constraints = {
				audio : true,
				video : false
		}
		
		navigator.mediaDevices.getUserMedia(constraints).then(function(stream) {
			audioContext = new AudioContext;
			gumStream = stream;
			input = audioContext.createMediaStreamSource(stream);
			
			rec = new Recorder(input, {
				numChannels : 1
			});
			
			rec.record();
		}).catch(function(err){
			console.log(err);
		});
		
	}
	
	
});

btnPause.addEventListener("click", function(event) {
	event.preventDefault();
	if(rec.recording) {
		rec.stop();
	} else {
		rec.record();
	}
});

btnStop.addEventListener("click", function(event) {
	event.preventDefault();
	
	rec.stop();
	gumStream.getAudioTracks()[0].stop();
	rec.exportWAV(generateBlob);
});

function generateBlob(blob) {
	createAudioElement(blob, "me");
	sendBlobToText(blob);
}

function sendBlobToText(blob) {
	var xhr = new XMLHttpRequest();
	xhr.open("POST", "stt", true);
	xhr.setRequestHeader("Content-type", "audio/wav");
	xhr.addEventListener("load", function() {
		if(xhr.status == 200) {
			// Deu bom
			var resposta = JSON.parse(xhr.responseText);
			resposta[0].alternatives.forEach(function(transcript) {
				callBot(transcript.transcript);
			});
		} else {
			// Deu ruim
			console.log(xhr.status);
			console.log(xhr.responseText);
		}
	});
	xhr.send(blob);
}









