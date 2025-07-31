
package com.mycompany.loginejercicio.persistencia;

import com.mycompany.loginejercicio.logica.Rol;
import com.mycompany.loginejercicio.logica.Usuario;
import com.mycompany.loginejercicio.persistencia.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Martin
 */
public class ControladoraPersistencia {

    UsuarioJpaController usuarioJpa = new UsuarioJpaController();
    RolJpaController rolJpa = new RolJpaController();
    

    public List<Usuario> traerUsuarios() {
        return usuarioJpa.findUsuarioEntities();
    }

    public List<Rol> traerRoles() {
        
        return rolJpa.findRolEntities();    //SELECT * FROM Roles
    }

    public void crearUsuario(Usuario usuario) {
        usuarioJpa.create(usuario);
    }
    
    public void eliminarUsuario(int idUsuario){
        try {
            usuarioJpa.destroy(idUsuario);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Usuario traerUsuario(int idUsuario) {
        return usuarioJpa.findUsuario(idUsuario);
    }

    public void editarUsuario(Usuario usuarioo) {
        try {
            usuarioJpa.edit(usuarioo);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
