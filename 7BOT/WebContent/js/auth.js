var logado = document.cookie.split("=")[1];
console.log(logado)

document.querySelector("#user-name").textContent += logado;
