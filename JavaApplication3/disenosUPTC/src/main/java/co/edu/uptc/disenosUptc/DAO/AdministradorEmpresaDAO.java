/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uptc.disenosUptc.DAO;

import co.edu.uptc.disenosUptc.entities.AdministradorEmpresa;
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
public class AdministradorEmpresaDAO {
    
    @PersistenceContext
    private EntityManager em;

    public void agregarAdministradorEmpresa(AdministradorEmpresa administradorEmpresa) {
        em.persist(administradorEmpresa);
    }

    public AdministradorEmpresa iniciarSesion(String correo, String contrasenia) {
        String consulta ="Select a from AdministradorEmpresa a where a.correo = '"+correo+"' and a.contrasenia = '"+ contrasenia+"'";
        List<AdministradorEmpresa> administradorEmpresa =em.createQuery(consulta).getResultList();
        if(administradorEmpresa.isEmpty()){
            return null;
        }else{
            AdministradorEmpresa s = administradorEmpresa.get(0);
            s.setProyectos(null);
            return s;
        }
    }
}