/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uptc.disenosUptc.logica;

import co.edu.uptc.disenosUptc.DAO.AdministradorEmpresaDAO;
import co.edu.uptc.disenosUptc.entities.AdministradorEmpresa;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Julian
 */
@Stateless
public class AdministradorEmpresaLogica {
    
    @EJB
    private AdministradorEmpresaDAO administradorEmpresaDAO;

    public void agregarAdministradorEmpresa(AdministradorEmpresa administradorEmpresa) {
        administradorEmpresaDAO.agregarAdministradorEmpresa(administradorEmpresa);
    }

    public AdministradorEmpresa iniciarSesion(String correo, String contrasenia) {
        return administradorEmpresaDAO.iniciarSesion(correo, contrasenia);
    }
}
