<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="shortcut icon" href="logo.jpeg">
    <title>Disciplinas</title>
</head>
<link rel="stylesheet" href="css/cabecalho.css">
<link rel="stylesheet" href="css/disciplina.css">
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
    <main>

        <div id="text-background">
            <div class="structure">
                <h1>Disciplinas</h1>
            </div>
        </div>

        
        <div id="categorie">    
            <div class="structure">

            <form action="" id="frm-pesquisa">
                <input list="browsers" name="browser" placeholder="Pesquise disciplinas" name="pesq">
                    <datalist id="browsers" size="3">
                        <option value="Computational Thinking">
                        <option value="Design de Software">
                        <option value="Estruture de banco de dados">
                        <option value="Web Reponsive">
                        <option value="Domain Driver Design">
                    </datalist>
                <button id="btn-disciplinas">Pesquisar</button>
            </form>
            </div>
        </div>
        <div class="structure">
            <p id="load"> 
                <img src="images/load.gif">
            </p>
            <p id="pesquisa"></p>
            <div id="service">   
                
                <c:forEach var="disciplina" items="${lista}">					
                    
                    <div class="services">
                        <h3>${disciplina.titulo}</h3>
                    
                        <div>
                            <c:forEach var="material" items="${disciplina.materias }">
                                <a href="listarMaterial?disciplina=${disciplina.titulo }&material=${material}">${material}</a>
                            </c:forEach>
                        </div>
                        
                    </div>
                </c:forEach>


            </div>
        </div>

    </main>

</body>
<script src="js/auth.js"></script>
<script src="js/service.js"></script>
</html>