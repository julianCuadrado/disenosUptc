/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uptc.disenosUptc.DAO;

import co.edu.uptc.disenosUptc.entities.AdministradorEmpresa;
import co.edu.uptc.disenosUptc.entities.Fotografia;
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
        List<Proyecto> li = em.createQuery("Select p from Proyecto p where p.administradorEmpresa.id="+ id).getResultList();
        for (int i = 0; i < li.size(); i++) {
            li.get(i).setFotografias(null);
        }
        return li;
    }

    public void guardarProyecto(Proyecto proyecto) {
        em.persist(proyecto);
    }

    public void removerProyecto(int id) {
        em.createQuery("delete from Proyecto p where p.id = " + id).executeUpdate();
    }

    public void editarProyecto(Proyecto proyecto) {
        em.merge(proyecto);
    }

    public List<Proyecto> getAllProyectos() {
        List<Proyecto> listP = em.createQuery("Select p from Proyecto p").getResultList();
        return listP;
    }
}