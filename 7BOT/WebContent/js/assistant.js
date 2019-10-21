
function scrollDivDown(div) {
	for (var i = 0; i < div.offsetHeight; i++) {
		div.scrollTop++;
	}
}

function createMessage(message, type) {
	var chat = document.querySelector("#chat");
	var div = createDiv(message, type);
	chat.appendChild(div);
	scrollDivDown(chat);
}

function createDiv(text, type) {
	var div = document.createElement("div");
	var p = document.createElement("p");
	div.classList.add(type);
	p.textContent = text;
	div.appendChild(p);
	return div;
}
var btnSendQuestion = document.querySelector(".audioText");
btnSendQuestion.addEventListener("click", function(event) {
	if(btnSendQuestion.id == "sendText") {
		event.preventDefault();
		var question = document.querySelector("#pergunta");
		createMessage(question.value, "me");
		callBot(question.value);
		question.value = "";
	}
	
});

function callBot(msg) {
	var xhr = new XMLHttpRequest();
	xhr.open("POST", "v1", true);
	xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded; charset=utf-8");
	xhr.addEventListener("load", function() {
		if(xhr.status == 200) {
			// Codigo de sucesso
			var respostas = JSON.parse(xhr.responseText);
			respostas.forEach(function(resposta) {
				console.log(resposta);
				console.log(audioOrText)
				if(!(resposta === null) && !(resposta == ""))
					if(audioOrText) {
						sendMessageToVoice(resposta);
					} else {
						createMessage(resposta, "bot");
					}
					
			});
		}else{
			// Codigo de deu ruim!
			console.log(xhr.status);
			console.log(xhr.responseText);
		}
	});
	var data = "question=" + msg;
	xhr.send(data);
}


