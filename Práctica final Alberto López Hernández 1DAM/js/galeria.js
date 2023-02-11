//Array con el nombre de las imágenes
let imagenes=["alexia.jpg","djokovic_nadal_federer.jpg","hamilton.jpg",
"mcgregor.jpg","messi_cristiano.jpg","michael_phelps.jpg","simone_biles.jpg",
"usain_bolt.jpg"];
//Array con los textos de la descripción
let altText=[
    "Alexia Putellas gana el Balón de Oro 2021 y hace historia para el fútbol femenino español",
    "Nadal y Federer se encuentran con Djokovic en la cima del tenis mundial",
    "Lewis Hamilton entra en la historia de la Fórmula 1",
    "McGregor-Nurmagomedov convierten en un fenómeno mundial a la UFC",
    "La rivalidad de Lionel Messi y Cristiano Ronaldo.",
    "El nadador estadounidense Michael Phelps se transformó durante esta década en el atleta más ganador de la historia de los Juegos Olímpicos",
    "Simone Biles, leyenda de la gimnasia",
    "Usain Bolt es un atleta jamaicano y una leyenda olímpica, con ocho medallas de oro en los Juegos Olímpicos de Pekín 2008, Londres 2012 y Río 2016."
];
let desc=document.getElementById("desc__span")
let imgs=document.querySelectorAll(".galeria__img");
function cargarImagenes() {
    //Evento que carga las imágenes en orden aleatorio al entrar a la página
    for (let i=0;i<imagenes.length;i++) {
        let posicion = Math.floor(Math.random() * imgs.length);
        if(imgs[posicion].alt=="") {
            imgs[posicion].src = "../assets/images/Galeria/" + imagenes[i];
            //Usamos el alt para guardar el texto que sale al dar click
            imgs[posicion].alt=altText[i];
        }
        else {
            //Si un img ya tiene una imagen retrocedemos para buscar una vacia
            i=i-1;
        }

    }
}
const escribir=(event)=>{
    //Aquí se escribe el texto de la descripción
    let elemento=event.target;
    if(elemento.nodeName=='IMG') {
        desc.textContent=elemento.alt;
    }
}

let galeria=document.getElementById("gallery");
//Dos eventos
document.addEventListener("DOMContentLoaded", cargarImagenes);
galeria.addEventListener("click", escribir);

