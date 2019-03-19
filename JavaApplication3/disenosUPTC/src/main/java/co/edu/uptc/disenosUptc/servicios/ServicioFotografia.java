/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uptc.disenosUptc.servicios;

import co.edu.uptc.disenosUptc.entities.Fotografia;
import co.edu.uptc.disenosUptc.logica.FotografiaLogica;
import java.util.ArrayList;
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
        List<Fotografia> lista = fotografiaLogica.getFotografias(idProyecto);
        List<Fotografia> temp = new ArrayList<>();
        for (int i = 0; i < lista.size(); i++) {
            Fotografia f = new Fotografia();
            f.setApellidosFotografo(lista.get(i).getApellidosFotografo());
            f.setCorreo(lista.get(i).getCorreo());
            f.setFechaCreacion(lista.get(i).getFechaCreacion());
            f.setId(lista.get(i).getId());
            f.setNombresFotografo(lista.get(i).getNombresFotografo());
            f.setPrecioSolicitado(lista.get(i).getPrecioSolicitado());
            f.setRutaModificada(lista.get(i).getRutaModificada());
            f.setRutaOriginal(lista.get(i).getRutaOriginal());
            temp.add(f);
        }
        return temp;
    }
    
    @GET
    @Path("/todas")
    public List<Fotografia> getAllFotografias(){
        List<Fotografia> lista = fotografiaLogica.getAllFotografias();
        List<Fotografia> temp = new ArrayList<>();
        for (int i = 0; i < lista.size(); i++) {
            Fotografia f = new Fotografia();
            f.setApellidosFotografo(lista.get(i).getApellidosFotografo());
            f.setCorreo(lista.get(i).getCorreo());
            f.setFechaCreacion(lista.get(i).getFechaCreacion());
            f.setId(lista.get(i).getId());
            f.setNombresFotografo(lista.get(i).getNombresFotografo());
            f.setPrecioSolicitado(lista.get(i).getPrecioSolicitado());
            f.setRutaModificada(lista.get(i).getRutaModificada());
            f.setRutaOriginal(lista.get(i).getRutaOriginal());
            temp.add(f);
        }
        return temp;
    }
}
