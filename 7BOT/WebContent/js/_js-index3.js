    // VARIAVEIS
var btn_cad = document.querySelector("#btn-cadastrar");
var btn_log = document.querySelector("#btn-logar")

var frm_cad = document.querySelector("#frm-cadastrar");
var frm_log = document.querySelector("#frm-logar");

var esqueci_pass_link = document.querySelector("#esqueci-senha-link");
var esqueci_pass = document.querySelector("#esqueci-senha ");
var btn_esqueci_pass = document.querySelector("#btn_esqueci_pass");

var logar = document.querySelector("#logar");
var cadastrar = document.querySelector("#cadastrar");
btn_cad.addEventListener("click", function() {
    showAndHide(frm_log, frm_cad);
    activeBtn(btn_log, this);
})

btn_log.addEventListener("click", function() {
    showAndHide(frm_cad, frm_log);
    activeBtn(btn_cad, this)   
})

esqueci_pass_link.addEventListener("click", function(e){
    HideShowEsqueciPass(esqueci_pass.style);
})


btn_esqueci_pass.addEventListener("click", function(e){
    e.preventDefault();
    var email = document.querySelector("#email-esqueci-pass");
    var erro = document.querySelector("#erro_esq");

    if(validateEmail(email.value)) {
        document.querySelector("#sucesso").textContent = "O email foi enviado!"
        email.value = "";
        erro.textContent = "";
        esqueci_pass.style.display = "none";
    } else {
        if(email.value != "") {
            erro.textContent = "Email inválido!";
        }
    }
})


logar.addEventListener("click", function(e) {
    e.preventDefault();
    var email = document.querySelector("#email-login");
    var email_valor = email.value;

    var senha = document.querySelector("#senha-login");
    var senha_valor = senha.value;
    var erro = document.querySelector("#erro");
    if(email_valor == "" && senha_valor == "") {
        return "";
}
    if(validateEmail(email.value)) {
        if(senha_valor.length < 8) {
            erro.textContent = "senha inválida!";
            senha.value = "";
        } else {
            erro.textContent = "";
            this.style.display = "none";
            document.querySelector("#load").style.display = "block";

            setTimeout(sendForm(frm_log), 1000);
        }
    } else {
        erro.textContent = "Email inválido!";
        email.value = "";
        senha.value = "";
    }
 
})

cadastrar.addEventListener("click", function(e){
    e.preventDefault();
    var nome = document.querySelector("#nome-cad").value;
    var email = document.querySelector("#email-cad").value;
    var senha = document.querySelector("#senha-cad");
    var erro = document.querySelector("#erro-cad");

    var validacao = validateRegister(nome, email, senha.value);

    if(validacao == "") {
        showAndHide(frm_cad, frm_log);
        activeBtn(btn_cad, btn_log);
        sendForm(frm_cad);
    } else {
        senha.value = "";
        erro.textContent = validacao;
    }

})

function validateRegister(nome, email, senha) {
    if(nome == "" || email == "" || senha == "") {
        return "Preencha todos os campos!"
    }
    for(var cont = 0; cont < 10;cont++) {
        if(nome.indexOf(cont) >= 0) {
            return "O nome só pode possuir caracteres!"
        }
    }
    if(!validateEmail(email)) {
        return "Email invalido!"
    }
    if(senha.length < 8) {
        return "Senha invalida!"
    }
    return "";

}

function HideShowEsqueciPass(pass) {
    if(esqueci_pass.style.display == "")
        esqueci_pass.style.display = "block"
    else {
        pass.display == "none" ? 
        pass.display = "block" :
        pass.display = "none";  
    }
}


function validateEmail(email) {
    if((email.search("@") !=-1) &&
        (email.search(" ") ==-1) && 
        (email.search(".") !=-1) &&      
        (email.indexOf(".") >=1) && 
        (email.lastIndexOf(".") < email.length - 1)){
        return true;
    }

    return false;
}

function sendForm(frm) {
	frm.action = "/7BOT/controlador"
	frm.method = "POST";
	frm.submit();
}


function activeBtn(desativar, ativar) {
    desativar.className = "";
    ativar.className = "btn-ativo";
}


function showAndHide(esconder, mostrar) {
    esconder.className = "frm-desativado";
    mostrar.className = "frm-index";
}