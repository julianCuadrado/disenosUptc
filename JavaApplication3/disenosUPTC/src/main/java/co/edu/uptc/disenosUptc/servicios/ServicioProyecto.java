/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uptc.disenosUptc.servicios;

import co.edu.uptc.disenosUptc.entities.Proyecto;
import co.edu.uptc.disenosUptc.logica.ProyectoLogica;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

/**
 *
 * @author Julian
 */
@Path("ServicioProyecto")
public class ServicioProyecto {
    
    @EJB
    private ProyectoLogica proyectoLogica;
    
    @GET
    public List<Proyecto> getProyectos(@QueryParam("id") int id){
        return proyectoLogica.getProyectos(id);
    }
    
    @GET
    @Path("/all")
    public List<Proyecto> getAllProyectos(){
        return proyectoLogica.getAllProyectos();
    }
    
    @POST
    public void guardarProyecto(Proyecto proyecto){
        proyectoLogica.guardarProyecto(proyecto);
    }
    
    @DELETE
    @Path("/remove")
    public void removerProyecto(@QueryParam("id") int id){
        proyectoLogica.removerProyecto(id);
    }
    
    @PUT
    @Path("/edit")
    public void editarProyecto(Proyecto proyecto){
        proyectoLogica.editarProyecto(proyecto);
    }
}
