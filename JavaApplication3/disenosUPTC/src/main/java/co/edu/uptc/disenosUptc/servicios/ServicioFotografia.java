/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uptc.disenosUptc.servicios;

import co.edu.uptc.disenosUptc.entities.Fotografia;
import co.edu.uptc.disenosUptc.logica.FotografiaLogica;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

/**
 *
 * @author Julian
 */
@Path("ServicioFotografia")
public class ServicioFotografia {
    
    @EJB
    private FotografiaLogica fotografiaLogica;
    
    @GET
    public List<Fotografia> getFotografias(@QueryParam("id") int idProyecto){
        return fotografiaLogica.getFotografias(idProyecto);
    }
}
