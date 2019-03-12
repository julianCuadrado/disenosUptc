/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uptc.disenosUptc.DAO;

import co.edu.uptc.disenosUptc.entities.AdministradorEmpresa;
import co.edu.uptc.disenosUptc.entities.Fotografia;
import co.edu.uptc.disenosUptc.entities.Proyecto;
import javax.ejb.Stateless;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Usuario
 */
@Stateless
public class UsuarioDAO {

    @PersistenceContext
    private EntityManager em;

    public List<AdministradorEmpresa> getProyectos() {
        Query query = em.createQuery("Select e from AdministradorEmpresa e");
        return query.getResultList();
    }

    public List<Fotografia> getFotografias(int id) {
        Query query = em.createQuery("Select e from Fotografia e where e.proyecto.id="+ id +" order by e.fechaCreacion desc");
        return query.getResultList();
    }

    public void agregarFotografia(Fotografia f, int idProyecto) {
        Proyecto p = em.find(Proyecto.class, idProyecto);
        f.setProyecto(p);
        em.persist(f);
    }

}
