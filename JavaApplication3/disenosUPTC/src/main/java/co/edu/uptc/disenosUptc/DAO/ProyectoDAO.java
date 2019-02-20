/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uptc.disenosUptc.DAO;

import co.edu.uptc.disenosUptc.entities.Proyecto;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Julian
 */
@Stateless
public class ProyectoDAO {
    
    @PersistenceContext
    private EntityManager em;

    public List<Proyecto> getProyectos(int id) {
        return em.createQuery("Select p from Proyecto p where p.administradorEmpresa.id="+ id).getResultList();
    }
}