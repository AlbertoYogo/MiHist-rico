//Arrays de las imágenes y sus respectivas descripciones
let imagenes=["mejor_momento1.jpg","mejor_momento2.jpg","mejor_momento3.jpg",
    "mejor_momento4.jpg","mejor_momento5.jpg","mejor_momento6.jpg"]

let descripciones=[
    "Los Cubs de Chicago tenían más de 100 años sin poder ganar una Serie Mundial, y muchos aseguraban que se debía a la “maldición de la cabra”, hecho que se remonta a la Serie Mundial del año 1945. En ese momento, William Sianis asistió al Wrigley Field, estadio de los Cubs, junto a su cabra, pero las autoridades del estadio no le permitieron la entrada. Sianis, furioso, arrojó “una maldición” sobre el equipo, que desde ese entonces no llegó a la final hasta 2016.",
    "Los Cleveland Cavaliers perdieron tres de los cuatro primeros partidos de la final 2016- 2017 ante los Golden State Warriors, por lo que tenían que ganar los tres encuentros restantes, dos como visitantes para ganar el trofeo. El quinto partido lo ganaron por 15 puntos (112–97) y el sexto por 14 puntos (115–101), por lo que disputaron el séptimo y decisivo en la casa de los Warriors.",
    "Federer, de 37 años de edad, es el segundo tenista en conseguir 100 títulos profesionales, desde que obtuvo el primero en el año 2001, en Milán. Solo el estadounidense Jimmy Connors tiene más trofeos, 109",
    "El nadador estadounidense Michael Phelps disputó sus últimos Juegos Olímpicos en Río de Janeiro 2016, donde obtuvo cinco medallas de oro y una de plata, pero su legado va mucho más allá.",
    "Por más de 10 años el atletismo estuvo dominado por un jamaiquino, Usain Bolt, apodado “el hombre más rápido de la Tierra”. El velocista anunció previamente en los Juegos Olímpicos 2016 que sería su última competencia y su última oportunidad para buscar el “triple-triple”, es decir, ganar las tres medallas de oro en tres ediciones de Juegos Olímpicos.",
    "El 8 de julio de 2014, 58.141 personas asistieron al estadio Mineiráo, en Belo Horizonte, para ver la semifinal de la Copa Mundial entre Brasil y Alemania. Brasil llegó a la semifinal tras superar a Colombia (2–1), pero sin poder contar con Neymar, quien sufrió una grave lesión en la espalda. Alemania avanzó a esta fase luego de superar a Francia (1–0) y le tocaba el difícil reto de enfrentarse al anfitrión de la Copa."
]
/*Tres variables: contenedor de botones para saber cuando pulsamos uno,
imagen que vamos cambiando el src
y texto que cambiamos el textContent*/
let botones=document.getElementById("botones");
let imagen=document.getElementById("imagenPpal");
let texto=document.getElementById("textoPpal");

const cambirImgText=(event)=>{
    //Método para el evento.
    //Guardamos en una variable el event.target
    let elemento=event.target;
    for(let i=0; i<imagenes.length; i++) {
        //Uso el id para saber que botón ha sido pulsado
        /*NOTA: Como usamos el id para saber si se ha pulsado el botón no
        hace falta comprobar el TagName o el NodName*/
        if(elemento.id=="boton"+i) {
            /*Cuando encontramos el botón que se ha pulsado 
            ponemos su imagen y su descripción (posiciones del Array)*/
            imagen.src="../assets/images/Mejores momentos/"+imagenes[i];
            texto.textContent=descripciones[i];
        }
    }
}

//Un solo evento al pulsar un botón
botones.addEventListener("click",cambirImgText);

