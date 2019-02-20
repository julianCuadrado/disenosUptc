/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uptc.disenosUptc.config;

import java.util.Set;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
/**
 *
 * @author Julian
 */
@ApplicationPath("webresources")
public class RegisterConfig extends Application{
    
    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(co.edu.uptc.disenosUptc.servicios.ServicioAdministradorEmpresa.class);
        resources.add(co.edu.uptc.disenosUptc.servicios.ServicioFotografia.class);
        resources.add(co.edu.uptc.disenosUptc.servicios.ServicioProyecto.class);
    }
}