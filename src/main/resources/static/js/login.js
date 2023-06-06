// Call the dataTables jQuery plugin




$(document).ready(function() {



});



async function iniciarSesion(){

let datos={};


datos.email =document.getElementById('txtEmail').value;

datos.password =document.getElementById('txtPassword').value;






  const request = await fetch('api/login', {
    method: 'POST',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
    body: JSON.stringify(datos)
//json.strinfigy agarra cualquier objeto de javascript y lo transforma a json
  });




  //const respuesta = await request.json();

  const respuesta = await request.text();

//de esta manera nos tira a la pagina usuarios.html mostrandonos en el frontend el usuario iniciado.
  if(respuesta != 'FAIL' ){


  localStorage.token = respuesta; //la informacion del lado del cliente del token
  localStorage.emai= datos.email; //de paso le pasamos el email que se guarde en el storage.



  window.location.href= 'usuarios.html';

  }else{

alert ("Error de credenciales. Pruebe nuevamente");



  }

}






