//Necesitamos variables de cada sección
let botones=document.getElementById("buttons");
let tFutbol=document.getElementById("tFutbol");
let tTenis=document.getElementById("tTenis");
let tBaloncesto=document.getElementById("tBaloncesto");
const ponerTabla=(event)=>{
    let elemento= event.target;
    //Comprobamos que se ha hechoo click en un botón
    if(elemento.nodeName=="BUTTON") {
        //Hacemos desaparecer todas las tablas
        tFutbol.style="display: none";
        tTenis.style="display: none";
        tBaloncesto.style="display: none";

        switch(elemento.innerText) {
            //Buscamos cuál es el botón que se ha pulsado y hacemos aparecer esa tabla
            case "Fútbol":
                tFutbol.style="display: block";
                break;
            case "Tenis":
                tTenis.style="display: block";
                break;
            case "Baloncesto":
                tBaloncesto.style="display: block";
                break;
        }
    }
}

// Los botones tienen el único evento
botones.addEventListener("click",ponerTabla);