/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uptc.disenosUptc.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author Julian
 */
@Entity
public class Fotografia implements Serializable{
    
    @Id
    private int id;
    private String ruta;
    private Date fechaCreacion;
    private double precioSolicitado;
    private Estado estado;
    private String nombresFotografo;
    private String apellidosFotografo;
    private String correo;
    @ManyToOne
    private Proyecto proyecto;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public double getPrecioSolicitado() {
        return precioSolicitado;
    }

    public void setPrecioSolicitado(double precioSolicitado) {
        this.precioSolicitado = precioSolicitado;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public String getNombresFotografo() {
        return nombresFotografo;
    }

    public void setNombresFotografo(String nombresFotografo) {
        this.nombresFotografo = nombresFotografo;
    }

    public String getApellidosFotografo() {
        return apellidosFotografo;
    }

    public void setApellidosFotografo(String apellidosFotografo) {
        this.apellidosFotografo = apellidosFotografo;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Proyecto getProyecto() {
        return proyecto;
    }

    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    }
    
    
}
