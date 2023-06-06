package fullst.fullst.dao;


import fullst.fullst.models.Usuario;

import java.util.List;

public interface UsuariosDao {

   List<Usuario> getUsuarios();

   void eliminar(Long id);

   void Registrar(Usuario usuario);


   //boolean verificaciones(Usuario usuario);


   Usuario UsuarioVerificaciones(Usuario usuario);
}
