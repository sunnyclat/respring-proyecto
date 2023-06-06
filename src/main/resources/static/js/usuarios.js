// Call the dataTables jQuery plugin



//data table dispone de todas las funcionalidades como la paginacion.

//la funcion ready hace que se ejecute todo el codigo que esta ahi dentro una vez cargada la pagina



$(document).ready(function() {


//alert(123423);

cargarUsuarios();
  $('#usuarios').DataTable();
});



async function cargarUsuarios(){


  const request = await fetch('api/usuarios', {
    method: 'GET',
    headers: getHeaders()

  });
  const usuarios = await request.json();




let listaUsuariosHtml= '';  //un string global


  for(let usuario of usuarios){ //la variable objeto de la clase usuario recorre el arraylist creado de la clase usuario

let botonEliminar=  '<a href="#"    onclick= "eliminarUsuario('+ usuarios.id+')"  class="btn btn-danger btn-circle btn-sm"><i class="fas fa-trash"></i>  </a>';



//creamos un string en donde pondremos todo el html

let usuarioHtml= '<tr>  <td>'+ usuarios.id+  '</td><td>'  +usuarios.nombre+ ' </td><td>' +usuarios.apellido+    '</td><td>'  +usuarios.email+  '</td><td>'   + usuarios.password +' </td><td>' +botonEliminar+ '</td></tr>';

listaUsuariosHtml += usuarioHtml;  //pasamos el string dentro del for each al global.

  }




 // console.log(usuarios);

//let usuarioHtml='" <tr><td>123</td><td>Samuel</td><td>Luduena</td><td>samsoad@hotmail.com</td><td>1124089812</td><td><a href="#" class="btn btn-danger btn-circle btn-sm"><i class="fas fa-trash"></i></a></td></tr>"'




//document.querySelector('#usuarios tbody').outerHTML = usuario;

document.querySelector('#usuarios tbody').outerHTML = listaUsuariosHtml;  //cargamos el string de lista de usuarios global dentro del html.


}





//funcion para reutilizar los headers (esto sera para cada metodo)
function getHeaders(){

return{
'Accept': 'application/json',
      'Content-Type': 'application/json',
      'Authorization': localStorage.token

};

}





async function eliminarUsuario(id){
//alert(id);


if(!confirm  ('Desea eliminar este usuario?')   ){
return;
}



  const request = await fetch('api/usuarios/' + id, {
    method: 'DELETE',

   /*
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json',
      'Authorization': localStorage.token
    }*/

    headers: getHeaders()


  });

  location.reload;


}
