/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uptc.disenosUptc.logica;

import co.edu.uptc.disenosUptc.DAO.ProyectoDAO;
import co.edu.uptc.disenosUptc.entities.Proyecto;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Julian
 */
@Stateless
public class ProyectoLogica {
    
    @EJB
    private ProyectoDAO proyectoDAO;

    public List<Proyecto> getProyectos(int id) {
        return proyectoDAO.getProyectos(id);
    }
}
