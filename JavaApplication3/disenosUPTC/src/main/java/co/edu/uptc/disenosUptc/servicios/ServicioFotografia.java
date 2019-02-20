/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uptc.disenosUptc.servicios;

import co.edu.uptc.disenosUptc.logica.FotografiaLogica;
import javax.ejb.EJB;
import javax.ws.rs.Path;

/**
 *
 * @author Julian
 */
@Path("ServicioFotografia")
public class ServicioFotografia {
    
    @EJB
    private FotografiaLogica fotografiaLogica;
}
