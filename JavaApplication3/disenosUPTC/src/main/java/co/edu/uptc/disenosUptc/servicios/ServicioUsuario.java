/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uptc.disenosUptc.servicios;

import co.edu.uptc.disenosUptc.entities.AdministradorEmpresa;
import co.edu.uptc.disenosUptc.entities.Estado;
import co.edu.uptc.disenosUptc.entities.Fotografia;
import co.edu.uptc.disenosUptc.entities.Proyecto;
import co.edu.uptc.disenosUptc.entities.vistas.Etiqueta;
import co.edu.uptc.disenosUptc.entities.vistas.InfoEtiqueta;
import co.edu.uptc.disenosUptc.logica.UsuarioLogica;
import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import javax.ejb.EJB;
import javax.imageio.ImageIO;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

/**
 *
 * @author Usuario
 */
@Path("serviciousuario")
public class ServicioUsuario {
    
    @EJB
    private UsuarioLogica usuarioLogica;

    @GET
    public ArrayList<Etiqueta> garAdministradores() {
        ArrayList<Etiqueta> salida = new ArrayList<>();
        List<AdministradorEmpresa> aux = usuarioLogica.getProyectos();
        for (AdministradorEmpresa admin : aux) {
            Etiqueta etiqueta = new Etiqueta(admin.getNombreEmpresa());
            List<Proyecto> proyectos = admin.getProyectos();
            for (Proyecto p : proyectos) {
                etiqueta.addInfo(new InfoEtiqueta(p.getId(), p.getNombre(), p.getDescripcion()));
            }
            salida.add(etiqueta);
        }
        return salida;
    }
    
    @GET
    @Path("/consultafotos")
    public List<Fotografia> getListaFotos(@QueryParam("id_proyecto") int id){
        List<Fotografia> lista = usuarioLogica.getFotografias(id);
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
    
    @POST
    public void agregarFotografia(HashMap d) throws IOException{
        Fotografia f = new Fotografia();
        f.setApellidosFotografo((String) d.get("apellidoF"));
        f.setCorreo((String) d.get("correo"));
        f.setEstado(Estado.EN_PROCESO);
        f.setFechaCreacion(new Date());
        f.setNombresFotografo((String) d.get("nombreF"));
        f.setPrecioSolicitado(Double.parseDouble(""+d.get("precio")));
        SimpleDateFormat simple = new SimpleDateFormat("yyyy-mm-dd_hh_mm_ss");
        String fecha = simple.format(f.getFechaCreacion());
        String ruta = "C:/Users/Usuario/Documents/NetBeansProjects/disenosUptc/src/main/webapp/imagesOriginales/"+d.get("idP")+fecha+".png";
        f.setRutaOriginal(ruta);
        f.setRutaModificada("../images/defecto.jpg");
        String strDrawableB64 = (String) d.get("foto");
        String t =  strDrawableB64.substring(strDrawableB64.indexOf(",")+1);
        byte[] drawableB64 = Base64.decode(t);
        FileOutputStream fos = new FileOutputStream(ruta);
        fos.write(drawableB64);
        fos.close();
        usuarioLogica.agregarFotografia(f,Integer.parseInt(""+d.get("idP")));
    }
}