

window.onload = function() {
	setTimeout(closeMsg, 4000)
}


function closeMsg() {
    var msg = document.querySelector("#chat-ball p");
    msg.style.display = "none";
}
console.log("CHAT.JS")
var OpeningChat = document.querySelector("#chat-ball img");
var chat = document.querySelector("#container-chat");
var minimizar = document.querySelector("#header-info div");

OpeningChat.addEventListener("click", function() {
    closeMsg();
    this.style.display = "none";
    ChatBot("block");
})

minimizar.addEventListener("click", function() {
    ChatBot("none");
    OpeningChat.style.display = "block";
})

var audioText = document.querySelector(".audioText");

var writing = document.querySelector("#options input");
var icon = document.querySelector(".audioText img");
writing.addEventListener("keyup", function(){
    if(this.value != "") {
        icon.src = "images/send.png";
        audioText.id = "";
        audioText.id = "sendText";
    } else {
        icon.src = "images/micro.png";
        audioText.id = "";
        audioText.id = "sendAudio";
    }
})


var stopAudio = document.querySelector("#stopAudio");
var pauseAudio = document.querySelector("#pauseAudio");

audioText.addEventListener("click", function() {
	if(audioText.id != "sendText") {
		writing.style.display = "none";
	    document.querySelector(".audioText").style.display = "none";
	    stopAudio.style.display = "block";
	    pauseAudio.style.display = "block";
	} else {
		icon.src = "images/micro.png";
		audioText.id = "sendAudio";	
	}
});

pauseAudio.addEventListener("click", function() {
    if(this.children[0].src.search("images/play.png") > 0) {
        this.children[0].src = "images/pause.png";    
    } else 
        this.children[0].src = "images/play.png";

});

stopAudio.addEventListener("click", function() {
    writing.style.display = "block";
    document.querySelector(".audioText").style.display = "block";
    stopAudio.style.display = "none";
    pauseAudio.style.display = "none";
})
var acessibilidade = document.querySelectorAll(".choiceAceb");
for(var i = 0; i < acessibilidade.length;i++){
	acessibilidade[i].addEventListener("click", function() {
		
		audioOrText = this.id == "text" ? false : true; 
		document.querySelector(".acessibilidade").style.display = "none";
		document.querySelector("#options").style.display = "flex";
		callBot("");
	})
	
}

function ChatBot(func) {
    chat.style.display = func;
}