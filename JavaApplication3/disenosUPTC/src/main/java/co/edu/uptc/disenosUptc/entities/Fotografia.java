/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uptc.disenosUptc.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author Julian
 */
@Entity
public class Fotografia implements Serializable{
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    private String rutaOriginal;
    private String rutaModificada;
    private Date fechaCreacion;
    private double precioSolicitado;
    @Enumerated(EnumType.STRING)
    private Estado estado;
    private String nombresFotografo;
    private String apellidosFotografo;
    private String correo;
    @ManyToOne
    private Proyecto proyecto;

    public Fotografia() {
    }

    
    
    public String getRutaOriginal() {
        return rutaOriginal;
    }

    public void setRutaOriginal(String rutaOriginal) {
        this.rutaOriginal = rutaOriginal;
    }

    public String getRutaModificada() {
        return rutaModificada;
    }

    public void setRutaModificada(String rutaModificada) {
        this.rutaModificada = rutaModificada;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
    
    

    @Override
    public String toString() {
        return "Fotografia{" + "id=" + id + ", rutaOriginal=" + rutaOriginal + ", rutaModificada=" + rutaModificada + ", fechaCreacion=" + fechaCreacion + ", precioSolicitado=" + precioSolicitado + ", estado=" + estado + ", nombresFotografo=" + nombresFotografo + ", apellidosFotografo=" + apellidosFotografo + ", correo=" + correo + '}';
    }
}
