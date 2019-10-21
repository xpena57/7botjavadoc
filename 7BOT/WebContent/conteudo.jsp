<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="shortcut icon" href="images/logo.jpeg">
    <title>Conteudo</title>
</head>
<link rel="stylesheet" href="css/cabecalho.css">
<link rel="stylesheet" href="css/chat.css">
<link rel="stylesheet" href="css/conteudos.css">
<body>
    <header>
        <div class="structure" id="header-flex">

            <div id="header-infos-site">
            	<a href="app.html"><img src="images/logorecortado.png" alt="Logo 7BOT"></a>
                <h1 id="user-name">Bem vindo, </h1>
            </div>

            <div>
                <a href="disciplinas" class="line">Disciplinas</a>
                <a href="#minhaConta">Minha conta</a>
                <a href="#sair">Sair</a>
            </div>
        </div>
    </header>
	<div id="timeLine">
    	<div class="structure">
    		<p>${ nomeDisciplina } <b> > </b> ${ nomeMateria }</p>
    	</div>
    </div>
    <div class="structure">

        
        <div id="choice">
            <p>Escolha o conteudo</p>
            <select name="conteudo" id="conteudo">
                <c:forEach var="material" items="${lista }">
					<option value="2">${material.titulo }</option>
				</c:forEach>
            </select>
        	<hr>
        </div>
        <div id="container-conteudo">
			
			<c:forEach var="materialTexto" items="${lista }">
				<h1>${materialTexto.titulo }</h1>
				<p>${materialTexto.escopo }</p>
				
			</c:forEach>
			
            
        
        </div>
    </div>  
    
    <div id="container-chat">

        <div id="header-chat">
            <div id="anna">
                <img src="images/anna.png" alt="Anna, o bot">
            </div>

            <div id="header-info">
                <p>Anna</p>
                <div>
                    <i></i>
                </div>
            </div>
        </div>

        <div id="chat">
            <div class="acessibilidade">
            	<p>Que tipo de mensagem</p>
            	<p>você prefere receber da anna?</p>
            	<button id="audio" class="choiceAceb">Apenas áudios</button>
            	<button id="text" class="choiceAceb">Apenas textos</button>
            </div>
        
        </div>

        <div id="options">
            <input type="text" id="pergunta" placeholder="Pergunte algo....">
            <div>
                <button id="sendAudio" class="btn audioText"><img src="images/micro.png"></button>
                <button id="pauseAudio" class="btn"><img src="images/pause.png"></button>
                <button id="stopAudio" class="btn"><img src="images/stop.png"></button>
                <!-- <button id="">G</button> -->
            </div>
        </div>

    </div>
    <div id="chat-ball">
        <img src="images/anna.png" alt="anna, o bot">

        <p>Hey! Eu sou Anna, e estou aqui para te ajudar :D</p>
    </div>
    

</body>
<script>
	var audioOrText;
</script>
<script src="js/auth.js"></script>
<script src="https://cdn.rawgit.com/mattdiamond/Recorderjs/08e7abd9/dist/recorder.js"></script>
<script src="js/assistant.js"></script>
<script src="js/stt.js"></script>
<script src="js/tts.js"></script>
<script src="js/chat.js"></script>
</html>