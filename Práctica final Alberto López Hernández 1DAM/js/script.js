meses = [
  "enero",
  "febrero",
  "marzo",
  "abril",
  "mayo",
  "junio",
  "julio",
  "agosto",
  "septiembre",
  "octubre",
  "noviembre",
  "diciembre",
];

const preguntarRegistrarse=()=>{
  //Pregunta si el usuario quiere registrarse
    let respuesta=confirm("¿Quiere registrarse antes de comenzar a navegar por la página?")
    if(respuesta) {
        
    }
}

//A los 5 segunddos salta un evento solo una vez
setTimeout(preguntarRegistrarse, 5000);

let dia=document.getElementById("dia")
let mes=document.getElementById("mes")
let anno=document.getElementById("anno")

//Al entrar ponemos la fecha donde "Actualizado a:"
let timedate= new Date();
console.log(timedate);
dia.textContent=timedate.getDate()
mes.textContent=meses[timedate.getMonth()]
anno.textContent=timedate.getFullYear()
