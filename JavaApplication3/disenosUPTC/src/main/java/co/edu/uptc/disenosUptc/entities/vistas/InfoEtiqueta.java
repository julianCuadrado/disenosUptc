/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uptc.disenosUptc.entities.vistas;

/**
 *
 * @author Usuario
 */
public class InfoEtiqueta {
    private int id;
    private String name;
    private String descrip;

    public InfoEtiqueta(int id, String name, String descrip) {
        this.id = id;
        this.name = name;
        this.descrip = descrip;
    }

    public String getDescrip() {
        return descrip;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    
}
