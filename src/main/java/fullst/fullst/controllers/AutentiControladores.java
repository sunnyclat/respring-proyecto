package fullst.fullst.controllers;

import fullst.fullst.dao.UsuariosDao;
import fullst.fullst.models.Usuario;
import fullst.fullst.utils.JWTutil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AutentiControladores {


    @Autowired
    private UsuariosDao usuariosDao;


    //usamos el autowired para tener la clase jwtutil cargada y que se inyecten las dependencias necesarias.
@Autowired
    private JWTutil jwTutil;


    @RequestMapping(value = "api/login",method= RequestMethod.POST)

    public String login(@RequestBody Usuario usuario) {


Usuario logUs= usuariosDao.UsuarioVerificaciones(usuario);
       if(logUs !=null ){


           //vamos a crear aca el JWT

           String token =jwTutil.create(  String.valueOf   (logUs.getId() ),(logUs.getEmail() )     );

                return token;
       }
return "FAIL";
    }
}
