/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package co.edu.uptc.disenosUptc.DAO;

import co.edu.uptc.disenosUptc.entities.Estado;
import co.edu.uptc.disenosUptc.entities.Fotografia;
import co.edu.uptc.disenosUptc.entities.Proyecto;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Julian
 */
@Stateless
public class FotografiaDAO {
    
    @PersistenceContext
    private EntityManager em;
    
    public List<Fotografia> getFotografias(int idProyecto) {
        Query query = em.createQuery("Select f from Fotografia f where f.proyecto.id= :idP order by f.fechaCreacion desc");
        query.setParameter("idP", idProyecto);
        return query.getResultList();
    }
}
