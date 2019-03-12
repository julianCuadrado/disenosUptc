/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uptc.disenosUptc.logica;

import co.edu.uptc.disenosUptc.DAO.FotografiaDAO;
import co.edu.uptc.disenosUptc.entities.Fotografia;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

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
}
