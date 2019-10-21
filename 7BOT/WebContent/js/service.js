var services = document.querySelectorAll(".services");

for(var i = 0; i < services.length;i++) {
    services[i].addEventListener("click", function() {
        if(this.children[1].className == "abrir") {
            this.children[1].className = "";
        } else {
            for(var a = 0; a < services.length;a++) {
                if(services[a].children[1].className == "abrir") {
                    services[a].children[1].className = "";
                }
            }
            this.children[1].className = "abrir";
        }
    })
}

var btn_mat = document.querySelector("#btn-disciplinas");
var service = document.querySelector("#service");
var load = document.querySelector("#load");
var frm_pesq = document.querySelector("#frm-pesquisa");
var resp_pesq = document.querySelector("#pesquisa");

btn_mat.addEventListener("click", function(e){
    e.preventDefault();
    resp_pesq.textContent = "";
    HideAndShow(service, load);     
    setTimeout( function() {

        HideAndShow(load, service);  

        var pesquisa = frm_pesq.children[0].value;
        var achou = false;
        for(var a = 0; a < services.length;a++) {

            var disciplinas = services[a].children[0].textContent.toUpperCase();
            console.log(services[a].children[0].textContent.indexOf("a")) 
            if(disciplinas.indexOf(pesquisa.toUpperCase()) < 0) {
                services[a].style.display = "none";
            } else {
                services[a].style.display = "block";
                achou = true;
            }

        }
        if(!achou) {
            resp_pesq.textContent = "Nada foi encontrado com \"" + pesquisa + "\"";
        }

    },1000)   


})


function HideAndShow(esconder, aparecer){
    esconder.style.display = "none";
    aparecer.style.display = "block";
}