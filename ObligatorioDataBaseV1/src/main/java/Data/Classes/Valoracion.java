/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data.Classes;

/**
 *
 * @author USER
 */
public class Valoracion {
    public String calificador, calificado, observaciones;
    public int calificacion;
 
    public Valoracion(String calificador, String calificado, int calificacion, String observaciones) {
        this.calificador = calificador;
        this.calificado = calificado;
        this.observaciones = observaciones;
        this.calificacion = calificacion;
    }

    public String getCalificador() {
        return calificador;
    }

    public void setCalificador(String calificador) {
        this.calificador = calificador;
    }

    public String getCalificado() {
        return calificado;
    }

    public void setCalificado(String calificado) {
        this.calificado = calificado;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }


    
}
