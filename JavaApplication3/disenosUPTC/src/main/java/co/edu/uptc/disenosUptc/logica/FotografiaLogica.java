/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package co.edu.uptc.disenosUptc.logica;

import co.edu.uptc.disenosUptc.DAO.FotografiaDAO;
import co.edu.uptc.disenosUptc.entities.Estado;
import co.edu.uptc.disenosUptc.entities.Fotografia;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Schedule;
import javax.ejb.Stateless;
import utilitis.PruebaCorreo;
import utilitis.RedimencionarImagen;

/**
 *
 * @author Julian
 */
@Stateless
public class FotografiaLogica {
    
    @EJB
    private FotografiaDAO fotografiaDAO;
    
    public List<Fotografia> getFotografias(int idProyecto) {
        
        return fotografiaDAO.getFotografias(idProyecto);
    }
    
    @Schedule(minute = "*", hour = "*", second = "0/30", persistent = false)
    public void proceso() {
        System.out.println("entro al batch");
        SimpleDateFormat simple = new SimpleDateFormat("yyyy-MM-dd_hh_mm_ss");
        SimpleDateFormat simple2 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        List<Fotografia> list = fotografiaDAO.getFotografiasEstado();
        String name = "";
        for (Fotografia fotografia : list) {
            name = fotografia.getProyecto().getId() +""+simple.format(fotografia.getFechaCreacion()) + ".png";
            String urlSalida = "C:/Users/Usuario/Documents/NetBeansProjects/disenosUptc/src/main/webapp/imgModificadas/" + name;
            RedimencionarImagen.copyImage(fotografia.getRutaOriginal(), urlSalida, fotografia.getNombresFotografo(), simple2.format(fotografia.getFechaCreacion()));
            fotografia.setEstado(Estado.DISPONIBLE);
            fotografia.setRutaModificada("../imgModificadas/"+name);
            PruebaCorreo.enviarConGMail("Confirmacion Diseños UPTC", "Tu fotografía ya ha sido publicada en la página del administrador", fotografia.getCorreo());
        }
    }

    public List<Fotografia> getAllFotografias() {
        return fotografiaDAO.getAllFotografias();
    }
}