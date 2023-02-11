let obligatorios=document.getElementsByClassName("obligatorio");
let enviar=document.getElementById("btn_enviar");
let borrar=document.getElementById("btn_borrar")
let rellenar=document.getElementsByClassName("Rellenar")


const comprobar=()=>{
    //Esta función comprueba si los campos obligatorios están llenos
    for (let texto of rellenar) {
        texto.style="display: none"
    }

    for(let i=0; i<obligatorios.length; i++) {
        /*Si uno del array de los obligatorios está vació
        hacemos aparecer el p de "Rellenar este campo" */
        if(obligatorios[i].value=="") {
            rellenar[i].style="display: block";
        }
    }

}
const reseteo=()=>{
    //Quitar los de "Rellenar cuano damos al input:reset"
    for (let texto of rellenar) {
        texto.style="display: none"
    }
}
//Dos listener para dos eventos
enviar.addEventListener("click", comprobar);
borrar.addEventListener("click",reseteo);