
package com.mycompany.loginejercicio.logica;

import com.mycompany.loginejercicio.persistencia.ControladoraPersistencia;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Martin
 */
public class ControladoraLogica {

    ControladoraPersistencia controlPersis = new ControladoraPersistencia();


    public Usuario validarUsuario(String nombreUsuario, String contraseniaUsuario) {
        List<Usuario> listaUsuarios = new ArrayList<Usuario>();
        Usuario usu =null;
        listaUsuarios= controlPersis.traerUsuarios();
        
        for(Usuario usuarito: listaUsuarios){
            if(usuarito.getUsuario().equals(nombreUsuario)){
                if(usuarito.getContrasenia().equals(contraseniaUsuario)){
                    usu=usuarito;
                    return usu;
                }
                usu = null;
                return usu;
            }    
        }
        usu = null;
        return usu;
    }

    public List<Usuario> traerUsuarios() {
        return controlPersis.traerUsuarios();
    }

    public List<Rol> traerRoles() {
        return controlPersis.traerRoles();
    }

    public void crearUsuario(String nombreUsuario, String contrasenia, String rolRecibido) {
        Usuario usuario = new Usuario();
        usuario.setUsuario(nombreUsuario);
        usuario.setContrasenia(contrasenia);
        
        Rol rolEncontrado = new Rol();
        rolEncontrado = this.traerRol(rolRecibido);
        if(rolEncontrado!=null){
            usuario.setUnRol(rolEncontrado);
        }
        controlPersis.crearUsuario(usuario);
        
    }

    private Rol traerRol(String rolRecibido) {
        List<Rol>listaRoles = controlPersis.traerRoles();
        for(Rol rolsito: listaRoles){
            if(rolsito.getNombreRol().equals(rolRecibido)){
                return rolsito;
            }
        }
        return null;
    }
    
    public void eliminarUsuario(int idUsuario){
        controlPersis.eliminarUsuario(idUsuario);
    }

    public Usuario traerUsuario(int idUsuario) {
        return controlPersis.traerUsuario(idUsuario);
    }

    public void editarUsuario(Usuario usuarioo, String nombreUsuario, String contrasenia, String rolRecibido) {
        usuarioo.setUsuario(nombreUsuario);
        usuarioo.setContrasenia(contrasenia);
        
        Rol rolEncontrado = new Rol();
        rolEncontrado = this.traerRol(rolRecibido);
        if(rolEncontrado!=null){
            usuarioo.setUnRol(rolEncontrado);
        }
        controlPersis.editarUsuario(usuarioo);
        
        
        
        
    }

    
    
}
