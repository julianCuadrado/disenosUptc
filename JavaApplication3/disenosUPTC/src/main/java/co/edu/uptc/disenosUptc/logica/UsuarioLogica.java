/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uptc.disenosUptc.logica;

import co.edu.uptc.disenosUptc.DAO.UsuarioDAO;
import co.edu.uptc.disenosUptc.entities.AdministradorEmpresa;
import co.edu.uptc.disenosUptc.entities.Fotografia;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Usuario
 */
@Stateless
public class UsuarioLogica {
    
    @EJB
    private UsuarioDAO usuarioDAO;

    public List<AdministradorEmpresa> getProyectos() {
        List<AdministradorEmpresa> lista  =  usuarioDAO.getProyectos();
        return lista;
    }
    
    public List<Fotografia> getFotografias(int id){
        return usuarioDAO.getFotografias(id);
    }

    public void agregarFotografia(Fotografia f, int idProyecto) {
        usuarioDAO.agregarFotografia(f, idProyecto);
    }
}
