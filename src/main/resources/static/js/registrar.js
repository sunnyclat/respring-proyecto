// Call the dataTables jQuery plugin




$(document).ready(function() {



});



async function registrarUsuarios(){

let datos={};

datos.nombre =document.getElementById('txtNombre').value;
datos.apellido =document.getElementById('txtApellido').value;
datos.email =document.getElementById('txtEmail').value;
//datos.telefono =document.getElementById('txtTelefono').value;
datos.password =document.getElementById('txtPassword').value;

let repetirPassword= document.getElementById('txtRepetirPassword').value;



if(repetirPassword != datos.password){

alert('La contraseña escrita no coincide');
return;
}

  const request = await fetch('usuarios', {
 // const request = await fetch('api/usuarios', {
    method: 'POST',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
    body: JSON.stringify(datos)
//json.strinfigy agarra cualquier objeto de javascript y lo transforma a json
  });


//alert("la cuenta se creó exitosamente!");
  //window.location.href= 'login.html';


 // const usuarios = await request.json();

}






