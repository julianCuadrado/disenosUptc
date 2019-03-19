/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uptc.disenosUptc.servicios;

import co.edu.uptc.disenosUptc.entities.AdministradorEmpresa;
import co.edu.uptc.disenosUptc.logica.AdministradorEmpresaLogica;
import java.util.HashMap;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

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
        HashMap<String, Object> w = new HashMap<>();
        AdministradorEmpresa a = administradorEmpresaLogica.iniciarSesion((String) d.get("correo"), (String) d.get("contrasenia"));
        AdministradorEmpresa s = new AdministradorEmpresa();
        if(a != null){
            s.setContrasenia(a.getContrasenia());
            s.setCorreo(a.getCorreo());
            s.setId(a.getId());
            s.setNombreEmpresa(a.getNombreEmpresa());
            w.put("administrador", s);
            return w;
        }else{
            w.put("administrador", a);
            return w;
        }
    }
}
