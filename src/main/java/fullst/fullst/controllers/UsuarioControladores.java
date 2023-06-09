package fullst.fullst.controllers;


import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import fullst.fullst.dao.UsuariosDao;
import fullst.fullst.models.Usuario;
import fullst.fullst.utils.JWTutil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController //con rest controller le indicamos que la clase actuara como controlador de urls.


public class UsuarioControladores {


  //  @RequestMapping(value = "prueba")

/*
    public List<String> prueba(){
        return List.of("manzana","kiwi","banana");

    }
*/

//esto ya se llama inyeccion de dependencias
    //esta anotacion hace que automaticamente la clase usuariodaoImpl cree un objeto y la guarde dentro del objeto usuarioDao.
@Autowired
    private UsuariosDao usuariosDao;




@Autowired
private JWTutil jwTutil;


//podemos poner / y escribir el id del usuario, pasa que siempre tendremos que poner lo mismo en la url.
    // lo podemos hacer dinamico poniendo en lugar del numero: {id}. Entonces en la url pondremos usuario, barra el numero que querramos.




    //aca llamamos al id de un solo usuario
/*
    @RequestMapping(value = "usuario/{id}")
    public Usuario getUsuary(@PathVariable Long id){

        Usuario us= new Usuario();

        us.setId(id);
        us.setNombre("samu");
        us.setApellido("luduena");
        us.setEmail("samsoad@hotmail.com");
        us.setPassword("1234");

        return us;

    }
*/


//creamos una nueva lista que hace referencia a usuariosDao
    //le retornamos el objeto usuariosDao que almacena el objeto de usuariosDaoImpl gracias a la anotacion autowired (inyeccion de dependencia)


//le agregamos la palabra api para hacerlo mas organizado

  //  @RequestMapping(value = "api/usuarios", method = RequestMethod.GET)





    @RequestMapping(value = "api/usuarios", method = RequestMethod.GET)
    //guardamos el token que tenemos en la cabecera dentro de la variable token del parametro gracias a la anotacion de requestheader
    public List<Usuario>getUsuarios(@RequestHeader(value= "Authorization") String token) {

/*
String idUs = jwTutil.getKey(token);

if(idUs == null){

    return new ArrayList<>();
}
*/

        if(!validaToken(token)){

            return null;
        }


return usuariosDao.getUsuarios();

    }





    private boolean validaToken(String token){


        String idUs = jwTutil.getKey(token);

   return idUs !=null;
    }





//con requestbody convertimos el json que recibe a un usuario automaticamente
    @RequestMapping(value = "api/usuarios",method= RequestMethod.POST)
    public void RegistrarUsuarios(@RequestBody Usuario usuario) {

//esta seria la libreria de hash
Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);

//procesa la contraseña en la codificacion. las iteraciones son la cantidad de veces que queremos que haga el proceso
String hashh= argon2.hash(1,1024,1,usuario.getPassword());
//al establecer este hasheo, la contraseña en la base de datos sera mas larga por lo que conviene añadir un varchar minimo de 300 al campo password
        //de la base de datos para que no de error de "jwt must contain 2 characters" o directamente falle el logueo.
        //Tambien puede fallar la iteracion del objeto usuarios que quiere recorrer por lo que se mostrara en la base de datos el usuario añadido
        // y no en el frontend.




usuario.setPassword(hashh); //esta contraseña la tenemos que encriptar con un hash y para eso importamos una libreria.


        usuariosDao.Registrar(usuario);

    }



    @RequestMapping(value = "api/usuarios/{id}",method= RequestMethod.DELETE)
    public void eliminar(@RequestHeader(value= "Authorization") String token,
                         @PathVariable Long id){


        if(!validaToken(token)){

            return;
        }

     usuariosDao.eliminar(id);

    }


    @RequestMapping(value = "usuarios")
    public Usuario modificar(){

        Usuario us= new Usuario();

        us.setNombre("samu");
        us.setApellido("luduena");
        us.setEmail("samsoad@hotmail.com");
        us.setPassword("1234");

        return us;

    }


    @RequestMapping(value = "usuario/1")
    public Usuario buscar(){

        /*
        if(!validaToken(token)){

            return null;
        }
*/
        Usuario us= new Usuario();

        us.setNombre("samu");
        us.setApellido("luduena");
        us.setEmail("samsoad@hotmail.com");
        us.setPassword("1234");

        return us;
    }




//aca llamamos a una lista de usuarios

/*
    @RequestMapping(value = "usuarios")
    public List<Usuario> getUsuario(){


        List<Usuario> usuarios = new ArrayList<>();
        Usuario us1= new Usuario();

        us1.setId(234L);
        us1.setNombre("samu");
        us1.setApellido("luduena");
        us1.setEmail("samsoad@hotmail.com");
        us1.setPassword("1234");


        Usuario us2= new Usuario();
        us2.setId(434L);
        us2.setNombre("rodrigo");
        us2.setApellido("luduena");
        us2.setEmail("ramsoad@hotmail.com");
        us2.setPassword("1234");

        Usuario us3= new Usuario();
        us3.setId(34L);
        us3.setNombre("patricio");
        us3.setApellido("luduena");
        us3.setEmail("pamsoad@hotmail.com");
        us3.setPassword("1234");


        Usuario us4= new Usuario();
        us4.setId(3434L);
        us4.setNombre("francisco");
        us4.setApellido("luduena");
        us4.setEmail("famsoad@hotmail.com");
        us4.setPassword("1234");

        Usuario us5= new Usuario();
        us5.setId(233L);
        us5.setNombre("logelio");
        us5.setApellido("luduena");
        us5.setEmail("lamsoad@hotmail.com");
        us5.setPassword("1234");


        usuarios.add(us1);
        usuarios.add(us2);
        usuarios.add(us3);
        usuarios.add(us4);
        usuarios.add(us5);


        return usuarios;

    }

*/

/*
    @RequestMapping(value = "usuarios/234")
    public Usuario modificar(){

        Usuario us= new Usuario();

        us.setNombre("samu");
        us.setApellido("luduena");
        us.setEmail("samsoad@hotmail.com");
        us.setPassword("1234");

        return us;

    }

    @RequestMapping(value = "usuario/24")
    public Usuario eliminar(){

        Usuario us= new Usuario();

        us.setNombre("samu");
        us.setApellido("luduena");
        us.setEmail("samsoad@hotmail.com");
        us.setPassword("1234");

        return us;

    }

    @RequestMapping(value = "usuario/25")
    public Usuario buscar(){

        Usuario us= new Usuario();

        us.setNombre("samu");
        us.setApellido("luduena");
        us.setEmail("samsoad@hotmail.com");
        us.setPassword("1234");

        return us;

    }

*/







    //RequestMapping indica la url que recibira al devolver el valor de la funcion prueba

  /*
    public String prueba(){

        return "prueba";
    }
    */





}
