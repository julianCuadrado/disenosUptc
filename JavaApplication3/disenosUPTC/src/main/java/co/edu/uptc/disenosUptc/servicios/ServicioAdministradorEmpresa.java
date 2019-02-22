/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uptc.disenosUptc.servicios;

import co.edu.uptc.disenosUptc.entities.AdministradorEmpresa;
import co.edu.uptc.disenosUptc.logica.AdministradorEmpresaLogica;
import java.util.HashMap;
import javax.ejb.EJB;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

/**
 *
 * @author Julian
 */
@Path("ServicioAdministradorEmpresa")
public class ServicioAdministradorEmpresa {
    
    @EJB
    private AdministradorEmpresaLogica administradorEmpresaLogica;
    
    @POST
    public void agregarAdministradorEmpresa(AdministradorEmpresa administradorEmpresa){
        administradorEmpresaLogica.agregarAdministradorEmpresa(administradorEmpresa);
    }
    
    @POST
    @Path("/atenticarse")
    public HashMap iniciarSesion(HashMap d) {
        HashMap<String, AdministradorEmpresa> w = new HashMap<>();
        w.put("administrador", administradorEmpresaLogica.iniciarSesion((String) d.get("correo"), (String) d.get("contrasenia")));
        return w;
    }
}
