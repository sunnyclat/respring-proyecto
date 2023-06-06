package fullst.fullst.dao;

import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import fullst.fullst.models.Usuario;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional

//repository hace referencia a la funcionalidad de poder acceder al repositorio de la base de datos
//transactional hace referencia a como va a tratar las consultas de sql, como las va a armar y ejecutar, en fragmentos de transaccion.
//si transactional no aparece, poner add maven depency y elegir el que viene de springboot annotation.


public class UsuariosDaoImpl implements UsuariosDao {

//control de persistencia a los cambios que vayan ocurriendo en una transaccion
@PersistenceContext
private EntityManager entityManager;    //nos sirve para hacer la conexion con la base de datos

    @Override
    @Transactional
    public List <Usuario> getUsuarios() {

        // vamos a trabajar con los objetos de nuestra clase en java dentro del lenguaje sql.




        String query = "FROM usuarios";
       List<Usuario> resultado =entityManager.createQuery(query).getResultList();  //aca se guardaran los listados que hagamos en la consulta query.
        return resultado;
    }

    @Override
    public void eliminar(Long id) {
        Usuario usuario = entityManager.find(Usuario.class,id);
        entityManager.remove(usuario);
    }

    @Override
    public void Registrar(Usuario usuario) {
entityManager.merge(usuario);
    }




/*
    @Override
    public boolean verificaciones(Usuario usuario) {
*/






/*

//Si en email insertamos lo siguiente, entonces en la query se va a cortar lo que se estaba ejecutando
// y podremos pasarle el 1=1 que siempre sera true y asi iniciar sesion en cualquier cuenta.
//esto se le llama inyeccion de sql, para intentar hackear una cuenta.

        String email="' OR 1=1 --";

        String query = "FROM Usuario WHERE email = '" + usuario.getEmail() +
                "' AND password= '" + usuario.getPassword() + "'";
*/





//de esta manera evitamos la inyeccion sql

  //      String query = "FROM Usuario WHERE email = : email AND password = : password";

/*
        List<Usuario> lista =entityManager.createQuery(query)
                .setParameter("email", usuario.getEmail() )
                .setParameter("password", usuario.getPassword() )
                .getResultList();
*/


/*
        if(lista.isEmpty()) {
            return false;
        }else{

            return true;

        }

*/


    @Override
    public Usuario UsuarioVerificaciones(Usuario usuario) {




      //vamos a hacer la implementacion de contraseña usando argon (encriptacion de contraseña)


        String query = "FROM usuarios WHERE email = : email";

        List<Usuario> lista =entityManager.createQuery(query)
                .setParameter("email", usuario.getEmail() )
                .getResultList();


        //con esto nos evitamos un null pointer en exception en el caso de que no haya contraseña en la base de datos
        if(lista.isEmpty()){
   //         return false;


            return null;
        }


        String passwordEncript= lista.get(0).getPassword();


        Argon2 argon2= Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
    //   boolean mismaPass= argon2.verify(passwordEncript,usuario.getPassword()); //comparamos la contraseña de la base de datos con la que le estamos pasando para ver si es la misma o no.






//return mismaPass;

//la verificacion la ponemos en un if y devolvemos la posicion 0 del usuario.
      if(argon2.verify(passwordEncript,usuario.getPassword()))  {
          return lista.get(0);  //retornamos el primer valor de la lista
      }


return null;


    }
}
