
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


    public String validarUsuario(String nombreUsuario, String contraseniaUsuario) {
        List<Usuario> listaUsuarios = new ArrayList<Usuario>();
        
        listaUsuarios= controlPersis.traerUsuarios();
        
        for(Usuario usuarito: listaUsuarios){
            if(usuarito.getUsuario().equals(nombreUsuario)){
                if(usuarito.getContrasenia().equals(contraseniaUsuario)){
                    return "Logueo exitoso";
                }
                return "Contraseña invalida";
            }    
        }
        return "El usuario  no existe";
    }
    
}
