
package com.mycompany.loginejercicio.persistencia;

import com.mycompany.loginejercicio.logica.Usuario;
import java.util.List;

/**
 *
 * @author Martin
 */
public class ControladoraPersistencia {

    UsuarioJpaController usuarioJpa = new UsuarioJpaController();
    

    public List<Usuario> traerUsuarios() {
        return usuarioJpa.findUsuarioEntities();
    }
    
}
