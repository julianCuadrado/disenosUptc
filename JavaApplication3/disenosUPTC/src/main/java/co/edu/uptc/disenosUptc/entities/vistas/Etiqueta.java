/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uptc.disenosUptc.entities.vistas;

import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class Etiqueta {
    private String name;
    private ArrayList<InfoEtiqueta> list;

    public Etiqueta(String name) {
        this.name = name;
        list = new ArrayList<>();
    }
    
    public void addInfo(InfoEtiqueta info){
        list.add(info);
    }

    public ArrayList<InfoEtiqueta> getList() {
        return list;
    }

    public String getName() {
        return name;
    }
    
    
    
    
}
